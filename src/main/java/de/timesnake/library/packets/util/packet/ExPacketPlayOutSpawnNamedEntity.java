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

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnNamedEntity wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnNamedEntity(player);
    }

    static ExPacketPlayOutSpawnNamedEntity wrap(ExPlayer player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnNamedEntity(player);
    }

    @Override
    String getInfo();

    @Override
    Type getType();
}
