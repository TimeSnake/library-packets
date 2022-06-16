package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutOpenBook extends ExPacketPlayOut {

    static ExPacketPlayOutOpenBook wrap(boolean mainHand) {
        return new de.timesnake.library.packets.core.packet.out.ExPacketPlayOutOpenBook(mainHand);
    }
}
