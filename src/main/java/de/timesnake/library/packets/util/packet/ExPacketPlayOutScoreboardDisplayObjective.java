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

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutScoreboardDisplayObjective extends ExPacketPlayOut {

    static ExPacketPlayOutScoreboardDisplayObjective wrap(String name, Slot slot) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardDisplayObjective(name, slot);
    }

    enum Slot {
        TABLIST(0),
        SIDEBOARD(1),
        BELOW_NAME(2);

        private final int type;

        Slot(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
