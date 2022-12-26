/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util;

import de.timesnake.library.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import org.bukkit.World;

public interface ExClientboundSetBorderSizePacket extends ExPacketPlayOutWorldBorder {

    static ExClientboundSetBorderSizePacket wrap(World world, double size) {
        return new de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderSizePacket(world, size);
    }
}
