/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutSideboardScoreRemove extends ExPacketPlayOutSideboard {

    static ExPacketPlayOutSideboardScoreRemove wrap(String sideboardName, int line, String text) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutSideboardScoreRemove(sideboardName, text, line);
    }

}
