package de.timesnake.basic.packets.util;

import de.timesnake.basic.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import org.bukkit.World;

public interface ExClientboundInitializeBorderPacket extends de.timesnake.basic.packets.util.packet.ExPacketPlayOut,
        ExPacketPlayOutWorldBorder {

    static ExClientboundInitializeBorderPacket wrap(World world, double centerX, double centerZ, double startSize,
                                                    double shrinkSize, long time, int warningDistance,
                                                    int warningTime) {
        return new de.timesnake.basic.packets.core.packet.out.border.ExClientboundInitializeBorderPacket(world,
                centerX, centerZ, startSize, shrinkSize, time, warningDistance, warningTime);
    }

    static ExClientboundInitializeBorderPacket wrapToMaxBorder(World world) {
        return new de.timesnake.basic.packets.core.packet.out.border.ExClientboundInitializeBorderPacket(world, 0, 0,
                29999984, 29999984, 0, 0, 0);
    }
}
