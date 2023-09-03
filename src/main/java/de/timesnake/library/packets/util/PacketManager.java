/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util;

import de.timesnake.library.basic.util.Loggers;
import de.timesnake.library.packets.core.BukkitNmsParser;
import de.timesnake.library.packets.core.ListenerManager;
import de.timesnake.library.packets.util.listener.PacketPlayInListener;
import de.timesnake.library.packets.util.listener.PacketPlayOutListener;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ServerGamePacketListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class PacketManager implements Listener {

  private final ListenerManager listenerManager;

  public PacketManager(Plugin plugin) {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(this, plugin);

    this.listenerManager = new ListenerManager();

    Loggers.PACKETS.info("Loaded manager successfully");
  }

  public void addListener(PacketPlayOutListener listener) {
    this.listenerManager.addListener(listener);
  }

  public void addListener(PacketPlayInListener listener) {
    this.listenerManager.addListener(listener);
  }

  public void removeListener(PacketPlayOutListener listener, Class<? extends Packet<?>>... types) {
    this.listenerManager.removeListener(listener, types);
  }

  public void removeListener(PacketPlayInListener listener, Class<? extends Packet<?>>... types) {
    this.listenerManager.removeListener(listener, types);
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

  public void sendPacket(Player player, Packet<?> packet) {
    BukkitNmsParser.sendPacket(player, packet);
  }

  private class ChannelDuplexHandler extends io.netty.channel.ChannelDuplexHandler {

    private final Player player;

    public ChannelDuplexHandler(Player player) {
      this.player = player;
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet)
        throws Exception {

      if (!(packet instanceof Packet)) {
        super.channelRead(channelHandlerContext, packet);
        return;
      }

      Packet<ServerGamePacketListener> packetPlayIn = (Packet<ServerGamePacketListener>) packet;

      if (packetPlayIn == null) {
        Loggers.PACKETS.info("PacketRead null");
        super.channelRead(channelHandlerContext, packet);
        return;
      }

      packetPlayIn = PacketManager.this.listenerManager.handleServerPacket(packetPlayIn, player);

      if (packetPlayIn == null) {
        return;
      }

      super.channelRead(channelHandlerContext, packetPlayIn);
    }

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object packet,
                      ChannelPromise channelPromise) throws Exception {

      if (packet == null) {
        return;
      }

      if (!(packet instanceof Packet)) {
        super.write(channelHandlerContext, packet, channelPromise);
        return;
      }

      Packet<ClientGamePacketListener> packetPlayOut = (Packet<ClientGamePacketListener>) packet;

      packetPlayOut = PacketManager.this.listenerManager.handleClientPacket(packetPlayOut, player);

      if (packetPlayOut == null) {
        return;
      }

      super.write(channelHandlerContext, packetPlayOut, channelPromise);
    }
  }
}
