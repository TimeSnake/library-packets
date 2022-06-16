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
