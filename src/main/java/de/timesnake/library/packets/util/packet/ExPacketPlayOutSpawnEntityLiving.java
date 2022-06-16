package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnEntityLiving extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntityLiving wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntityLiving(player);
    }

    static ExPacketPlayOutSpawnEntityLiving wrap(LivingEntity entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntityLiving(entity);
    }

    static ExPacketPlayOutSpawnEntityLiving wrap(ExEntityLiving entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntityLiving(entity);
    }
}
