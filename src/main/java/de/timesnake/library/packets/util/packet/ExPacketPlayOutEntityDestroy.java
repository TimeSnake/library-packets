/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityDestroy extends ExPacketPlayOut {

    static ExPacketPlayOutEntityDestroy wrap(Entity entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityDestroy(entity);
    }
}
