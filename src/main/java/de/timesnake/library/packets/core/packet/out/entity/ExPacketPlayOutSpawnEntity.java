/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

public class ExPacketPlayOutSpawnEntity extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSpawnEntity {

    public ExPacketPlayOutSpawnEntity(Entity entity) {
        super(new PacketPlayOutSpawnEntity(((CraftEntity) entity).getHandle()));
    }

    public ExPacketPlayOutSpawnEntity(Entity entity, int data) {
        super(new PacketPlayOutSpawnEntity(((CraftEntity) entity).getHandle(), data));
    }

    public ExPacketPlayOutSpawnEntity(Entity entity, ItemFrameRotation rotation) {
        super(new PacketPlayOutSpawnEntity(((CraftEntity) entity).getHandle(), rotation.getNms()));
    }

    public ExPacketPlayOutSpawnEntity(PacketPlayOutSpawnEntity packet) {
        super(packet);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_SPAWN;
    }
}
