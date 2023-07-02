/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.border.WorldBorder;

import java.lang.reflect.Field;

public class ClientboundSetBorderCenterPacketBuilder {

  public static ClientboundSetBorderCenterPacket of(ServerLevel level, double centerX, double centerZ) {
    WorldBorder worldBorder = new WorldBorder() {
      @Override
      public double getCenterX() {
        return centerX;
      }

      @Override
      public double getCenterZ() {
        return centerZ;
      }
    };

    try {
      Field world = WorldBorder.class.getDeclaredField("world");
      world.setAccessible(true);
      world.set(worldBorder, level);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return new ClientboundSetBorderCenterPacket(worldBorder);
  }

}
