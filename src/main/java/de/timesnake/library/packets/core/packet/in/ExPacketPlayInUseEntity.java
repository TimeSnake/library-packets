/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.in;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.reflection.Util;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;

public class ExPacketPlayInUseEntity extends ExPacketPlayIn implements de.timesnake.library.packets.util.packet.ExPacketPlayInUseEntity {

    public ExPacketPlayInUseEntity(PacketPlayInUseEntity packet) {
        this.packet = packet;
    }

    @Override
    public UseType getUseType() {
        Object type = Util.invokeMethod(Util.getInstanceField(this.packet, "b"), "a");
        if (Util.invokeMethod(type, "name").equals("INTERACT")) {
            return UseType.INTERACT;
        } else if (Util.invokeMethod(type, "name").equals("ATTACK")) {
            return UseType.ATTACK;
        } else if (Util.invokeMethod(type, "name").equals("INTERACT_AT")) {
            return UseType.INTERACT_AT;
        }
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return ExPacket.Type.PLAY_IN_USE_ENTITY;
    }
}
