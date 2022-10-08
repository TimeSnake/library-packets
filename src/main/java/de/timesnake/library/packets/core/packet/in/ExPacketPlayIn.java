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

package de.timesnake.library.packets.core.packet.in;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.packets.core.UnsupportedPacketException;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInArmAnimation;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;

public abstract class ExPacketPlayIn extends ExPacket implements de.timesnake.library.packets.util.packet.ExPacketPlayIn {

    public static ExPacketPlayIn getPacket(Packet<? extends PacketListener> packet) throws UnsupportedPacketException {
        if (packet instanceof PacketPlayInUseEntity) {
            return new ExPacketPlayInUseEntity(((PacketPlayInUseEntity) packet));
        } else if (packet instanceof PacketPlayInArmAnimation) {
            return new ExPacketPlayInArmAnimation((PacketPlayInArmAnimation) packet);
        }
        throw new UnsupportedPacketException(packet);
    }

    public ExPacketPlayIn() {

    }

    public ExPacketPlayIn(Packet<?> packet) {
        super(packet);
    }

}
