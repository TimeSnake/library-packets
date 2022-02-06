package de.timesnake.basic.packets.util;

import de.timesnake.basic.packets.core.BukkitNmsParser;
import de.timesnake.basic.packets.core.UnsupportedPacketException;
import de.timesnake.basic.packets.util.listener.PacketPlayInListener;
import de.timesnake.basic.packets.util.listener.PacketPlayInModifyListener;
import de.timesnake.basic.packets.util.listener.PacketPlayOutListener;
import de.timesnake.basic.packets.util.listener.PacketPlayOutModifyListener;
import de.timesnake.basic.packets.util.packet.ExPacket;
import de.timesnake.basic.packets.util.packet.ExPacketPlayIn;
import de.timesnake.basic.packets.util.packet.ExPacketPlayOut;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.protocol.Packet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.*;
import java.util.logging.Level;

public class PacketManager implements Listener {

    private final HashMap<Packet<?>, ExPacketPlayOut> sentPacketsByNMSPacket = new HashMap<>();

    private boolean broadcast = false;

    private final Map<ExPacket.Type, Collection<PacketPlayOutModifyListener>> playOutModifyListeners = new HashMap<>();
    private final Map<ExPacket.Type, Collection<PacketPlayInModifyListener>> playInModifyListeners = new HashMap<>();

    private final Map<ExPacket.Type, Collection<PacketPlayOutListener>> playOutListeners = new HashMap<>();
    private final Map<ExPacket.Type, Collection<PacketPlayInListener>> playInListeners = new HashMap<>();

    public PacketManager(Plugin plugin) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(this, plugin);

