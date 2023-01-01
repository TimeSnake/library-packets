/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutSideboardScoreSet extends ExPacketPlayOutSideboard {

    static ExPacketPlayOutSideboardScoreSet wrap(String scoreboardName, int line, String text) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutSideboardScoreSet(scoreboardName, text, line);
    }
}
