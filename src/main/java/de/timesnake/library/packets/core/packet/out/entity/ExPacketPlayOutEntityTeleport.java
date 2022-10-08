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

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutEntityTeleport extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityTeleport {

    public ExPacketPlayOutEntityTeleport(Player player) {
        super(new PacketPlayOutEntityTeleport(((CraftPlayer) player).getHandle()));
    }

    public ExPacketPlayOutEntityTeleport(LivingEntity entity) {
        super(new PacketPlayOutEntityTeleport(((CraftLivingEntity) entity).getHandle()));
    }

    public ExPacketPlayOutEntityTeleport(ExEntityLiving entity) {
        super(new PacketPlayOutEntityTeleport(entity.getNMS()));
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_TELEPORT;
    }
}
