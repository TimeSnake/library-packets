package de.timesnake.basic.packets.core.packet.out;

import de.timesnake.basic.packets.core.ExPacket;
import de.timesnake.basic.packets.core.UnsupportedPacketException;
import de.timesnake.basic.packets.core.packet.out.border.ExClientboundInitializeBorderPacket;
import de.timesnake.basic.packets.core.packet.out.border.ExClientboundSetBorderCenterPacket;
import de.timesnake.basic.packets.core.packet.out.border.ExClientboundSetBorderLerpSizePacket;
import de.timesnake.basic.packets.core.packet.out.border.ExClientboundSetBorderSizePacket;
import de.timesnake.basic.packets.core.packet.out.scoreboard.*;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;

public abstract class ExPacketPlayOut extends ExPacket implements de.timesnake.basic.packets.util.packet.ExPacketPlayOut {

    public ExPacketPlayOut(Packet<? extends PacketListener> packet) {
        super(packet);
    }

    public ExPacketPlayOut() {
        super();
    }

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
        }
        throw new UnsupportedPacketException(packet);
    }

}
