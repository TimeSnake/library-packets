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

import net.minecraft.network.protocol.Packet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ExPacket {

    Map<Class<? extends Packet<?>>, Class<? extends ExPacket>> EX_PACKET_CLASS_BY_PACKET_CLASS =
            new ConcurrentHashMap<>();

    String getInfo();

    Type getType();

    boolean equals(Object obj);

    enum Type {

        // tablist player
        PLAY_OUT_TABLIST_PLAYER_ADD,
        PLAY_OUT_TABLIST_PLAYER_REMOVE,

        PLAY_OUT_TABLIST_PLAYER(PLAY_OUT_TABLIST_PLAYER_ADD, PLAY_OUT_TABLIST_PLAYER_REMOVE),

        // tablist team
        PLAY_OUT_TABLIST_TEAM_CREATION,
        PLAY_OUT_TABLIST_TEAM_UPDATE,
        PLAY_OUT_TABLIST_TEAM_PLAYER_ADD,
        PLAY_OUT_TABLIST_TEAM_PLAYER_REMOVE,
        PLAY_OUT_TABLIST_TEAM_REMOVE,

        PLAY_OUT_TABLIST_TEAM(PLAY_OUT_TABLIST_TEAM_CREATION, PLAY_OUT_TABLIST_TEAM_UPDATE,
                PLAY_OUT_TABLIST_TEAM_PLAYER_ADD, PLAY_OUT_TABLIST_TEAM_PLAYER_REMOVE, PLAY_OUT_TABLIST_TEAM_REMOVE),

        // tablist header footer
        PLAY_OUT_TABLIST_HEADER_FOOTER,

        // tablist
        PLAY_OUT_TABLIST(PLAY_OUT_TABLIST_PLAYER, PLAY_OUT_TABLIST_TEAM, PLAY_OUT_TABLIST_HEADER_FOOTER),

        PLAY_OUT_SIDEBOARD_SCORE_SET,
        PLAY_OUT_SIDEBOARD_SCORE_REMOVE,

        PLAY_OUT_SIDEBOARD(PLAY_OUT_SIDEBOARD_SCORE_REMOVE, PLAY_OUT_SIDEBOARD_SCORE_SET),

        // border
        PLAY_OUT_WORLD_BORDER_INIT,
        PLAY_OUT_WORLD_BORDER_LERP_SIZE,
        PLAY_OUT_WORLD_BORDER_CENTER,
        PLAY_OUT_WORLD_BORDER_SIZE,

        PLAY_OUT_WORLD_BORDER(PLAY_OUT_WORLD_BORDER_INIT, PLAY_OUT_WORLD_BORDER_LERP_SIZE,
                PLAY_OUT_WORLD_BORDER_CENTER, PLAY_OUT_WORLD_BORDER_SIZE),

        // chat
        PLAY_OUT_CHAT,
        PLAY_OUT_OPEN_BOOK,

        // entity
        PLAY_OUT_SPAWN_ENTITY_LIVING,
        PLAY_OUT_DESTROY_ENTITY,
        PLAY_OUT_SPAWN_NAMED_ENTITY,
        PLAY_OUT_ENTITY_EFFECT,
        PLAY_OUT_ENTITY_EFFECT_REMOVE,
        PLAY_OUT_ENTITY_METADATA,
        PLAY_OUT_ENTITY_EQUIPMENT,
        PLAY_OUT_ENTITY_HEAD_ROTATION,
        PLAY_OUT_ENTITY_LOOK,
        PLAY_OUT_ENTITY_TELEPORT,
        PLAY_OUT_ENTITY_REL_MOVE_LOOK,
        PLAY_OUT_ENTITY_SPAWN,

        PLAY_OUT_ENTITY(PLAY_OUT_SPAWN_ENTITY_LIVING, PLAY_OUT_DESTROY_ENTITY, PLAY_OUT_SPAWN_NAMED_ENTITY,
                PLAY_OUT_ENTITY_EFFECT, PLAY_OUT_ENTITY_EFFECT_REMOVE, PLAY_OUT_ENTITY_METADATA,
                PLAY_OUT_ENTITY_EQUIPMENT, PLAY_OUT_ENTITY_HEAD_ROTATION, PLAY_OUT_ENTITY_LOOK,
                PLAY_OUT_ENTITY_TELEPORT, PLAY_OUT_ENTITY_REL_MOVE_LOOK, PLAY_OUT_ENTITY_SPAWN),

        // scoreboard objectives
        PLAY_OUT_SCOREBOARD_OBJ,
        PLAY_OUT_SCOREBOARD_DISPLAY_OBJ,

        // map
        PLAY_OUT_MAP,

        // chunk
        PLAY_OUT_LEVEL_CHUNK_WITH_LIGHT_PACKET,
        PLAY_OUT_CHUNK_UNLOAD,

        // play out
        PLAY_OUT(PLAY_OUT_TABLIST, PLAY_OUT_SIDEBOARD, PLAY_OUT_CHAT, PLAY_OUT_WORLD_BORDER, PLAY_OUT_SCOREBOARD_OBJ,
                PLAY_OUT_SCOREBOARD_DISPLAY_OBJ, PLAY_OUT_OPEN_BOOK, PLAY_OUT_ENTITY, PLAY_OUT_MAP,
                PLAY_OUT_LEVEL_CHUNK_WITH_LIGHT_PACKET, PLAY_OUT_CHUNK_UNLOAD),


        PLAY_IN_USE_ENTITY,
        PLAY_IN_ARM_ANIMATION,

        PLAY_IN(PLAY_IN_USE_ENTITY, PLAY_IN_ARM_ANIMATION);

        private final Collection<Type> subTypes;

        private final Class<? extends ExPacket> exPacketClass;
        private final Class<? extends Packet<?>> packetClass;

        Type(Type... subTypes) {
            this.subTypes = Arrays.asList(subTypes.clone());
            this.exPacketClass = null;
            this.packetClass = null;
        }

        Type(Class<? extends ExPacket> exPacketClass, Class<? extends Packet<?>> packetClass, Type... subTypes) {
            this.subTypes = Arrays.asList(subTypes.clone());
            this.exPacketClass = exPacketClass;
            this.packetClass = packetClass;
        }

        Type(Class<? extends ExPacket> exPacketClass, Class<? extends Packet<?>> packetClass) {
            this.subTypes = new ArrayList<>();
            this.exPacketClass = exPacketClass;
            this.packetClass = packetClass;
        }

        public Class<? extends ExPacket> getExPacketClass() {
            return exPacketClass;
        }

        public Class<? extends Packet<?>> getPacketClass() {
            return packetClass;
        }

        public boolean isInstanceOf(Type type) {
            if (type.equals(this)) return true;
            for (Type sub : type.subTypes) {
                if (this.isInstanceOf(sub)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasSubTypes() {
            return !subTypes.isEmpty();
        }

        public Collection<Type> getSubTypes() {
            return subTypes;
        }

        public boolean containsSubType(Type type) {
            if (this.equals(type)) return true;
            if (this.subTypes.contains(type)) return true;
            for (Type sub : this.subTypes) {
                if (sub.containsSubType(type)) return true;
            }
            return false;
        }
    }
}
