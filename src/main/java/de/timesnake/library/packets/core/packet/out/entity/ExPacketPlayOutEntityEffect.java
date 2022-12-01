/*
 * workspace.library-packets.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
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
