/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutScoreboardDisplayObjective extends ExPacketPlayOut {

  static ExPacketPlayOutScoreboardDisplayObjective wrap(String name, Slot slot) {
    return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardDisplayObjective(
        name, slot);
  }

  enum Slot {
    TABLIST(0),
    SIDEBOARD(1),
    BELOW_NAME(2);

    private final int type;

    Slot(int type) {
      this.type = type;
    }

    public int getType() {
      return type;
    }
  }
}
