package de.timesnake.basic.packets.core.packet.in;

import de.timesnake.basic.packets.core.ExPacket;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;

@NmsReflection(usesReflection = true)
public class ExPacketPlayInUseEntity extends ExPacketPlayIn implements de.timesnake.basic.packets.util.packet.ExPacketPlayInUseEntity {

    public ExPacketPlayInUseEntity(PacketPlayInUseEntity packet) {
        this.packet = packet;
    }

    @Override
    public UseType getUseType() {
        Object type = RefUtil.invokeMethod(RefUtil.getInstanceField(this.packet, "b"), "a");
        if (RefUtil.invokeMethod(type, "name").equals("INTERACT")) {
            return UseType.INTERACT;
        } else if (RefUtil.invokeMethod(type, "name").equals("ATTACK")) {
            return UseType.ATTACK;
        } else if (RefUtil.invokeMethod(type, "name").equals("INTERACT_AT")) {
            return UseType.INTERACT_AT;
        }
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public ExPacket.Type getType() {
        return ExPacket.Type.PLAY_IN_USE_ENTITY;
    }
}
