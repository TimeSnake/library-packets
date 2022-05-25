package de.timesnake.basic.packets.util.packet;

import javax.annotation.Nonnull;

public interface ExPacketPlayOutTablistTeamPlayerAdd extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamPlayerAdd wrap(String name, @Nonnull String entry) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamPlayerAdd(name,
                entry);
    }
}
