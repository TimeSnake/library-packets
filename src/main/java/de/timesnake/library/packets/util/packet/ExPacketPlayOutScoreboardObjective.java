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

import net.minecraft.world.scores.criteria.IScoreboardCriteria;

public interface ExPacketPlayOutScoreboardObjective extends ExPacketPlayOut {

    static ExPacketPlayOutScoreboardObjective wrap(String name, String title, Display display, ScoreboardType type) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardObjective(name,
                title, display, type);
    }

    enum ScoreboardType {
        INTEGER(IScoreboardCriteria.EnumScoreboardHealthDisplay.a),
        HEARTS(IScoreboardCriteria.EnumScoreboardHealthDisplay.b);

        private final IScoreboardCriteria.EnumScoreboardHealthDisplay type;

        ScoreboardType(IScoreboardCriteria.EnumScoreboardHealthDisplay type) {
            this.type = type;
        }

        public IScoreboardCriteria.EnumScoreboardHealthDisplay getType() {
            return type;
        }
    }

    enum Display {
        CREATE(0),
        REMOVE(1),
        UPDATE(2);

        private final int display;

        Display(int display) {
            this.display = display;
        }

        public int getDisplay() {
            return display;
        }
    }
}
