/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityTeleport extends ExPacketPlayOut {

    static ExPacketPlayOutEntityTeleport wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityTeleport(player);
    }

    static ExPacketPlayOutEntityTeleport wrap(LivingEntity entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityTeleport(entity);
    }
}
