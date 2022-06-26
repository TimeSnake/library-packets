package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;

@NmsReflection
public class ExPacketPlayOutEntityDestroy extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityDestroy {

    public ExPacketPlayOutEntityDestroy(ExtendedCraftEntity<?> entity) {
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
