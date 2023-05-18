/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutTablistTeamRemove extends ExPacketPlayOutTablistTeam {

  static ExPacketPlayOutTablistTeamRemove wrap(String name) {
    return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamRemove(
        name);
  }
}