        Bukkit.getLogger().log(Level.INFO, "[Packets] Loaded manager successfully");
    }

    public void addPacketPlayOutListener(ExPacket.Type packetType, PacketPlayOutModifyListener listener) {
        this.playOutModifyListeners.computeIfAbsent(packetType, (t) -> new HashSet<>()).add(listener);
    }

    public void addPacketPlayInListener(ExPacket.Type packetType, PacketPlayInModifyListener listener) {
        this.playInModifyListeners.computeIfAbsent(packetType, (t) -> new HashSet<>()).add(listener);
    }

    public void addPacketPlayOutListener(ExPacket.Type packetType, PacketPlayOutListener listener) {
        this.playOutListeners.computeIfAbsent(packetType, (t) -> new HashSet<>()).add(listener);
    }

    public void addPacketPlayInListener(ExPacket.Type packetType, PacketPlayInListener listener) {
        this.playInListeners.computeIfAbsent(packetType, (t) -> new HashSet<>()).add(listener);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        injectPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        removePlayer(event.getPlayer());
    }

    private void removePlayer(Player player) {
        Channel channel = BukkitNmsParser.getPlayerChannel(player);
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player.getName());
            return null;
        });
    }

    private void injectPlayer(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler(player);

        ChannelPipeline pipeline = BukkitNmsParser.getPlayerChannel(player).pipeline();
        pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);

    }

    private class ChannelDuplexHandler extends io.netty.channel.ChannelDuplexHandler {

        private final Player player;

        public ChannelDuplexHandler(Player player) {
            this.player = player;
        }

        @Override
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {

            if (!(packet instanceof Packet<?>)) {
                super.channelRead(channelHandlerContext, packet);
                return;
            }

            ExPacketPlayIn packetPlayIn = null;
            try {
                packetPlayIn = de.timesnake.basic.packets.core.packet.in.ExPacketPlayIn.getPacket(((Packet<?>) packet));
            } catch (UnsupportedPacketException e) {
                PacketManager.this.broadcast(e.getMessage());
            } catch (Exception e) {
                PacketManager.this.broadcast("Exception: " + e.getClass().getSimpleName() + " while " + "transforming play-in-packet");
            }

            if (packetPlayIn == null) {
                PacketManager.this.broadcast("PacketRead null");
                super.channelRead(channelHandlerContext, packet);
                return;
            }

            final ExPacketPlayIn exPacket = packetPlayIn;

            if (playInListeners.containsKey(packetPlayIn.getType())) {
                new Thread(() -> {
                    for (Map.Entry<ExPacket.Type, Collection<PacketPlayInListener>> entryList : PacketManager.this.playInListeners.entrySet()) {
                        if (entryList.getKey().containsSubType(exPacket.getType())) {
                            for (PacketPlayInListener listener : entryList.getValue()) {
                                listener.onPacketPlayIn(exPacket, player);
                            }
                        }
                    }
                }).start();
            }


            if (!playInModifyListeners.containsKey(packetPlayIn.getType())) {
                super.channelRead(channelHandlerContext, packet);
                return;
            }

            boolean block = false;

            for (Map.Entry<ExPacket.Type, Collection<PacketPlayInModifyListener>> entryList : PacketManager.this.playInModifyListeners.entrySet()) {
                if (entryList.getKey().containsSubType(packetPlayIn.getType())) {
                    for (PacketPlayInModifyListener listener : entryList.getValue()) {
                        ExPacketPlayIn editedPacket = listener.onPacketPlayIn(packetPlayIn, player);
                        if (editedPacket == null) {
                            block = true;
                        } else {
                            packetPlayIn = editedPacket;
                        }
                    }
                }
            }

            if (block) {
                return;
            }

            if (packetPlayIn != null) {
                super.channelRead(channelHandlerContext, packetPlayIn.getPacket());
            } else {
                super.channelRead(channelHandlerContext, packet);
            }
        }

        @Override
        public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {

            if (packet == null) {
                return;
            }

            if (!(packet instanceof Packet)) {
                super.write(channelHandlerContext, packet, channelPromise);
                return;
            }

            ExPacketPlayOut packetPlayOut = null;

            if (sentPacketsByNMSPacket.containsKey(packet)) {
                packetPlayOut = sentPacketsByNMSPacket.get(packet);
            } else {
                try {
                    packetPlayOut = de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut.getPacket(((Packet<?>) packet));
                } catch (UnsupportedPacketException e) {
                    PacketManager.this.broadcast(e.getMessage());
                } catch (Exception e) {
                    PacketManager.this.broadcast("Exception: " + e.getClass().getSimpleName() + " while " + "transforming play-out-packet");
                }
            }

            if (packetPlayOut == null) {
                PacketManager.this.broadcast("PacketWrite null");
                super.write(channelHandlerContext, packet, channelPromise);
                return;
            }



            /*
            if (de.timesnake.basic.packets.util.packet.ExPacket.Type.PLAY_OUT_TABLIST.containsSubType(packetPlayOut.getType())) {
                Bukkit.getLogger().log(Level.INFO, "Send " + packetPlayOut.getInfo() + " " + packetPlayOut.getType() + " to " + this.player.getName());
            }

             */

            final ExPacketPlayOut exPacket = packetPlayOut;

            new Thread(() -> {
                for (Map.Entry<ExPacket.Type, Collection<PacketPlayOutListener>> entryList : PacketManager.this.playOutListeners.entrySet()) {
                    if (entryList.getKey().containsSubType(exPacket.getType())) {
                        for (PacketPlayOutListener listener : entryList.getValue()) {
                            listener.onPacketPlayOut(exPacket, player);
                        }
                    }
                }
            }).start();

            boolean block = false;
            for (Map.Entry<ExPacket.Type, Collection<PacketPlayOutModifyListener>> entryList : PacketManager.this.playOutModifyListeners.entrySet()) {
                if (entryList.getKey().containsSubType(packetPlayOut.getType())) {
                    for (PacketPlayOutModifyListener listener : entryList.getValue()) {
                        ExPacketPlayOut editedPacket = listener.onPacketPlayOut(packetPlayOut, player);
                        if (editedPacket == null) {
                            block = true;
                        } else {
                            packetPlayOut = editedPacket;
                        }
                    }
                }
            }

            if (block) {
                return;
            }


            if (packetPlayOut != null) {
                super.write(channelHandlerContext, packetPlayOut.getPacket(), channelPromise);
            } else {
                super.write(channelHandlerContext, packet, channelPromise);
            }
        }
    }

    public void sendPacket(Player player, ExPacketPlayOut packet) {

        this.sentPacketsByNMSPacket.put(((de.timesnake.basic.packets.core.ExPacket) packet).getPacket(), packet);

        if (((de.timesnake.basic.packets.core.ExPacket) packet).getPacket() != null) {
            BukkitNmsParser.sendPacket(player, packet.getPacket());
        }
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean isBroadcast() {
        return broadcast;
    }

    public void broadcast(String text) {
        if (this.broadcast) {
            Bukkit.getLogger().log(Level.INFO, "[Packets] " + text);
        }
    }
}
