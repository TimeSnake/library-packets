package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import org.bukkit.entity.LivingEntity;

public interface ExPacketPlayOutEntityRelMoveLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityRelMoveLook wrap(ExEntityLiving entity, double deltaX, double deltaY, double deltaZ,
                                                 float yaw, float pitch, boolean onGround) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityRelMoveLook(entity, deltaX,
                deltaY, deltaZ, yaw, pitch, onGround);
    }

    static ExPacketPlayOutEntityRelMoveLook wrap(LivingEntity entity, double deltaX, double deltaY, double deltaZ,
                                                 float yaw, float pitch, boolean onGround) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityRelMoveLook(entity, deltaX,
                deltaY, deltaZ, yaw, pitch, onGround);
    }
}
