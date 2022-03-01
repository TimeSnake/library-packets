package de.timesnake.basic.packets.core.packet.out.entity;

import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ExPacketPlayOutEntityTeleport extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityTeleport {

    public ExPacketPlayOutEntityTeleport(Player player) {
        super(new PacketPlayOutEntityTeleport(((CraftPlayer) player).getHandle()));
    }

    public ExPacketPlayOutEntityTeleport(LivingEntity entity) {
        super(new PacketPlayOutEntityTeleport(((CraftLivingEntity) entity).getHandle()));
    }

    public ExPacketPlayOutEntityTeleport(ExEntityLiving entity) {
        super(new PacketPlayOutEntityTeleport(entity.getNMS()));
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_TELEPORT;
    }
}
