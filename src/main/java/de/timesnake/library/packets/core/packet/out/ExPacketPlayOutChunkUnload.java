/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.basic.util.Tuple;
import net.minecraft.network.protocol.game.PacketPlayOutUnloadChunk;

public class ExPacketPlayOutChunkUnload extends ExPacketPlayOut {

  public ExPacketPlayOutChunkUnload(PacketPlayOutUnloadChunk packet) {
    super(packet);
  }

  public Tuple<Integer, Integer> getChunkCoordinates() {
    return new Tuple<>(((PacketPlayOutUnloadChunk) super.packet).b(),
        ((PacketPlayOutUnloadChunk) super.packet).c());
  }

  @Override
  public String getInfo() {
    Tuple<Integer, Integer> chunk = this.getChunkCoordinates();
    return "x=" + chunk.getA() + " y=" + chunk.getB();
  }

  @Override
  public Type getType() {
    return Type.PLAY_OUT_CHUNK_UNLOAD;
  }
}
