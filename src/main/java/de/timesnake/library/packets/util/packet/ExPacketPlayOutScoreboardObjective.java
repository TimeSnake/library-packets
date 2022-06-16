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
