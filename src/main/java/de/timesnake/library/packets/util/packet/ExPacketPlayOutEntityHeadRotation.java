/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.extension.ExEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityHeadRotation extends ExPacketPlayOut {

    static ExPacketPlayOutEntityHeadRotation wrap(Entity entity, float yaw) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation(((CraftEntity) entity).getHandle(), yaw);
    }

    static ExPacketPlayOutEntityHeadRotation wrap(ExEntity entity, float yaw) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation(entity.getNMS(), yaw);
    }
}
