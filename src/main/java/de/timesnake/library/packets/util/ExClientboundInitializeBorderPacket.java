/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util;

import de.timesnake.library.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import de.timesnake.library.packets.util.packet.ExPacketPlayOut;
import org.bukkit.World;

public interface ExClientboundInitializeBorderPacket extends ExPacketPlayOut,
        ExPacketPlayOutWorldBorder {

    static ExClientboundInitializeBorderPacket wrap(World world, double centerX, double centerZ, double startSize,
                                                    double shrinkSize, long time, int warningDistance,
                                                    int warningTime) {
        return new de.timesnake.library.packets.core.packet.out.border.ExClientboundInitializeBorderPacket(world,
                centerX, centerZ, startSize, shrinkSize, time, warningDistance, warningTime);
    }

    static ExClientboundInitializeBorderPacket wrapToMaxBorder(World world) {
        return new de.timesnake.library.packets.core.packet.out.border.ExClientboundInitializeBorderPacket(world, 0, 0,
                29999984, 29999984, 0, 0, 0);
    }
}
