/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayInUseEntity extends ExPacketPlayIn {

    UseType getUseType();

    enum UseType {
        INTERACT,
        ATTACK,
        INTERACT_AT
    }
}
