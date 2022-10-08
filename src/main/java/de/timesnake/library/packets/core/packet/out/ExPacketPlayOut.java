/*
 * library-packets.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.packets.core.UnsupportedPacketException;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundInitializeBorderPacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderCenterPacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderLerpSizePacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderSizePacket;
import de.timesnake.library.packets.core.packet.out.entity.*;
import de.timesnake.library.packets.core.packet.out.scoreboard.*;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;

public abstract class ExPacketPlayOut extends ExPacket implements de.timesnake.library.packets.util.packet.ExPacketPlayOut {

    public static ExPacketPlayOut getPacket(Packet<? extends PacketListener> packet) throws UnsupportedPacketException {

        if (packet instanceof PacketPlayOutScoreboardTeam) {
            return ExPacketPlayOutTablistTeam.getPacket(((PacketPlayOutScoreboardTeam) packet));
        } else if (packet instanceof PacketPlayOutPlayerInfo) {
            return ExPacketPlayOutTablistPlayer.getPacket(((PacketPlayOutPlayerInfo) packet));
        } else if (packet instanceof PacketPlayOutPlayerListHeaderFooter) {
            return ExPacketPlayOutTablistHeaderFooter.getPacket(((PacketPlayOutPlayerListHeaderFooter) packet));
        } else if (packet instanceof PacketPlayOutScoreboardScore) {
            return ExPacketPlayOutSideboard.getPacket(((PacketPlayOutScoreboardScore) packet));
        } else if (packet instanceof PacketPlayOutEntityMetadata) {
            return ExPacketPlayOutEntityMetadata.getPacket(((PacketPlayOutEntityMetadata) packet));
        } else if (packet instanceof PacketPlayOutScoreboardObjective) {
            return ExPacketPlayOutScoreboardObjective.getPacket(((PacketPlayOutScoreboardObjective) packet));
        } else if (packet instanceof PacketPlayOutScoreboardDisplayObjective) {
            return ExPacketPlayOutScoreboardDisplayObjective.getPacket(((PacketPlayOutScoreboardDisplayObjective) packet));
        } else if (packet instanceof PacketPlayOutOpenBook) {
            return ExPacketPlayOutOpenBook.getPacket(((PacketPlayOutOpenBook) packet));
        } else if (packet instanceof PacketPlayOutEntityEquipment) {
            return ExPacketPlayOutEntityEquipment.getPacket(((PacketPlayOutEntityEquipment) packet));
        } else if (packet instanceof PacketPlayOutEntityHeadRotation) {
            return ExPacketPlayOutEntityHeadRotation.getPacket((PacketPlayOutEntityHeadRotation) packet);
        } else if (packet instanceof PacketPlayOutEntity.PacketPlayOutEntityLook) {
            return ExPacketPlayOutEntityLook.getPacket(((PacketPlayOutEntity.PacketPlayOutEntityLook) packet));
        } else if (packet instanceof ClientboundSetBorderCenterPacket) {
            return new ExClientboundSetBorderCenterPacket(((ClientboundSetBorderCenterPacket) packet));
        } else if (packet instanceof ClientboundSetBorderSizePacket) {
            return new ExClientboundSetBorderSizePacket(((ClientboundSetBorderSizePacket) packet));
        } else if (packet instanceof ClientboundSetBorderLerpSizePacket) {
            return new ExClientboundSetBorderLerpSizePacket(((ClientboundSetBorderLerpSizePacket) packet));
        } else if (packet instanceof ClientboundInitializeBorderPacket) {
            return new ExClientboundInitializeBorderPacket(((ClientboundInitializeBorderPacket) packet));
        } else if (packet instanceof PacketPlayOutSpawnEntity) {
            return new ExPacketPlayOutSpawnEntity(((PacketPlayOutSpawnEntity) packet));
        } else if (packet instanceof PacketPlayOutMap) {
            return new ExPacketPlayOutMap((PacketPlayOutMap) packet);
        } else if (packet instanceof ClientboundLevelChunkWithLightPacket) {
            return new ExClientboundLevelChunkWithLightPacket(((ClientboundLevelChunkWithLightPacket) packet));
        } else if (packet instanceof PacketPlayOutUnloadChunk) {
            return new ExPacketPlayOutChunkUnload(((PacketPlayOutUnloadChunk) packet));
        }
        throw new UnsupportedPacketException(packet);
    }

    public ExPacketPlayOut(Packet<? extends PacketListener> packet) {
        super(packet);
    }

    public ExPacketPlayOut() {
        super();
    }

}
