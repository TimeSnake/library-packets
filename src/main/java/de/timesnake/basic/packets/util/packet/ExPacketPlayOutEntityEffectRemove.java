package de.timesnake.basic.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityEffectRemove extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEffectRemove wrap(Player player, ExPacketPlayOutEntityEffect.Effect effect) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutEntityEffectRemove(player, effect);
    }
}
