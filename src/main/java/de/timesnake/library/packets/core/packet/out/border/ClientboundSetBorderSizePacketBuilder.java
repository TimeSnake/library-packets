/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import net.minecraft.world.level.border.WorldBorder;

public class ClientboundSetBorderSizePacketBuilder {

  public static ClientboundSetBorderSizePacket of(double size) {
    return new ClientboundSetBorderSizePacket(new WorldBorder() {
      @Override
      public double getLerpTarget() {
        return size;
      }
    });
  }
}
