package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.bukkit.ExPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutTablistPlayerRemove extends ExPacketPlayOutTablistPlayer {

    static ExPacketPlayOutTablistPlayerRemove wrap(ExPlayer entity) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(entity);
    }

    static ExPacketPlayOutTablistPlayerRemove wrap(Player players) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(players);
    }

    static ExPacketPlayOutTablistPlayerRemove wrap(String name, Head head) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerRemove(name, head);
    }
}
