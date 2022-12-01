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

package de.timesnake.library.packets.core.packet.in;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.reflection.Util;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;

public class ExPacketPlayInUseEntity extends ExPacketPlayIn implements de.timesnake.library.packets.util.packet.ExPacketPlayInUseEntity {

    public ExPacketPlayInUseEntity(PacketPlayInUseEntity packet) {
        this.packet = packet;
    }

    @Override
    public UseType getUseType() {
        Object type = Util.invokeMethod(Util.getInstanceField(this.packet, "b"), "a");
        if (Util.invokeMethod(type, "name").equals("INTERACT")) {
            return UseType.INTERACT;
        } else if (Util.invokeMethod(type, "name").equals("ATTACK")) {
            return UseType.ATTACK;
        } else if (Util.invokeMethod(type, "name").equals("INTERACT_AT")) {
            return UseType.INTERACT_AT;
        }
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return ExPacket.Type.PLAY_IN_USE_ENTITY;
    }
}
