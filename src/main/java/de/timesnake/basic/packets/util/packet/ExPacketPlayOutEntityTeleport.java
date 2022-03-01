package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityTeleport extends ExPacketPlayOut {

    static ExPacketPlayOutEntityTeleport wrap(Player player) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityTeleport(player);
    }

    static ExPacketPlayOutEntityTeleport wrap(LivingEntity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityTeleport(entity);
    }

    static ExPacketPlayOutEntityTeleport wrap(ExEntityLiving entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityTeleport(entity);
    }
}
