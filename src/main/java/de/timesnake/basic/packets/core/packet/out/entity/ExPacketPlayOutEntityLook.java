package de.timesnake.basic.packets.core.packet.out.entity;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import org.bukkit.entity.Entity;

@NmsReflection
public class ExPacketPlayOutEntityLook extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityLook {

    public ExPacketPlayOutEntityLook(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityLook(EntityExtension<?> entity, float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getExtension().getId(), (byte) (yaw * 256 / 360)
                , (byte) (pitch * 256 / 360), onGround));
    }

    public ExPacketPlayOutEntityLook(Entity entity, float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getEntityId(), (byte) (yaw * 256 / 360),
                (byte) (pitch * 256 / 360), onGround));
    }

    public static ExPacketPlayOutEntityLook getPacket(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        return new ExPacketPlayOutEntityLook(packet);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_LOOK;
    }
}
