package de.timesnake.library.packets.core.packet.out.entity;

import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.world.entity.Entity;

public class ClientboundRotateHeadPacketBuilder {

  public static ClientboundRotateHeadPacket of(Entity entity, float yaw) {
    return new ClientboundRotateHeadPacket(entity, (byte) (yaw * 256 / 360));
  }
}
