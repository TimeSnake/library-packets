/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnNamedEntity wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnNamedEntity(player);
    }

    @Override
    String getInfo();

    @Override
    Type getType();
}
