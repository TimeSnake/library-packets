package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutSpawnEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntity wrap(Entity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity);
    }

    static ExPacketPlayOutSpawnEntity wrap(ExEntity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity);
    }
}
