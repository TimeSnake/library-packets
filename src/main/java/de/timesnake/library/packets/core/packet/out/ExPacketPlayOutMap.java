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

package de.timesnake.library.packets.core.packet.out;

import net.minecraft.network.protocol.game.PacketPlayOutMap;
import net.minecraft.world.level.saveddata.maps.WorldMap;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R1.map.CraftMapView;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;

public class ExPacketPlayOutMap extends ExPacketPlayOut {

    public ExPacketPlayOutMap(PacketPlayOutMap packet) {
        super(packet);
    }

    public ExPacketPlayOutMap(int id, byte scale, boolean locked, byte[] colors) {
        super(new PacketPlayOutMap(id, scale, locked, null, new WorldMap.b(0, 0, 128, 128, colors)));
    }

    public ExPacketPlayOutMap(int id, byte scale, boolean locked, MapView view, Player player) {
        super(new PacketPlayOutMap(id, scale, locked, null, new WorldMap.b(0, 0, 128, 128,
                ((CraftMapView) view).render(((CraftPlayer) player)).buffer)));
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
