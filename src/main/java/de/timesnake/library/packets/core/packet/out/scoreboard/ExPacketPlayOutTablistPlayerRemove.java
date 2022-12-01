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

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import de.timesnake.library.packets.util.packet.ExPacketPlayOutTablist;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ExPacketPlayOutTablistPlayerRemove extends ExPacketPlayOutTablistPlayer implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistPlayerRemove {

    public ExPacketPlayOutTablistPlayerRemove(ExPlayer entityPlayer) {
        super(new PacketPlayOutPlayerInfo(ExEnumPlayerInfoAction.REMOVE_PLAYER.getNms(), entityPlayer.getHandle()),
                entityPlayer.getHandle());
    }

    public ExPacketPlayOutTablistPlayerRemove(Player player) {
        super(player);
        super.packet = new PacketPlayOutPlayerInfo(ExEnumPlayerInfoAction.REMOVE_PLAYER.getNms(),
                ((CraftPlayer) player).getHandle());
    }

    public ExPacketPlayOutTablistPlayerRemove(String name, Head head) {
        super(ExPacketPlayOutTablist.newEntry(name, head).getBukkitEntity());
        super.packet = new PacketPlayOutPlayerInfo(ExEnumPlayerInfoAction.REMOVE_PLAYER.getNms(),
                ((CraftPlayer) super.getPlayer()).getHandle());
    }

    public ExPacketPlayOutTablistPlayerRemove(PacketPlayOutPlayerInfo packet, Player player) {
        super(player);
        super.packet = packet;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_PLAYER_REMOVE;
    }

    @Override
    public String getInfo() {
        return "player: " + this.player.getName() + " " + this.player.getPlayerListName() + "remove";
    }
}

