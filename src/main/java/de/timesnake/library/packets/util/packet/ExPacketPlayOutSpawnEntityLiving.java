package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnEntityLiving extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntityLiving wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntityLiving(player);
    }

}
