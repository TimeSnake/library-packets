package de.timesnake.basic.packets.core;

import de.timesnake.library.reflection.NmsReflection;
import io.netty.channel.Channel;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.PlayerConnection;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;

@NmsReflection
public class BukkitNmsParser {

    public static ItemStack parseItem(org.bukkit.inventory.ItemStack item) {
        return CraftItemStack.asNMSCopy(item);
    }

    public static Channel getPlayerChannel(Player player) {
        return getPlayerConnection(player).a.m;
    }

    public static PlayerConnection getPlayerConnection(Player player) {
        return ((CraftPlayer) player).getHandle().b;
    }

    public static void sendPacket(Player player, Packet<?> packet) {
        getPlayerConnection(player).a(packet);
    }

}
