package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityLook wrap(ExtendedCraftEntity<?> entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityLook(entity, yaw, pitch,
                onGround);
    }

    static ExPacketPlayOutEntityLook wrap(Entity entity, float yaw, float pitch, boolean onGround) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityLook(entity, yaw, pitch,
                onGround);
    }

}