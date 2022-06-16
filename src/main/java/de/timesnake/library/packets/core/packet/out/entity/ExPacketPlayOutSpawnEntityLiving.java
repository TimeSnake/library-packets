package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntityLiving;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

@NmsReflection
public class ExPacketPlayOutSpawnEntityLiving extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSpawnEntityLiving {

    private final String name;
    private final UUID uuid;

    public ExPacketPlayOutSpawnEntityLiving(Player player) {
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        super.packet = new PacketPlayOutSpawnEntityLiving(((CraftPlayer) player).getHandle());
    }

    public ExPacketPlayOutSpawnEntityLiving(LivingEntity entity) {
        this.name = entity.getCustomName() != null ? entity.getCustomName() : null;
        this.uuid = entity.getUniqueId();
        super.packet = new PacketPlayOutSpawnEntityLiving(((CraftLivingEntity) entity).getHandle());
    }

    public ExPacketPlayOutSpawnEntityLiving(ExEntityLiving entity) {
        this.name = entity.getCustomName() != null ? entity.getCustomName() : null;
        this.uuid = entity.getBukkitEntity().getUniqueId();
        super.packet = new PacketPlayOutSpawnEntityLiving(entity.getNMS());
    }


    @Override
    public String getInfo() {
        return this.name + " " + this.uuid;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SPAWN_ENTITY_LIVING;
    }
}
