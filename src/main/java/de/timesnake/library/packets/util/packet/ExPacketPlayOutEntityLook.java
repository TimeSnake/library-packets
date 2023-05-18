/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityLook extends ExPacketPlayOut {

  static ExPacketPlayOutEntityLook wrap(Entity entity, float yaw, float pitch, boolean onGround) {
    return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityLook(entity,
        yaw, pitch,
        onGround);
  }

}
