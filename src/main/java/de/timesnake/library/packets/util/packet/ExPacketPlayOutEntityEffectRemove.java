package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityEffectRemove extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEffectRemove wrap(Player player, ExPacketPlayOutEntityEffect.Effect effect) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEffectRemove(player,
                effect);
    }
}
