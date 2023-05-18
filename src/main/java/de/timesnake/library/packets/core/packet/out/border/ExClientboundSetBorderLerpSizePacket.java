/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class ExClientboundSetBorderLerpSizePacket extends ExPacketPlayOut implements
    de.timesnake.library.packets.util.ExClientboundSetBorderLerpSizePacket {

  public ExClientboundSetBorderLerpSizePacket(ClientboundSetBorderLerpSizePacket packet) {
    super(packet);
  }

  public ExClientboundSetBorderLerpSizePacket(World world, double newSize, double oldSize,
      long time) {
    super(new ClientboundSetBorderLerpSizePacket(
        PacketWorldBorder.lerp(((CraftWorld) world).getHandle(), newSize
            , oldSize, time)));
  }

  @Override
  public String getInfo() {
    return "border lerp size";
  }

  @Override
  public ExPacket.Type getType() {
    return ExPacket.Type.PLAY_OUT_WORLD_BORDER_LERP_SIZE;
  }
}
