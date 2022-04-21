package de.timesnake.basic.packets.core.packet.out.scoreboard;

import com.mojang.authlib.GameProfile;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.basic.util.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketListenerPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class ExPacketPlayOutTablistPlayer extends ExPacketPlayOutTablist implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablistPlayer {

    public enum ExEnumPlayerInfoAction {
        ADD_PLAYER(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a), UPDATE_GAME_MODE(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.b), UPDATE_LATENCY(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.c), UPDATE_DISPLAY_NAME(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.d), REMOVE_PLAYER(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e);

        private final PacketPlayOutPlayerInfo.EnumPlayerInfoAction nms;

        ExEnumPlayerInfoAction(PacketPlayOutPlayerInfo.EnumPlayerInfoAction nms) {
            this.nms = nms;
        }

        public PacketPlayOutPlayerInfo.EnumPlayerInfoAction getNms() {
            return nms;
        }
    }

    protected final Player player;

    public ExPacketPlayOutTablistPlayer(Packet<? extends PacketListenerPlayOut> packet, Player player) {
        super(packet);
        this.player = player;
    }

    public ExPacketPlayOutTablistPlayer(Packet<? extends PacketListenerPlayOut> packet, EntityPlayer player) {
        super(packet);
        this.player = player.getBukkitEntity();
    }

    public ExPacketPlayOutTablistPlayer(Player player) {
        super();
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public static ExPacketPlayOut getPacket(PacketPlayOutPlayerInfo packet) {
        @NmsReflection PacketPlayOutPlayerInfo.EnumPlayerInfoAction type = (PacketPlayOutPlayerInfo.EnumPlayerInfoAction) RefUtil.getInstanceField(packet, "a");

        if (type.equals(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a)) {
            List<Player> players = getFieldPlayers(packet);
            if (players.size() > 0) {
                return new ExPacketPlayOutTablistPlayerAdd(packet, players.get(0));
            }
        } else if (type.equals(ExEnumPlayerInfoAction.REMOVE_PLAYER.getNms())) {
            List<Player> players = getFieldPlayers(packet);
            if (players.size() > 0) {
                return new ExPacketPlayOutTablistPlayerRemove(packet, players.get(0));
            }
        }
        return null;
    }

    private static List<Player> getFieldPlayers(PacketPlayOutPlayerInfo packet) {

        List<Player> players = new ArrayList<>();

        @NmsReflection List<?> list = (List<?>) RefUtil.getInstanceField(packet, "b");

        for (Object info : list) {

            @NmsReflection GameProfile gameProfile = (GameProfile) RefUtil.getInstanceField(info, "c");

            Player player = Bukkit.getPlayer(gameProfile.getId());

            if (player != null) {
                players.add(((CraftPlayer) player).getHandle().getBukkitEntity());
            }
        }
        return players;
    }

}
