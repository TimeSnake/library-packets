package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

@NmsReflection
public class ExPacketPlayOutSpawnEntityLiving extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSpawnEntityLiving {

    private final String name;
    private final UUID uuid;

    public ExPacketPlayOutSpawnEntityLiving(Player player) {
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        super.packet = new PacketPlayOutNamedEntitySpawn(((CraftPlayer) player).getHandle());
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
