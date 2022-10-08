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

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import de.timesnake.library.entities.entity.extension.ExEntity;
import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityMetadata extends ExPacketPlayOut {

    static ExPacketPlayOutEntityMetadata wrap(Player player, DataType type) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(player, type);
    }

    static ExPacketPlayOutEntityMetadata wrap(ExtendedCraftEntity<?> entity, DataType type) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(entity, type);
    }

    static ExPacketPlayOutEntityMetadata wrap(ExtendedCraftEntity<?> entity, DataType type, boolean flag) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(entity, type,
                flag);
    }

    static ExPacketPlayOutEntityMetadata wrap(ExEntity entity, DataType type) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(entity, type);
    }

    static ExPacketPlayOutEntityMetadata wrap(ExEntity entity, DataType type, boolean flag) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata(entity, type,
                flag);
    }

    Integer getNMSIndex();

    ExPacketPlayOutEntityMetadata cloneByte();

    ExPacketPlayOutEntityMetadata clonePose();

    Integer getEntityId();

    boolean setGlowing(boolean flag);

    boolean setFlyingWithElytra(boolean flag);

    boolean setPose(EntityPose pose);

    enum DataType {
        UPDATE
    }

    enum EntityPose {
        STANDING(net.minecraft.world.entity.EntityPose.a),
        FALL_FLYING(net.minecraft.world.entity.EntityPose.b),
        SLEEPING(net.minecraft.world.entity.EntityPose.c),
        SWIMMING(net.minecraft.world.entity.EntityPose.d),
        SPIN_ATTACK(net.minecraft.world.entity.EntityPose.e),
        CROUCHING(net.minecraft.world.entity.EntityPose.f),
        DYING(net.minecraft.world.entity.EntityPose.g);

        private final net.minecraft.world.entity.EntityPose pose;

        EntityPose(net.minecraft.world.entity.EntityPose pose) {
            this.pose = pose;
        }

        public net.minecraft.world.entity.EntityPose getPose() {
            return pose;
        }
    }
}
