package de.timesnake.basic.packets.core.packet.out;

import net.minecraft.network.protocol.game.PacketPlayOutRemoveEntityEffect;
import net.minecraft.world.effect.MobEffectList;
import org.bukkit.entity.Player;

public class ExPacketPlayOutEntityEffectRemove extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityEffectRemove {

    public ExPacketPlayOutEntityEffectRemove(Player p, ExPacketPlayOutEntityEffect.Effect effect) {
        super.packet = new PacketPlayOutRemoveEntityEffect(p.getEntityId(), MobEffectList.a(effect.getId()));
    }

    public ExPacketPlayOutEntityEffectRemove(PacketPlayOutRemoveEntityEffect packet) {
        super(packet);
    }

    @Override
    public String getInfo() {
        return "entity effect remove";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_EFFECT_REMOVE;
    }
}
