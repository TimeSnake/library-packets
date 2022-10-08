/*
 * library-packets.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.packets.util.packet;

import net.minecraft.world.scores.ScoreboardTeamBase;
import org.bukkit.ChatColor;

public interface ExPacketPlayOutTablistTeamCreation extends ExPacketPlayOutTablistTeam {

    static ExPacketPlayOutTablistTeamCreation wrap(String name, String prefix, ChatColor chatColor) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamCreation(name,
                prefix, chatColor);
    }

    static ExPacketPlayOutTablistTeamCreation wrap(String name, String prefix, ChatColor chatColor,
                                                   NameTagVisibility visibility) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeamCreation(name,
                prefix, chatColor, visibility);
    }

    String getPrefix();

    enum NameTagVisibility {
        ALWAYS(ScoreboardTeamBase.EnumNameTagVisibility.a),
        NEVER(ScoreboardTeamBase.EnumNameTagVisibility.b),
        HIDE_FOR_OTHER_TEAMS(ScoreboardTeamBase.EnumNameTagVisibility.c),
        HIDE_FOR_OWN_TEAM(ScoreboardTeamBase.EnumNameTagVisibility.d);

        private final ScoreboardTeamBase.EnumNameTagVisibility nms;

        NameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility nms) {
            this.nms = nms;
        }

        public ScoreboardTeamBase.EnumNameTagVisibility getNms() {
            return nms;
        }
    }

}
