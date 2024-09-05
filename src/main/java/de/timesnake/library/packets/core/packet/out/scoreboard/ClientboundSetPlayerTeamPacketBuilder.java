/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import com.google.common.collect.ImmutableList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

  private static final Constructor<ClientboundSetPlayerTeamPacket> CONSTRUCTOR;
  private static final Constructor<ClientboundSetPlayerTeamPacket.Parameters> PARAMETERS_CONSTRUCTOR;

  static {
    try {
      CONSTRUCTOR = ClientboundSetPlayerTeamPacket.class.getDeclaredConstructor(String.class, int.class,
          Optional.class, Collection.class);
      CONSTRUCTOR.setAccessible(true);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }

    PARAMETERS_CONSTRUCTOR = (Constructor<ClientboundSetPlayerTeamPacket.Parameters>)
        ReflectionFactory.getReflectionFactory().newConstructorForSerialization(ClientboundSetPlayerTeamPacket.Parameters.class);
  }

  private static ClientboundSetPlayerTeamPacket.Parameters createParameters(String name, Component prefix,
                                                                            ChatFormatting color,
                                                                            Team.Visibility visibility) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    ClientboundSetPlayerTeamPacket.Parameters parameters = PARAMETERS_CONSTRUCTOR.newInstance();

    Field displayNameField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField("displayName");
    displayNameField.setAccessible(true);
    displayNameField.set(parameters, Component.literal(name));

    Field playerPrefixField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField("playerPrefix");
    playerPrefixField.setAccessible(true);
    playerPrefixField.set(parameters, prefix);

    Field playerSuffixField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField("playerSuffix");
    playerSuffixField.setAccessible(true);
    playerSuffixField.set(parameters, Component.empty());

    Field nametagVisibilityField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField(
        "nametagVisibility");
    nametagVisibilityField.setAccessible(true);
    nametagVisibilityField.set(parameters, visibility);

    Field collisionRuleField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField("collisionRule");
    collisionRuleField.setAccessible(true);
    collisionRuleField.set(parameters, Team.CollisionRule.ALWAYS.name());

    Field colorField = ClientboundSetPlayerTeamPacket.Parameters.class.getDeclaredField("color");
    colorField.setAccessible(true);
    colorField.set(parameters, color);
    return parameters;
  }

  public static ClientboundSetPlayerTeamPacket ofCreate(String name, Component prefix, ChatFormatting color, Team.Visibility visibility) {
    return ofCreate(name, prefix, color, visibility, List.of());
  }

  public static ClientboundSetPlayerTeamPacket ofCreate(String name, Component prefix, ChatFormatting color,
                                                        Team.Visibility visibility, Collection<String> playerNames) {
    try {
      return CONSTRUCTOR.newInstance(name, 0, Optional.of(createParameters(name, prefix, color, visibility)),
          ImmutableList.of(playerNames));
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }

  public static ClientboundSetPlayerTeamPacket ofModify(String name, Component prefix, ChatFormatting color, Team.Visibility visibility) {
    try {
      return CONSTRUCTOR.newInstance(name, 2, Optional.of(createParameters(name, prefix, color, visibility)),
          ImmutableList.of());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }

  public static ClientboundSetPlayerTeamPacket ofRemove(String name) {
    try {
      return CONSTRUCTOR.newInstance(name, 1, Optional.empty(), ImmutableList.of());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public static ClientboundSetPlayerTeamPacket ofAddPlayer(String name, String player) {
    try {
      return CONSTRUCTOR.newInstance(name, 3, Optional.empty(), ImmutableList.of(player));
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public static ClientboundSetPlayerTeamPacket ofRemovePlayer(String name, String player) {
    try {
      return CONSTRUCTOR.newInstance(name, 4, Optional.empty(), ImmutableList.of(player));
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
