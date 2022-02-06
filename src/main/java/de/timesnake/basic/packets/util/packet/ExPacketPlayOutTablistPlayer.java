package de.timesnake.basic.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutTablistPlayer extends ExPacketPlayOutTablist {

    Player getPlayer();
}
