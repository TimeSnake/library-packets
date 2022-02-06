package de.timesnake.basic.packets.util.listener;

import de.timesnake.basic.packets.util.packet.ExPacketPlayOut;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface PacketPlayOutListener {

    void onPacketPlayOut(final ExPacketPlayOut packet, Player receiver);

}
