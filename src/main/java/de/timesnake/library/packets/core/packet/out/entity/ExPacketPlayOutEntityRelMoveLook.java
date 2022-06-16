package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import org.bukkit.entity.LivingEntity;

@NmsReflection
public class ExPacketPlayOutEntityRelMoveLook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityRelMoveLook {

    public ExPacketPlayOutEntityRelMoveLook(LivingEntity entity, double deltaX, double deltaY, double deltaZ,
                                            float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook(entity.getEntityId(),
                (short) (deltaX * 32 * 128), (short) (deltaY * 32 * 128), (short) (deltaZ * 32 * 128),
                (byte) (yaw * 256 / 360), (byte) (pitch * 256 / 360), onGround));
    }

    public ExPacketPlayOutEntityRelMoveLook(ExEntityLiving entity, double deltaX, double deltaY, double deltaZ,
                                            float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook(entity.getId(), (short) (deltaX * 32 * 128),
                (short) (deltaY * 32 * 128), (short) (deltaZ * 32 * 128), (byte) (yaw * 256 / 360),
                (byte) (pitch * 256 / 360), onGround));
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_REL_MOVE_LOOK;
    }
}
