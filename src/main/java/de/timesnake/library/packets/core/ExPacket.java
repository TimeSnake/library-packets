/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core;

import javax.annotation.Nonnull;
import net.minecraft.network.PacketListener;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.Packet;

public abstract class ExPacket implements de.timesnake.library.packets.util.packet.ExPacket {

  public static Object invokeChatSerializer(String text) {
    return IChatBaseComponent.ChatSerializer.a(text);
  }

  protected Packet<? extends PacketListener> packet;

  public ExPacket(Packet<? extends PacketListener> packet) {
    this.packet = packet;
  }

  public ExPacket() {

  }

  public @Nonnull
  Packet<? extends PacketListener> getPacket() {
    return packet;
  }

}
