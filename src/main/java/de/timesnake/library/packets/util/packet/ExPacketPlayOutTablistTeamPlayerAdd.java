/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import javax.annotation.Nonnull;

public interface ExPacketPlayOutTablistTeamPlayerAdd extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamPlayerAdd wrap(String name, @Nonnull String entry) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamPlayerAdd(name,
                entry);
    }
}
