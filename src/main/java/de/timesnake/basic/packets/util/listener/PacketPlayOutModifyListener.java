package de.timesnake.basic.packets.util.listener;

import de.timesnake.basic.packets.util.packet.ExPacketPlayOut;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface PacketPlayOutModifyListener {

    ExPacketPlayOut onPacketPlayOut(ExPacketPlayOut packet, Player receiver);

}
