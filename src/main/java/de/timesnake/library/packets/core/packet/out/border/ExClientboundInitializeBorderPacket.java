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

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class ExClientboundInitializeBorderPacket extends ExPacketPlayOut implements de.timesnake.library.packets.util.ExClientboundInitializeBorderPacket {

    public ExClientboundInitializeBorderPacket(ClientboundInitializeBorderPacket packet) {
        super(packet);
    }

    public ExClientboundInitializeBorderPacket(World world, double centerX, double centerZ, double startSize,
                                               double shrinkSize, long time, int warningDistance, int warningTime) {

        super(new ClientboundInitializeBorderPacket(new PacketWorldBorder(((CraftWorld) world).getHandle(), centerX,
                centerZ, startSize, shrinkSize, time, warningDistance, warningTime)));
    }

    @Override
    public String getInfo() {
        return "border init";
    }

    @Override
    public ExPacket.Type getType() {
        return ExPacket.Type.PLAY_OUT_WORLD_BORDER_INIT;
    }
}
