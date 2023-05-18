/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore;

public class ExPacketPlayOutSideboardScoreSet extends ExPacketPlayOutSideboard implements
    de.timesnake.library.packets.util.packet.ExPacketPlayOutSideboardScoreSet {

  public ExPacketPlayOutSideboardScoreSet(String sideboardName, String text, int line) {
    super(new PacketPlayOutScoreboardScore(Action.CHANGE.getNms(), sideboardName, text, line),
        sideboardName,
        line, text);
  }

  @Override
  public Type getType() {
    return Type.PLAY_OUT_SIDEBOARD_SCORE_SET;
  }

}
