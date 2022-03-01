package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntity;

public interface ExPacketPlayOutEntityDestroy extends ExPacketPlayOut {

    static ExPacketPlayOutEntityDestroy wrap(EntityExtension<?> entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityDestroy(entity);
    }

    static ExPacketPlayOutEntityDestroy wrap(ExEntity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityDestroy(entity);
    }
}
