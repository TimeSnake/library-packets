/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ExPacketPlayOutPlayerInfo extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutPlayerInfo {


    public ExPacketPlayOutPlayerInfo(Player player, Action action) {
        super.packet = new PacketPlayOutPlayerInfo(action.getAction(), ((CraftPlayer) player).getHandle());
    }

    public ExPacketPlayOutPlayerInfo(ExPlayer player, Action action) {
        super.packet = new PacketPlayOutPlayerInfo(action.getAction(), player.getHandle());
    }

    public ExPacketPlayOutPlayerInfo(EntityPlayer player, Action action) {
        super.packet = new PacketPlayOutPlayerInfo(action.getAction(), player);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }
}
