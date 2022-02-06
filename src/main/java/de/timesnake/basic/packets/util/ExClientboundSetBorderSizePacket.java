package de.timesnake.basic.packets.util;

import de.timesnake.basic.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import org.bukkit.World;

public interface ExClientboundSetBorderSizePacket extends ExPacketPlayOutWorldBorder {

    static ExClientboundSetBorderSizePacket wrap(World world, double size) {
        return new de.timesnake.basic.packets.core.packet.out.border.ExClientboundSetBorderSizePacket(world, size);
    }
}
