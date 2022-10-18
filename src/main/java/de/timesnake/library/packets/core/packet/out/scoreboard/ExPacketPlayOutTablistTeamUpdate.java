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

import de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamCreation;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import org.bukkit.ChatColor;

import java.lang.reflect.Field;

@NmsReflection(usesReflection = true)
public class ExPacketPlayOutTablistTeamUpdate extends ExPacketPlayOutTablistTeam
        implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamUpdate {

    private final String prefix;
    private ExPacketPlayOutTablistTeamCreation.NameTagVisibility visibility;

    public ExPacketPlayOutTablistTeamUpdate(String name, String prefix, ChatColor chatColor,
                                            ExPacketPlayOutTablistTeamCreation.NameTagVisibility visibility) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        this.visibility = visibility;

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        try {
            Field m = ScoreboardTeam.class.getDeclaredField("m");
            m.setAccessible(true);
            m.set(team, getEnumChatFormat(chatColor));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (prefix == null) {
            prefix = "";
        }

        try {
            Field g = ScoreboardTeam.class.getDeclaredField("g");
            g.setAccessible(true);
            g.set(team, IChatBaseComponent.a(prefix));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Field k = ScoreboardTeam.class.getDeclaredField("k");
            k.setAccessible(true);
            k.set(team, visibility.getNms());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Field l = ScoreboardTeam.class.getDeclaredField("l");
            l.setAccessible(true);
            l.set(team, visibility.getNms());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        super.packet = PacketPlayOutScoreboardTeam.a(team, false);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamUpdate(String name, String prefix, ChatColor chatColor) {
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

        super.packet = PacketPlayOutScoreboardTeam.a(team, false);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamUpdate(String name, String prefix) {
        super(name);
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getInfo() {
        return "team: " + this.name + " prefix: " + this.prefix + " visibility: " +
                (this.visibility != null ? this.visibility.name() : "") + " update";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_UPDATE;
    }
}
