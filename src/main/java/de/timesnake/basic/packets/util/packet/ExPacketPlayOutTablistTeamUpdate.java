package de.timesnake.basic.packets.util.packet;

import org.bukkit.ChatColor;

public interface ExPacketPlayOutTablistTeamUpdate extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamUpdate wrap(String name, String prefix, ChatColor color) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamUpdate(name, prefix, color);
    }

    String getPrefix();
}
