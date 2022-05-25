package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import org.bukkit.entity.LivingEntity;

public interface ExPacketPlayOutEntityRelMoveLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityRelMoveLook wrap(ExEntityLiving entity, double deltaX, double deltaY, double deltaZ,
                                                 float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityRelMoveLook(entity, deltaX,
                deltaY, deltaZ, yaw, pitch, onGround);
    }

    static ExPacketPlayOutEntityRelMoveLook wrap(LivingEntity entity, double deltaX, double deltaY, double deltaZ,
                                                 float yaw, float pitch, boolean onGround) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityRelMoveLook(entity, deltaX,
                deltaY, deltaZ, yaw, pitch, onGround);
    }
}
