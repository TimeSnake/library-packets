/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import net.minecraft.world.level.border.WorldBorder;

public class ClientboundSetBorderLerpSizePacketBuilder {

  public static ClientboundSetBorderLerpSizePacket of(double oldSize, double newSize, long lerpTime) {
    WorldBorder worldBorder = new WorldBorder() {
      @Override
      public double getSize() {
        return oldSize;
      }

      @Override
      public double getLerpTarget() {
        return newSize;
      }

      @Override
      public long getLerpRemainingTime() {
        return lerpTime;
      }
    };

    return new ClientboundSetBorderLerpSizePacket(worldBorder);
  }
}
