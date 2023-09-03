package de.timesnake.library.packets.core.packet.out.entity;

import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.world.entity.Entity;

public class ClientboundMoveEntityPacketBuilder {

  private final Entity entity;
  private Float yaw;
  private Float pitch;
  private Boolean onGround;

  public ClientboundMoveEntityPacketBuilder(Entity entity) {
    this.entity = entity;
  }

  public ClientboundMoveEntityPacket build() {
    return new ClientboundMoveEntityPacket.Rot(this.entity.getId(),
        (byte) (this.yaw * 256 / 360), (byte) (this.pitch * 256 / 360), this.onGround);
  }

  public ClientboundMoveEntityPacketBuilder setRot(float yaw, float pitch, boolean onGround) {
    this.yaw = yaw;
    this.pitch = pitch;
    this.onGround = onGround;
    return this;
  }
}
