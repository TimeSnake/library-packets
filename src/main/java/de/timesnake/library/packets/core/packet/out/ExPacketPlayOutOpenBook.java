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

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.entities.wrapper.ExEnumHand;
import net.minecraft.network.protocol.game.PacketPlayOutOpenBook;

public class ExPacketPlayOutOpenBook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutOpenBook {

    public static ExPacketPlayOutOpenBook getPacket(PacketPlayOutOpenBook packet) {
        return new ExPacketPlayOutOpenBook(packet);
    }

    public ExPacketPlayOutOpenBook(PacketPlayOutOpenBook packet) {
        super(packet);
    }

    public ExPacketPlayOutOpenBook(boolean mainHand) {
        super(new PacketPlayOutOpenBook(mainHand ? ExEnumHand.MAIN_HAND.getNMS() : ExEnumHand.OFF_HAND.getNMS()));
    }

    @Override
    public String getInfo() {
        return "open_book";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_OPEN_BOOK;
    }
}
