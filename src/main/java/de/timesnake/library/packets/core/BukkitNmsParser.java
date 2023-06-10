/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core;

import io.netty.channel.Channel;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.PlayerConnection;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;

public class BukkitNmsParser {

	public static ItemStack parseItem(org.bukkit.inventory.ItemStack item) {
		return CraftItemStack.asNMSCopy(item);
	}

	public static Channel getPlayerChannel(Player player) {
		return getPlayerConnection(player).b.m;
	}

	public static PlayerConnection getPlayerConnection(Player player) {
		return ((CraftPlayer) player).getHandle().b;
	}

	public static void sendPacket(Player player, Packet<?> packet) {
		getPlayerConnection(player).a(packet);
	}

}
