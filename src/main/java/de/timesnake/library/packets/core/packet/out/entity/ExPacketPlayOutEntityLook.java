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
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import org.bukkit.entity.Entity;

public class ExPacketPlayOutEntityLook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityLook {

    public static ExPacketPlayOutEntityLook getPacket(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        return new ExPacketPlayOutEntityLook(packet);
    }

    public ExPacketPlayOutEntityLook(PacketPlayOutEntity.PacketPlayOutEntityLook packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityLook(Entity entity, float yaw, float pitch, boolean onGround) {
        super(new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getEntityId(), (byte) (yaw * 256 / 360),
                (byte) (pitch * 256 / 360), onGround));
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_LOOK;
    }
}
