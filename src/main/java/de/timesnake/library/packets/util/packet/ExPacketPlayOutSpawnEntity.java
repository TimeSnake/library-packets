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

package de.timesnake.library.packets.util.packet;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutSpawnEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntity wrap(Entity entity) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity);
    }

    static ExPacketPlayOutSpawnEntity wrap(Entity entity, int data) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, data);
    }

    static ExPacketPlayOutSpawnEntity wrap(Entity entity, ItemFrameRotation rotation) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, rotation);
    }

    static ItemFrameRotation blockFaceToRotation(BlockFace face) {
        return switch (face) {
            case DOWN -> ItemFrameRotation.DOWN;
            case UP -> ItemFrameRotation.UP;
            case NORTH -> ItemFrameRotation.NORTH;
            case SOUTH -> ItemFrameRotation.SOUTH;
            case WEST -> ItemFrameRotation.WEST;
            case EAST -> ItemFrameRotation.EAST;
            default -> null;
        };
    }

    enum ItemFrameRotation {

        DOWN(0),
        UP(1),
        NORTH(2),
        SOUTH(3),
        WEST(4),
        EAST(5);

        private final int nms;

        ItemFrameRotation(int nms) {
            this.nms = nms;
        }

        public int getNms() {
            return nms;
        }
    }
}
