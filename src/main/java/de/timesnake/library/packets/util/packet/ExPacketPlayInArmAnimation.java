/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.wrapper.ExEnumHand;

public interface ExPacketPlayInArmAnimation extends ExPacketPlayIn {
    ExEnumHand getHand();
}
