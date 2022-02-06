package de.timesnake.basic.packets.util.packet;

public interface ExPacketPlayOutTablistHeaderFooter extends ExPacketPlayOutTablist {

    static ExPacketPlayOutTablistHeaderFooter wrap(String header, String footer) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistHeaderFooter(header, footer);
    }
}
