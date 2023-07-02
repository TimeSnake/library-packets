/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.world.entity.Entity;

public class PacketPlayOutEntityLookBuilder {

  public static ClientboundMoveEntityPacket of(Entity entity, float yaw, float pitch, boolean onGround) {
    return new ClientboundMoveEntityPacket.Rot(entity.getId(), (byte) (yaw * 256 / 360),
        (byte) (pitch * 256 / 360), onGround);
  }
}
