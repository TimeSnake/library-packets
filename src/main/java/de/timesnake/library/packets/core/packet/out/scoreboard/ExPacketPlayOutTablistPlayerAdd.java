/*
 * library-packets.main
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

import de.timesnake.library.packets.util.packet.ExPacketPlayOutTablist;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutTablistPlayerAdd extends ExPacketPlayOutTablistPlayer implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistPlayerAdd {

    public ExPacketPlayOutTablistPlayerAdd(EntityPlayer entityPlayers) {
        super(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, entityPlayers),
                entityPlayers);
    }

    public ExPacketPlayOutTablistPlayerAdd(Player player) {
        super(player);
        super.packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a,
                ((CraftPlayer) player).getHandle());
    }

    public ExPacketPlayOutTablistPlayerAdd(String name, Head head) {
        super(ExPacketPlayOutTablist.newEntry(name, head).getBukkitEntity());
        super.packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a,
                ((CraftPlayer) super.player).getHandle());
    }

    public ExPacketPlayOutTablistPlayerAdd(PacketPlayOutPlayerInfo packet, Player player) {
        super(player);
        super.packet = packet;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_PLAYER_ADD;
    }

    @Override
    public String getInfo() {
        return "player: " + this.player.getName() + " " + this.player.getPlayerListName() + " add";
    }
}

