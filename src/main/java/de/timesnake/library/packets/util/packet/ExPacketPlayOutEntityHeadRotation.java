package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.extension.EntityExtension;
import de.timesnake.library.entities.entity.extension.ExEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutEntityHeadRotation extends ExPacketPlayOut {

    static ExPacketPlayOutEntityHeadRotation wrap(EntityExtension<?> entity, float yaw) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation(entity, yaw);
    }

    static ExPacketPlayOutEntityHeadRotation wrap(Entity entity, float yaw) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation(((CraftEntity) entity).getHandle(), yaw);
    }

    static ExPacketPlayOutEntityHeadRotation wrap(ExEntity entity, float yaw) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation(entity.getNMS(), yaw);
    }
}
