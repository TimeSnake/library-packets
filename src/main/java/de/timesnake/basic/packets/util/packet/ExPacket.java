package de.timesnake.basic.packets.util.packet;

import java.util.Arrays;
import java.util.Collection;

public interface ExPacket {

    String getInfo();

    Type getType();

    boolean equals(Object obj);

    enum Type {

        // tablist player
        PLAY_OUT_TABLIST_PLAYER_ADD, PLAY_OUT_TABLIST_PLAYER_REMOVE, PLAY_OUT_TABLIST_PLAYER(PLAY_OUT_TABLIST_PLAYER_ADD, PLAY_OUT_TABLIST_PLAYER_REMOVE),

        // tablist team
        PLAY_OUT_TABLIST_TEAM_CREATION, PLAY_OUT_TABLIST_TEAM_UPDATE, PLAY_OUT_TABLIST_TEAM_PLAYER_ADD, PLAY_OUT_TABLIST_TEAM_PLAYER_REMOVE, PLAY_OUT_TABLIST_TEAM_REMOVE, PLAY_OUT_TABLIST_TEAM(PLAY_OUT_TABLIST_TEAM_CREATION, PLAY_OUT_TABLIST_TEAM_UPDATE, PLAY_OUT_TABLIST_TEAM_PLAYER_ADD, PLAY_OUT_TABLIST_TEAM_PLAYER_REMOVE, PLAY_OUT_TABLIST_TEAM_REMOVE),

        // tablist header footer
        PLAY_OUT_TABLIST_HEADER_FOOTER,

        // tablist
        PLAY_OUT_TABLIST(PLAY_OUT_TABLIST_PLAYER, PLAY_OUT_TABLIST_TEAM, PLAY_OUT_TABLIST_HEADER_FOOTER),

        PLAY_OUT_SIDEBOARD_SCORE_SET, PLAY_OUT_SIDEBOARD_SCORE_REMOVE,

        PLAY_OUT_SIDEBOARD(PLAY_OUT_SIDEBOARD_SCORE_REMOVE, PLAY_OUT_SIDEBOARD_SCORE_SET),

        // border
        PLAY_OUT_WORLD_BORDER_INIT, PLAY_OUT_WORLD_BORDER_LERP_SIZE, PLAY_OUT_WORLD_BORDER_CENTER, PLAY_OUT_WORLD_BORDER_SIZE,

        PLAY_OUT_WORLD_BORDER(PLAY_OUT_WORLD_BORDER_INIT, PLAY_OUT_WORLD_BORDER_LERP_SIZE, PLAY_OUT_WORLD_BORDER_CENTER, PLAY_OUT_WORLD_BORDER_SIZE),

        // chat
        PLAY_OUT_CHAT, PLAY_OUT_OPEN_BOOK,

        // entity
        PLAY_OUT_SPAWN_ENTITY_LIVING, PLAY_OUT_DESTROY_ENTITY, PLAY_OUT_SPAWN_NAMED_ENTITY, PLAY_OUT_ENTITY_EFFECT, PLAY_OUT_ENTITY_EFFECT_REMOVE, PLAY_OUT_ENTITY_METADATA, PLAY_OUT_ENTITY_EQUIPMENT, PLAY_OUT_ENTITY_HEAD_ROTATION, PLAY_OUT_ENTITY_LOOK,

        // scoreboard objectives
        PLAY_OUT_SCOREBOARD_OBJ, PLAY_OUT_SCOREBOARD_DISPLAY_OBJ,

        // play out
        PLAY_OUT(PLAY_OUT_TABLIST, PLAY_OUT_SIDEBOARD, PLAY_OUT_CHAT, PLAY_OUT_SPAWN_ENTITY_LIVING, PLAY_OUT_DESTROY_ENTITY, PLAY_OUT_SPAWN_NAMED_ENTITY, PLAY_OUT_ENTITY_EFFECT, PLAY_OUT_ENTITY_EFFECT_REMOVE, PLAY_OUT_ENTITY_METADATA, PLAY_OUT_ENTITY_EQUIPMENT, PLAY_OUT_ENTITY_HEAD_ROTATION, PLAY_OUT_ENTITY_LOOK, PLAY_OUT_WORLD_BORDER, PLAY_OUT_SCOREBOARD_OBJ, PLAY_OUT_SCOREBOARD_DISPLAY_OBJ, PLAY_OUT_OPEN_BOOK),



        PLAY_IN_USE_ENTITY, PLAY_IN_ARM_ANIMATION,

        PLAY_IN(PLAY_IN_USE_ENTITY, PLAY_IN_ARM_ANIMATION);

        private final Collection<Type> subTypes;

        Type(Type... subTypes) {
            this.subTypes = Arrays.asList(subTypes.clone());
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
