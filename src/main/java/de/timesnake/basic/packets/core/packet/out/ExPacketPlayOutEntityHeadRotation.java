package de.timesnake.basic.packets.core.packet.out;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.world.entity.Entity;

public class ExPacketPlayOutEntityHeadRotation extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityHeadRotation {

    public ExPacketPlayOutEntityHeadRotation(PacketPlayOutEntityHeadRotation packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityHeadRotation(EntityExtension<?> entity, float yaw) {
        super(new PacketPlayOutEntityHeadRotation(entity.getExtension().getNMS(), (byte) (yaw * 256 / 360)));
    }

    public ExPacketPlayOutEntityHeadRotation(Entity entity, float yaw) {
        super(new PacketPlayOutEntityHeadRotation(entity, (byte) (yaw * 256 / 360)));
    }

    public static ExPacketPlayOutEntityHeadRotation getPacket(PacketPlayOutEntityHeadRotation packet) {
        return new ExPacketPlayOutEntityHeadRotation(packet);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_HEAD_ROTATION;
    }
}
