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

package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import org.bukkit.ChatColor;

@NmsReflection(usesReflection = true)
public class ExPacketPlayOutTablistTeamCreation extends ExPacketPlayOutTablistTeam implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamCreation {

    private final String prefix;

    public ExPacketPlayOutTablistTeamCreation(String name, String prefix, ChatColor chatColor) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        RefUtil.setInstanceField(team, "m", getEnumChatFormat(chatColor));

        if (prefix == null) {
            prefix = "";
        }

        RefUtil.setInstanceField(team, "g", IChatBaseComponent.a(prefix));

        super.packet = PacketPlayOutScoreboardTeam.a(team, true);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamCreation(String name, String prefix, ChatColor chatColor,
                                              NameTagVisibility visibility) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        RefUtil.setInstanceField(team, "m", getEnumChatFormat(chatColor));
        RefUtil.setInstanceField(team, "k", visibility.getNms());
        RefUtil.setInstanceField(team, "l", visibility.getNms());

        if (prefix == null) {
            prefix = "";
        }

        RefUtil.setInstanceField(team, "g", IChatBaseComponent.a(prefix));

        super.packet = PacketPlayOutScoreboardTeam.a(team, true);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamCreation(PacketPlayOutScoreboardTeam packet, String name, String prefix) {
        super(packet, name);
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getInfo() {
        return "name: " + this.name + " prefix: " + this.prefix;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_CREATION;
    }

}
