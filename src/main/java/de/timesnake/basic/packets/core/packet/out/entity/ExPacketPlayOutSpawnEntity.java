package de.timesnake.basic.packets.core.packet.out.entity;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

public class ExPacketPlayOutSpawnEntity extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutSpawnEntity {

    public ExPacketPlayOutSpawnEntity(Entity entity) {
        super(new PacketPlayOutSpawnEntity(((CraftEntity) entity).getHandle()));
    }

    public ExPacketPlayOutSpawnEntity(ExEntity entity) {
        super(new PacketPlayOutSpawnEntity(entity.getNMS()));
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
