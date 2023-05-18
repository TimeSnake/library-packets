/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import javax.annotation.Nonnull;
import net.minecraft.network.protocol.Packet;

public interface ExPacketPlayOut extends ExPacket {

  @Nonnull
  Packet<?> getPacket();

}
