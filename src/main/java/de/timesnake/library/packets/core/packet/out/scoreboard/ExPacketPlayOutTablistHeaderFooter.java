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

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;

@NmsReflection
public class ExPacketPlayOutTablistHeaderFooter extends ExPacketPlayOutTablist implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistHeaderFooter {

    public static ExPacketPlayOut getPacket(PacketPlayOutPlayerListHeaderFooter packet) {
        return new ExPacketPlayOutTablistHeaderFooter(packet);
    }

    private final String header;
    private final String footer;

    public ExPacketPlayOutTablistHeaderFooter(String header, String footer) {
        if (footer == null) {
            footer = "";
        }

        if (header == null) {
            header = "";
        }

        super.packet =
                new PacketPlayOutPlayerListHeaderFooter(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}"), IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}"));

        this.header = header;
        this.footer = footer;
    }

    public ExPacketPlayOutTablistHeaderFooter(PacketPlayOutPlayerListHeaderFooter packet) {
        super.packet = packet;
        if (packet.a != null) {
            this.header = packet.a.getString();
        } else {
            this.header = null;
        }
        if (packet.b != null) {
            this.footer = packet.b.getString();
        } else {
            this.footer = null;
        }
    }

    @Override
    public String getInfo() {
        return "header: " + this.header + " footer: " + this.footer;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_HEADER_FOOTER;
    }
}
