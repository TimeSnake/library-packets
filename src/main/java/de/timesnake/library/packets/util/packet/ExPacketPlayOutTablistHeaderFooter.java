/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutTablistHeaderFooter extends ExPacketPlayOutTablist {

    static ExPacketPlayOutTablistHeaderFooter wrap(String header, String footer) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistHeaderFooter(header,
                footer);
    }
}
