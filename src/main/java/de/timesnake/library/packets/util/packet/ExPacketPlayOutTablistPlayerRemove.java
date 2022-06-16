package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.bukkit.extension.ExPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutTablistPlayerRemove extends ExPacketPlayOutTablistPlayer {

    static ExPacketPlayOutTablistPlayerRemove wrap(ExPlayer entity) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(entity);
    }

    static ExPacketPlayOutTablistPlayerRemove wrap(Player players) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(players);
    }

    static ExPacketPlayOutTablistPlayerRemove wrap(String name, Head head) {
        return new de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(name,
                head);
    }
}
