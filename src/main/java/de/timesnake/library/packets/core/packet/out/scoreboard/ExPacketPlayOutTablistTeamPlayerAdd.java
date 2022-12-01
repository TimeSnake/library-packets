/*
 * workspace.library-packets.main
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

import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;

import javax.annotation.Nonnull;

public class ExPacketPlayOutTablistTeamPlayerAdd extends ExPacketPlayOutTablistTeam implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamPlayerAdd {

    private final String entry;

    public ExPacketPlayOutTablistTeamPlayerAdd(String name, @Nonnull String entry) {
        super(name);
        this.entry = entry;
        ScoreboardTeam team = new ScoreboardTeam(null, name);
        super.packet = PacketPlayOutScoreboardTeam.a(team, entry, PacketPlayOutScoreboardTeam.a.a);

    }

    @Override
    public String getInfo() {
        return "team: " + super.name + " add entry " + this.entry;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_PLAYER_ADD;
    }

}
