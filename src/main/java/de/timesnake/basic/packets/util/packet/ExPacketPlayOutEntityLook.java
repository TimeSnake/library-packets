package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityLook wrap(EntityExtension<?> entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityLook(entity, yaw, pitch,
                onGround);
    }

    static ExPacketPlayOutEntityLook wrap(Entity entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityLook(entity, yaw, pitch,
                onGround);
    }

}
