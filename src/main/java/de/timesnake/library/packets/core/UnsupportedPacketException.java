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

package de.timesnake.library.packets.core;


import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;

public class UnsupportedPacketException extends Exception {

    private final Packet<? extends PacketListener> packet;

    public UnsupportedPacketException(Packet<? extends PacketListener> packet) {
        this.packet = packet;
    }

    public Packet<? extends PacketListener> getPacket() {
        return packet;
    }

    @Override
    public String getMessage() {
        return "Packet " + this.packet.getClass().getSimpleName() + " is not supported";
    }
}
