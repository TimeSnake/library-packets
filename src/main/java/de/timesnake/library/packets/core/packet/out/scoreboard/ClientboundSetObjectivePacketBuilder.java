/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetObjectivePacket;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

public class ClientboundSetObjectivePacketBuilder {

  public static ClientboundSetObjectivePacket ofAdd(String name, String displayName, ObjectiveCriteria.RenderType renderType) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, null,
        Component.literal(displayName), renderType),
        ClientboundSetObjectivePacket.METHOD_ADD);
  }

  public static ClientboundSetObjectivePacket ofRemove(String name) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, null,
        Component.empty(), null),
        ClientboundSetObjectivePacket.METHOD_REMOVE);
  }

  public static ClientboundSetObjectivePacket ofChange(String name, String displayName, ObjectiveCriteria.RenderType renderType) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, null,
        Component.literal(displayName), renderType),
        ClientboundSetObjectivePacket.METHOD_CHANGE);
  }
}
