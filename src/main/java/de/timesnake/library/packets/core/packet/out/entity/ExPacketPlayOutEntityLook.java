package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import org.bukkit.entity.Entity;

@NmsReflection
public class ExPacketPlayOutEntityLook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityLook {

    public static ExPacketPlayOutEntityLook getPacket(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        return new ExPacketPlayOutEntityLook(packet);
    }

    public ExPacketPlayOutEntityLook(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityLook(ExtendedCraftEntity<?> entity, float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getExtension().getId(), (byte) (yaw * 256 / 360)
                , (byte) (pitch * 256 / 360), onGround));
    }

    public ExPacketPlayOutEntityLook(Entity entity, float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getEntityId(), (byte) (yaw * 256 / 360),
                (byte) (pitch * 256 / 360), onGround));
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
