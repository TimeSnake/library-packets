package de.timesnake.basic.packets.util.packet;

import net.minecraft.server.level.EntityPlayer;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutTablistPlayerAdd extends ExPacketPlayOutTablistPlayer {

    static ExPacketPlayOutTablistPlayerAdd wrap(EntityPlayer entityPlayer) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerAdd(entityPlayer);
    }

    static ExPacketPlayOutTablistPlayerAdd wrap(Player player) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerAdd(player);
    }

    static ExPacketPlayOutTablistPlayerAdd wrap(String name, Head head) {
        return new de.timesnake.basic.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayerAdd(name, head);
    }
}
