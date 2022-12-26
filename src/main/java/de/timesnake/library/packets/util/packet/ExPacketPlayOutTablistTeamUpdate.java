/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.ChatColor;

public interface ExPacketPlayOutTablistTeamUpdate extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamUpdate wrap(String name, String prefix, ChatColor color,
                                                 ExPacketPlayOutTablistTeamCreation.NameTagVisibility visibility) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamUpdate(name,
                prefix, color, visibility);
    }

    static ExPacketPlayOutTablistTeamUpdate wrap(String name, String prefix, ChatColor color) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamUpdate(name,
                prefix, color);
    }

    String getPrefix();
}
