/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityMetadata extends ExPacketPlayOut {

  static ExPacketPlayOutEntityMetadata wrap(Player player, DataType type) {
    return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(
        player, type);
  }

  static ExPacketPlayOutEntityMetadata wrap(Entity entity, DataType type) {
    return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(
        entity, type);
  }

  static ExPacketPlayOutEntityMetadata wrap(Entity entity, DataType type, boolean flag) {
    return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(
        entity, type,
        flag);
  }

  Integer getNMSIndex();

  ExPacketPlayOutEntityMetadata cloneByte();

  ExPacketPlayOutEntityMetadata clonePose();

  Integer getEntityId();

  boolean setGlowing(boolean flag);

  boolean setFlyingWithElytra(boolean flag);

  boolean setPose(EntityPose pose);

  enum DataType {
    UPDATE
  }

  enum EntityPose {
    STANDING(net.minecraft.world.entity.EntityPose.a),
    FALL_FLYING(net.minecraft.world.entity.EntityPose.b),
    SLEEPING(net.minecraft.world.entity.EntityPose.c),
    SWIMMING(net.minecraft.world.entity.EntityPose.d),
    SPIN_ATTACK(net.minecraft.world.entity.EntityPose.e),
    CROUCHING(net.minecraft.world.entity.EntityPose.f),
    DYING(net.minecraft.world.entity.EntityPose.g);

    private final net.minecraft.world.entity.EntityPose pose;

    EntityPose(net.minecraft.world.entity.EntityPose pose) {
      this.pose = pose;
    }

    public net.minecraft.world.entity.EntityPose getPose() {
      return pose;
    }
  }
}
