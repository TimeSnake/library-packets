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

import de.timesnake.library.basic.util.Tuple;
import net.minecraft.network.protocol.game.PacketPlayOutUnloadChunk;

public class ExPacketPlayOutChunkUnload extends ExPacketPlayOut {

    public ExPacketPlayOutChunkUnload(PacketPlayOutUnloadChunk packet) {
        super(packet);
    }

    public Tuple<Integer, Integer> getChunkCoordinates() {
        return new Tuple<>(((PacketPlayOutUnloadChunk) super.packet).b(),
                ((PacketPlayOutUnloadChunk) super.packet).c());
    }

    @Override
    public String getInfo() {
        Tuple<Integer, Integer> chunk = this.getChunkCoordinates();
        return "x=" + chunk.getA() + " y=" + chunk.getB();
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_CHUNK_UNLOAD;
    }
}
