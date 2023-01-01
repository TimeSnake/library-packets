/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.LivingEntity;

public interface ExPacketPlayOutEntityRelMoveLook extends ExPacketPlayOut {

    static ExPacketPlayOutEntityRelMoveLook wrap(LivingEntity entity, double deltaX, double deltaY, double deltaZ,
                                                 float yaw, float pitch, boolean onGround) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityRelMoveLook(entity, deltaX,
                deltaY, deltaZ, yaw, pitch, onGround);
    }
}
