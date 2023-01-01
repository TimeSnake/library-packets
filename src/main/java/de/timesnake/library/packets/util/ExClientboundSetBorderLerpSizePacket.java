/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util;

import de.timesnake.library.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import org.bukkit.World;

public interface ExClientboundSetBorderLerpSizePacket extends ExPacketPlayOutWorldBorder {

    static ExClientboundSetBorderLerpSizePacket wrap(World world, double newSize, double oldSize, long time) {
        return new de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderLerpSizePacket(world,
                newSize, oldSize, time);
    }
}
