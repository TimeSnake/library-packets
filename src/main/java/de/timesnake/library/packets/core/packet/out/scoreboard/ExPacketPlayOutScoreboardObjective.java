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
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardObjective;
import net.minecraft.world.scores.ScoreboardObjective;

@NmsReflection
public class ExPacketPlayOutScoreboardObjective extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutScoreboardObjective {

    public static ExPacketPlayOutScoreboardObjective getPacket(PacketPlayOutScoreboardObjective packet) {
        return new ExPacketPlayOutScoreboardObjective(packet);
    }

    private final String name;
    private Display display;

    public ExPacketPlayOutScoreboardObjective(PacketPlayOutScoreboardObjective packet) {
        super(packet);
        this.name = packet.b();
    }

    public ExPacketPlayOutScoreboardObjective(String name, String title, Display display,
                                              ExPacketPlayOutScoreboardObjective.ScoreboardType type) {
        ScoreboardObjective sb = new PacketScoreboardObjective(name, IChatBaseComponent.a(title), type.getType());

        super.packet = new PacketPlayOutScoreboardObjective(sb, display.getDisplay());

        this.name = name;
        this.display = display;
    }

    @Override
    public String getInfo() {
        return "objective: " + this.name + " " + this.display != null ? this.display.name().toLowerCase() : "";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SCOREBOARD_OBJ;
    }
}
