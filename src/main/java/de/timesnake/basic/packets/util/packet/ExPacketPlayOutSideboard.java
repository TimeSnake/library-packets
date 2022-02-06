package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutSideboard extends ExPacketPlayOut {

    String getSideboardName();

    int getLine();

    String getText();
}
