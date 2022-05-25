package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutTablistTeamPlayerRemove extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamPlayerRemove wrap(String name, String entry) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamPlayerRemove(name,
                entry);
    }
}
