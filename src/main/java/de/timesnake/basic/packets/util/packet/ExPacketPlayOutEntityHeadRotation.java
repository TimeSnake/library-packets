package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityHeadRotation extends ExPacketPlayOut {

    static ExPacketPlayOutEntityHeadRotation wrap(EntityExtension<?> entity, float yaw) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityHeadRotation(entity, yaw);
    }

    static ExPacketPlayOutEntityHeadRotation wrap(Entity entity, float yaw) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityHeadRotation(((CraftEntity) entity).getHandle(), yaw);
    }

    static ExPacketPlayOutEntityHeadRotation wrap(ExEntity entity, float yaw) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityHeadRotation(entity.getNMS(), yaw);
    }
}
