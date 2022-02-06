package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutSideboardScoreSet extends ExPacketPlayOutSideboard {

    static ExPacketPlayOutSideboardScoreSet wrap(String scoreboardName, int line, String text) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutSideboardScoreSet(scoreboardName, text, line);
    }
}
