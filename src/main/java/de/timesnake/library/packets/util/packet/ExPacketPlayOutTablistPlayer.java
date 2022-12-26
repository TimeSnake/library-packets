/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutTablistPlayer extends ExPacketPlayOutTablist {

    Player getPlayer();
}
