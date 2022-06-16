package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.bukkit.extension.ExPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutSpawnNamedEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnNamedEntity wrap(Player player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnNamedEntity(player);
    }

    static ExPacketPlayOutSpawnNamedEntity wrap(ExPlayer player) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnNamedEntity(player);
    }

    @Override
    String getInfo();

    @Override
    Type getType();
}
