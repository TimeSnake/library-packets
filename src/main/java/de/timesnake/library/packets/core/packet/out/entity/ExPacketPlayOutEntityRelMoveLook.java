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
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import org.bukkit.entity.LivingEntity;

@NmsReflection
public class ExPacketPlayOutEntityRelMoveLook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityRelMoveLook {

    public ExPacketPlayOutEntityRelMoveLook(LivingEntity entity, double deltaX, double deltaY, double deltaZ,
                                            float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook(entity.getEntityId(),
                (short) (deltaX * 32 * 128), (short) (deltaY * 32 * 128), (short) (deltaZ * 32 * 128),
                (byte) (yaw * 256 / 360), (byte) (pitch * 256 / 360), onGround));
    }

    public ExPacketPlayOutEntityRelMoveLook(ExEntityLiving entity, double deltaX, double deltaY, double deltaZ,
                                            float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook(entity.getId(), (short) (deltaX * 32 * 128),
                (short) (deltaY * 32 * 128), (short) (deltaZ * 32 * 128), (byte) (yaw * 256 / 360),
                (byte) (pitch * 256 / 360), onGround));
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_REL_MOVE_LOOK;
    }
}
