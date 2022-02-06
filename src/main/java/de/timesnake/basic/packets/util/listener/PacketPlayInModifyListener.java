package de.timesnake.basic.packets.util.listener;

import de.timesnake.basic.packets.util.packet.ExPacketPlayIn;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface PacketPlayInModifyListener {

    ExPacketPlayIn onPacketPlayIn(ExPacketPlayIn packet, Player sender);
}
