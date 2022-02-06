package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.bukkit.ExPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnNamedEntity wrap(Player player) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutSpawnNamedEntity(player);
    }

    static ExPacketPlayOutSpawnNamedEntity wrap(ExPlayer player) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutSpawnNamedEntity(player);
    }

    @Override
    String getInfo();

    @Override
    Type getType();
}
