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

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

@NmsReflection
public class ExClientboundSetBorderSizePacket extends ExPacketPlayOut implements de.timesnake.library.packets.util.ExClientboundSetBorderSizePacket {

    public ExClientboundSetBorderSizePacket(ClientboundSetBorderSizePacket packet) {
        super(packet);
    }

    public ExClientboundSetBorderSizePacket(World world, double size) {
        super(new ClientboundSetBorderSizePacket(PacketWorldBorder.size(((CraftWorld) world).getHandle(), size)));
    }

    @Override
    public String getInfo() {
        return "border size";
    }

    @Override
    public ExPacket.Type getType() {
        return ExPacket.Type.PLAY_OUT_WORLD_BORDER_SIZE;
    }
}
