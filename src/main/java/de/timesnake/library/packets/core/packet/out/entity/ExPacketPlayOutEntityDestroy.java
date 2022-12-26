/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import org.bukkit.entity.Entity;

public class ExPacketPlayOutEntityDestroy extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityDestroy {

    public ExPacketPlayOutEntityDestroy(Entity entity) {
        super.packet = new PacketPlayOutEntityDestroy(entity.getEntityId());
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
