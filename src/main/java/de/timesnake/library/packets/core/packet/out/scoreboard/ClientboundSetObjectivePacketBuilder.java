/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetObjectivePacket;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

public class ClientboundSetObjectivePacketBuilder {

  public static ClientboundSetObjectivePacket ofAdd(String name, String displayName, ObjectiveCriteria criteria,
                                                    ObjectiveCriteria.RenderType renderType) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, criteria,
        Component.literal(displayName), renderType, false, null),
        ClientboundSetObjectivePacket.METHOD_ADD);
  }

  public static ClientboundSetObjectivePacket ofChange(String name, String displayName, ObjectiveCriteria criteria,
                                                       ObjectiveCriteria.RenderType renderType) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, criteria,
        Component.literal(displayName), renderType, false, null), ClientboundSetObjectivePacket.METHOD_CHANGE);
  }

  public static ClientboundSetObjectivePacket ofRemove(String name) {
    return new ClientboundSetObjectivePacket(new Objective(null, name, null,
        Component.empty(), null, false, null), ClientboundSetObjectivePacket.METHOD_REMOVE);
  }
}
