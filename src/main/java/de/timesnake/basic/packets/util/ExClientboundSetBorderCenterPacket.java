package de.timesnake.basic.packets.util;

import de.timesnake.basic.packets.core.packet.out.border.ExPacketPlayOutWorldBorder;
import org.bukkit.World;

public interface ExClientboundSetBorderCenterPacket extends de.timesnake.basic.packets.util.packet.ExPacketPlayOut,
        ExPacketPlayOutWorldBorder {

    static ExClientboundSetBorderCenterPacket wrap(World world, double centerX, double centerZ) {
        return new de.timesnake.basic.packets.core.packet.out.border.ExClientboundSetBorderCenterPacket(world,
                centerX, centerZ);
    }
}
