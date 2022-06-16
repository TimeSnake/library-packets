package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.bukkit.extension.ExPlayer;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSpawnNamedEntity {

    private final String playerName;

    public ExPacketPlayOutSpawnNamedEntity(Player player) {
        super.packet = new PacketPlayOutNamedEntitySpawn(((CraftPlayer) player).getHandle());
        this.playerName = player.getName();
    }

    public ExPacketPlayOutSpawnNamedEntity(ExPlayer player) {
        super.packet = new PacketPlayOutNamedEntitySpawn(player.getHandle());
        this.playerName = player.getName();
    }

    @Override
    public String getInfo() {
        return this.playerName;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SPAWN_NAMED_ENTITY;
    }
}
