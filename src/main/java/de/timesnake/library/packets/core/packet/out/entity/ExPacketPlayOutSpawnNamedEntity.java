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

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSpawnNamedEntity {

    private final String playerName;

    public ExPacketPlayOutSpawnNamedEntity(Player player) {
        super.packet = new PacketPlayOutNamedEntitySpawn(((CraftPlayer) player).getHandle());
        this.playerName = player.getName();
    }

    @Override
    public String getInfo() {
        return this.playerName;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SPAWN_NAMED_ENTITY;
    }
}
