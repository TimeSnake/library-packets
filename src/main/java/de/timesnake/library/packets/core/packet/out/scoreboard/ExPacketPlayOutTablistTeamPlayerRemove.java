/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;

public class ExPacketPlayOutTablistTeamPlayerRemove extends ExPacketPlayOutTablistTeam implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamPlayerRemove {


    public ExPacketPlayOutTablistTeamPlayerRemove(String name, String entry) {
        super(name);
        ScoreboardTeam team = new ScoreboardTeam(null, name);
        super.packet = PacketPlayOutScoreboardTeam.a(team, entry, PacketPlayOutScoreboardTeam.a.b);

    }

    @Override
    public String getInfo() {
        return "team: " + super.name + " entry remove ";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_PLAYER_REMOVE;
    }

}
