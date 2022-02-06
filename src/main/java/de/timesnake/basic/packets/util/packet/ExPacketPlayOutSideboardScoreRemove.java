package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutSideboardScoreRemove extends ExPacketPlayOutSideboard {

    static ExPacketPlayOutSideboardScoreRemove wrap(String sideboardName, int line, String text) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutSideboardScoreRemove(sideboardName, text, line);
    }

}
