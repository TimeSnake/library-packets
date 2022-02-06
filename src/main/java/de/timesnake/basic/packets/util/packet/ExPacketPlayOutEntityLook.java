package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityLook warp(EntityExtension<?> entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityLook(entity, yaw, pitch, onGround);
    }

    static ExPacketPlayOutEntityLook warp(Entity entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityLook(entity, yaw, pitch, onGround);
    }

}
