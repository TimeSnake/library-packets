/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

public class ClientboundSetDisplayObjectivePacketBuilder {

  public static ClientboundSetDisplayObjectivePacket ofAdd(DisplaySlot slot, String name) {
    return new ClientboundSetDisplayObjectivePacket(slot,
        new Objective(null, name, null, Component.empty(), ObjectiveCriteria.RenderType.INTEGER,
            false, null));
  }

  public static ClientboundSetDisplayObjectivePacket ofRemove(DisplaySlot slot) {
    return new ClientboundSetDisplayObjectivePacket(slot, null);
  }
}
