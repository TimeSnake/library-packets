/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.world.scores.Objective;

public class ClientboundSetDisplayObjectivePacketBuilder {

  public static ClientboundSetDisplayObjectivePacket ofAdd(int slot, String name) {
    return new ClientboundSetDisplayObjectivePacket(slot,
        new Objective(null, name, null, Component.empty(), null));
  }

  public static ClientboundSetDisplayObjectivePacket ofRemove(int slot) {
    return new ClientboundSetDisplayObjectivePacket(slot, null);
  }
}
