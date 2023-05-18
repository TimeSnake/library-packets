/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.scores.ScoreboardObjective;
import net.minecraft.world.scores.criteria.IScoreboardCriteria;

public class PacketScoreboardObjective extends ScoreboardObjective {

  public PacketScoreboardObjective(String name, IChatBaseComponent title,
      IScoreboardCriteria.EnumScoreboardHealthDisplay type) {
    super(null, name, null, title, type);
  }

  public PacketScoreboardObjective(String name,
      IScoreboardCriteria.EnumScoreboardHealthDisplay type) {
    super(null, name, null, IChatBaseComponent.a(""), type);
  }
}
