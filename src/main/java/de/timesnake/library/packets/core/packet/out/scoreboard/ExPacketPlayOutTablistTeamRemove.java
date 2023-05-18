/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;

public class ExPacketPlayOutTablistTeamRemove extends ExPacketPlayOutTablistTeam implements
    de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamRemove {

  public ExPacketPlayOutTablistTeamRemove(String name) {
    super(name);
    ScoreboardTeam team = new ScoreboardTeam(null, name);
    super.packet = PacketPlayOutScoreboardTeam.a(team);
  }

  @Override
  public Type getType() {
    return Type.PLAY_OUT_TABLIST_TEAM_REMOVE;
  }

  @Override
  public String getInfo() {
    return "team " + this.name + " remove";
  }

}
