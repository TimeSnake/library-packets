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

package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.packets.core.UnsupportedPacketException;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.Util;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore;
import net.minecraft.server.ScoreboardServer;


public abstract class ExPacketPlayOutSideboard extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSideboard {

    public static ExPacketPlayOut getPacket(PacketPlayOutScoreboardScore packet) throws UnsupportedPacketException {
        ScoreboardServer.Action type = (ScoreboardServer.Action) Util.getInstanceField(packet, "d");
        int line = (int) Util.getInstanceField(packet, "c");
        String text = (String) Util.getInstanceField(packet, "a");
        String scoreboardName = (String) Util.getInstanceField(packet, "b");

        if (type.equals(Action.CHANGE.getNms())) {
            return new ExPacketPlayOutSideboardScoreSet(scoreboardName, text, line);
        } else if (type.equals(Action.REMOVE.getNms())) {
            return new ExPacketPlayOutSideboardScoreRemove(scoreboardName, text, line);
        }

        throw new UnsupportedPacketException(packet);
    }

    protected final String sideboardName;
    protected final int line;
    protected final String text;

    public ExPacketPlayOutSideboard(Packet<? extends PacketListener> packet, String sideboardName, int line,
                                    String text) {
        super(packet);
        this.sideboardName = sideboardName;
        this.line = line;
        this.text = text;
    }

    public ExPacketPlayOutSideboard(String sideboardName, Integer line, String text) {
        this.sideboardName = sideboardName;
        this.line = line;
        this.text = text;
    }

    @Override
    public String getSideboardName() {
        return sideboardName;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getInfo() {
        return "line: " + this.line + " text: " + this.text;
    }

    public enum Action {
        CHANGE(ScoreboardServer.Action.a),
        REMOVE(ScoreboardServer.Action.b);


        private final ScoreboardServer.Action nms;

        Action(ScoreboardServer.Action nms) {
            this.nms = nms;
        }

        public ScoreboardServer.Action getNms() {
            return nms;
        }
    }
}
