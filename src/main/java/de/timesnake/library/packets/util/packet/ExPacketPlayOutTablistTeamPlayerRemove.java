/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutTablistTeamPlayerRemove extends ExPacketPlayOutTablistTeam {

  static ExPacketPlayOutTablistTeamPlayerRemove wrap(String name, String entry) {
    return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamPlayerRemove(
        name,
        entry);
  }
}
