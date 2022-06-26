package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import de.timesnake.library.entities.entity.extension.ExEntity;

public interface ExPacketPlayOutEntityDestroy extends ExPacketPlayOut {

    static ExPacketPlayOutEntityDestroy wrap(ExtendedCraftEntity<?> entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityDestroy(entity);
    }

    static ExPacketPlayOutEntityDestroy wrap(ExEntity entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityDestroy(entity);
    }
}
