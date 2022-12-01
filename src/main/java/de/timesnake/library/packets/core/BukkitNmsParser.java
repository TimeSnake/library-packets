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
