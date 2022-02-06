package de.timesnake.basic.packets.core.packet.out;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;

public class ExPacketPlayOutEntityDestroy extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityDestroy {

    public ExPacketPlayOutEntityDestroy(EntityExtension<?> entity) {
        super.packet = new PacketPlayOutEntityDestroy(entity.getExtension().getId());
    }

    public ExPacketPlayOutEntityDestroy(ExEntity entity) {
        super.packet = new PacketPlayOutEntityDestroy(entity.getId());
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_DESTROY_ENTITY;
    }
}
