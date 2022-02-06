package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnEntityLiving extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntityLiving wrap(Player player) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutSpawnEntityLiving(player);
    }

    static ExPacketPlayOutSpawnEntityLiving wrap(LivingEntity entity) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutSpawnEntityLiving(entity);
    }

    static ExPacketPlayOutSpawnEntityLiving wrap(ExEntityLiving entity) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutSpawnEntityLiving(entity);
    }

    @Override
    String getInfo();

    @Override
    Type getType();
}
