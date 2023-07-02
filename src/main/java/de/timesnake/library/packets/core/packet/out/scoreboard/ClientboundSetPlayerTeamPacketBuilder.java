/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;

public class ClientboundSetPlayerTeamPacketBuilder {

  public static final Scoreboard DUMMY = new Scoreboard() {
    @Override
    public void onTeamChanged(PlayerTeam team) {

    }

    @Override
    public void onTeamAdded(PlayerTeam team) {

    }

    @Override
    public void onTeamRemoved(PlayerTeam team) {

    }
  };

  public static ClientboundSetPlayerTeamPacket ofCreate(String name, Component prefix, ChatFormatting color, Team.Visibility visibility) {
    PlayerTeam team = new PlayerTeam(DUMMY, name);
    team.setPlayerPrefix(prefix);
    team.setColor(color);
    team.setNameTagVisibility(visibility);
    return ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(team, true);
  }

  public static ClientboundSetPlayerTeamPacket ofModify(String name, Component prefix, ChatFormatting color, Team.Visibility visibility) {
    PlayerTeam team = new PlayerTeam(DUMMY, name);
    team.setPlayerPrefix(prefix);
    team.setColor(color);
    team.setNameTagVisibility(visibility);
    return ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(team, false);
  }

  public static ClientboundSetPlayerTeamPacket ofRemove(String name) {
    return ClientboundSetPlayerTeamPacket.createRemovePacket(new PlayerTeam(null, name));
  }

  public static ClientboundSetPlayerTeamPacket ofAddPlayer(String name, String player) {
    PlayerTeam team = new PlayerTeam(DUMMY, name);

    return ClientboundSetPlayerTeamPacket.createPlayerPacket(team, player, ClientboundSetPlayerTeamPacket.Action.ADD);
  }

  public static ClientboundSetPlayerTeamPacket ofRemovePlayer(String name, String player) {
    PlayerTeam team = new PlayerTeam(DUMMY, name);

    return ClientboundSetPlayerTeamPacket.createPlayerPacket(team, player, ClientboundSetPlayerTeamPacket.Action.REMOVE);
  }
}
