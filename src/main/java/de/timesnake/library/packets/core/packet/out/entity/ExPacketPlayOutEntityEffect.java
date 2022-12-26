/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectList;
import org.bukkit.entity.Player;

public class ExPacketPlayOutEntityEffect extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityEffect {

    public ExPacketPlayOutEntityEffect(Player p, Effect effect, byte amplifier, int duration, boolean ambient,
                                       boolean showParticles, boolean showIcon) {

        MobEffect mobEffect = new MobEffect(MobEffectList.a(effect.getId()), amplifier, duration, ambient,
                showParticles, showIcon);
        super.packet = new PacketPlayOutEntityEffect(p.getEntityId(), mobEffect);
    }

    public ExPacketPlayOutEntityEffect(PacketPlayOutEntityEffect packet) {
        super(packet);
    }

    @Override
    public String getInfo() {
        return "entity effect";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_EFFECT;
    }
}
