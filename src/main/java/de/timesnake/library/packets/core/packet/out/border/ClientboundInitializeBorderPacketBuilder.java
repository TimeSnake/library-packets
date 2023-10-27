/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.world.level.border.WorldBorder;
import org.bukkit.World;

public class ClientboundInitializeBorderPacketBuilder {

  public static ClientboundInitializeBorderPacket of(World world, double centerX, double centerZ, double startSize,
                                                     double shrinkSize, long time, int warningDistance, int warningTime) {
    WorldBorder worldBorder = new WorldBorder() {
      @Override
      public double getCenterX() {
        return centerX;
      }

      @Override
      public double getCenterZ() {
        return centerZ;
      }

      @Override
      public double getSize() {
        return startSize;
      }

      @Override
      public double getLerpTarget() {
        return shrinkSize;
      }

      @Override
      public long getLerpRemainingTime() {
        return time;
      }

      @Override
      public int getAbsoluteMaxSize() {
        return Integer.MAX_VALUE;
      }

      @Override
      public int getWarningBlocks() {
        return warningDistance;
      }

      @Override
      public int getWarningTime() {
        return warningTime;
      }
    };

    worldBorder.world = ((org.bukkit.craftbukkit.v1_20_R1.CraftWorld) world).getHandle();

    return new ClientboundInitializeBorderPacket(worldBorder);
  }

  public static ClientboundInitializeBorderPacket of(World world) {
    return of(world, 0, 0, 29999984, 29999984, 0, 0, 0);
  }
}
