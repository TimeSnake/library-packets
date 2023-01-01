/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util;

import de.timesnake.library.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import de.timesnake.library.packets.util.packet.ExPacketPlayOut;
import org.bukkit.World;

public interface ExClientboundSetBorderCenterPacket extends ExPacketPlayOut,
        ExPacketPlayOutWorldBorder {

    static ExClientboundSetBorderCenterPacket wrap(World world, double centerX, double centerZ) {
        return new de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderCenterPacket(world,
                centerX, centerZ);
    }
}
