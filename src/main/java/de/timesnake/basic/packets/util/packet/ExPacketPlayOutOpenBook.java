package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutOpenBook extends ExPacketPlayOut {

    static ExPacketPlayOutOpenBook wrap(boolean mainHand) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutOpenBook(mainHand);
    }
}
