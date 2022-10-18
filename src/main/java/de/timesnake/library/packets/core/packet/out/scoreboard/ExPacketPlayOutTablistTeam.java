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

import de.timesnake.library.packets.core.UnsupportedPacketException;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.EnumChatFormat;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import org.bukkit.ChatColor;

import java.util.Collection;
import java.util.Optional;

@NmsReflection(usesReflection = true)
public abstract class ExPacketPlayOutTablistTeam extends ExPacketPlayOutTablist
        implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeam {

    public static ExPacketPlayOut getPacket(PacketPlayOutScoreboardTeam packet) throws UnsupportedPacketException {
        String name = (String) RefUtil.getInstanceField(packet, "i");
        int type = (int) RefUtil.getInstanceField(packet, "h");

        if (type == 0) {
            String prefix =
                    ((Optional<PacketPlayOutScoreboardTeam.b>) RefUtil.getInstanceField(packet, "k")).get().f().getString();
            return new ExPacketPlayOutTablistTeamCreation(packet, name, prefix);
        } else if (type == 1) {
            return new ExPacketPlayOutTablistTeamRemove(name);
        } else if (type == 2) {
            String prefix =
                    ((Optional<PacketPlayOutScoreboardTeam.b>) RefUtil.getInstanceField(packet, "k")).get().f().getString();
            return new ExPacketPlayOutTablistTeamUpdate(name, prefix);
        } else if (type == 3) {
            Collection<String> entries = (Collection<String>) RefUtil.getInstanceField(packet, "j");
            return new ExPacketPlayOutTablistTeamPlayerAdd(name, entries.iterator().next());
        } else if (type == 4) {
            Collection<String> entries = (Collection<String>) RefUtil.getInstanceField(packet, "j");
            return new ExPacketPlayOutTablistTeamPlayerRemove(name, entries.iterator().next());
        }
        throw new UnsupportedPacketException(packet);

    }

    static EnumChatFormat getEnumChatFormat(ChatColor chatColor) {
        if (chatColor == null) {
            chatColor = ChatColor.WHITE;
        }

        return switch (chatColor) {
            case BLACK -> EnumChatFormat.a;
            case DARK_BLUE -> EnumChatFormat.b;
            case DARK_GREEN -> EnumChatFormat.c;
            case DARK_AQUA -> EnumChatFormat.d;
            case DARK_RED -> EnumChatFormat.e;
            case DARK_PURPLE -> EnumChatFormat.f;
            case GOLD -> EnumChatFormat.g;
            case GRAY -> EnumChatFormat.h;
            case DARK_GRAY -> EnumChatFormat.i;
            case BLUE -> EnumChatFormat.j;
            case GREEN -> EnumChatFormat.k;
            case AQUA -> EnumChatFormat.l;
            case RED -> EnumChatFormat.m;
            case LIGHT_PURPLE -> EnumChatFormat.n;
            case YELLOW -> EnumChatFormat.o;
            case WHITE -> EnumChatFormat.p;
            case MAGIC -> EnumChatFormat.q;
            case BOLD -> EnumChatFormat.r;
            case STRIKETHROUGH -> EnumChatFormat.s;
            case UNDERLINE -> EnumChatFormat.t;
            case ITALIC -> EnumChatFormat.u;
            case RESET -> EnumChatFormat.v;
        };
    }

    protected final String name;

    public ExPacketPlayOutTablistTeam(Packet<? extends PacketListener> packet, String name) {
        super(packet);
        this.name = name;
    }


    public ExPacketPlayOutTablistTeam(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
