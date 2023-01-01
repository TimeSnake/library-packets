/*
 * Copyright (C) 2023 timesnake
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
