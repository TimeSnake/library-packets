package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutScoreboardDisplayObjective extends ExPacketPlayOut {

    enum Slot {
        TABLIST(0), SIDEBOARD(1), BELOW_NAME(2);

        private final int type;

        Slot(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    static ExPacketPlayOutScoreboardDisplayObjective wrap(String name, Slot slot) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardDisplayObjective(name, slot);
    }
}
