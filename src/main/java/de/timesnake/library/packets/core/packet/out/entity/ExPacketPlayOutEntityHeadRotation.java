package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.extension.EntityExtension;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.world.entity.Entity;

@NmsReflection
public class ExPacketPlayOutEntityHeadRotation extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityHeadRotation {

    public static ExPacketPlayOutEntityHeadRotation getPacket(PacketPlayOutEntityHeadRotation packet) {
        return new ExPacketPlayOutEntityHeadRotation(packet);
    }

    private int entityId;
    private float yaw;

    public ExPacketPlayOutEntityHeadRotation(PacketPlayOutEntityHeadRotation packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityHeadRotation(EntityExtension<?> entity, float yaw) {
        super(new PacketPlayOutEntityHeadRotation(entity.getExtension().getNMS(), (byte) (yaw * 256 / 360)));
        this.entityId = entity.getExtension().getId();
        this.yaw = yaw;
    }

    public ExPacketPlayOutEntityHeadRotation(Entity entity, float yaw) {
        super(new PacketPlayOutEntityHeadRotation(entity, (byte) (yaw * 256 / 360)));
        this.entityId = entity.getBukkitEntity().getEntityId();
        this.yaw = yaw;
    }

    @Override
    public String getInfo() {
        return "entity id: " + this.entityId + " yaw: " + yaw;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_HEAD_ROTATION;
    }
}
