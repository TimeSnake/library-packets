/*
 * library-packets.main
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
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutRemoveEntityEffect;
import net.minecraft.world.effect.MobEffectList;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutEntityEffectRemove extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityEffectRemove {

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
