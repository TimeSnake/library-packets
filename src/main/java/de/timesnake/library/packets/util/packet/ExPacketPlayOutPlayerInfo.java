/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutPlayerInfo extends ExPacketPlayOut {

    static ExPacketPlayOutPlayerInfo wrap(Action action, Player player) {
        return new de.timesnake.library.packets.core.packet.out.ExPacketPlayOutPlayerInfo(player, action);
    }

    static ExPacketPlayOutPlayerInfo wrap(Action action, ExPlayer player) {
        return new de.timesnake.library.packets.core.packet.out.ExPacketPlayOutPlayerInfo(player, action);
    }

    static ExPacketPlayOutPlayerInfo wrap(Action action, EntityPlayer player) {
        return new de.timesnake.library.packets.core.packet.out.ExPacketPlayOutPlayerInfo(player, action);
    }

    enum Action {
        ADD_PLAYER(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a),
        UPDATE_GAME_MODE(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.b),
        UPDATE_LATENCY(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.c),
        UPDATE_DISPLAY_NAME(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.d),
        REMOVE_PLAYER(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e);

        private final PacketPlayOutPlayerInfo.EnumPlayerInfoAction action;

        Action(PacketPlayOutPlayerInfo.EnumPlayerInfoAction action) {
            this.action = action;
        }

        public PacketPlayOutPlayerInfo.EnumPlayerInfoAction getAction() {
            return action;
        }
    }
}
