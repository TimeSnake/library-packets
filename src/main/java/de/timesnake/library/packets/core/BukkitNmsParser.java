/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core;

import io.netty.channel.Channel;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BukkitNmsParser {

  public static Channel getPlayerChannel(Player player) {
    return getPlayerConnection(player).connection.channel;
  }

  public static ServerGamePacketListenerImpl getPlayerConnection(Player player) {
    return ((CraftPlayer) player).getHandle().connection;
  }

  public static void sendPacket(Player player, Packet<?> packet) {
    getPlayerConnection(player).send(packet);
  }

}
