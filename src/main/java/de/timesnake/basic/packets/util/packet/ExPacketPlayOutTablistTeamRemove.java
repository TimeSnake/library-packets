package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutTablistTeamRemove extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamRemove wrap(String name) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamRemove(name);
    }
}
