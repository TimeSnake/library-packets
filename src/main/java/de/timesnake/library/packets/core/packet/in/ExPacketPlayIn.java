/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.in;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.packets.core.UnsupportedPacketException;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInArmAnimation;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;

public abstract class ExPacketPlayIn extends ExPacket implements de.timesnake.library.packets.util.packet.ExPacketPlayIn {

    public static ExPacketPlayIn getPacket(Packet<? extends PacketListener> packet) throws UnsupportedPacketException {
        if (packet instanceof PacketPlayInUseEntity) {
            return new ExPacketPlayInUseEntity(((PacketPlayInUseEntity) packet));
        } else if (packet instanceof PacketPlayInArmAnimation) {
            return new ExPacketPlayInArmAnimation((PacketPlayInArmAnimation) packet);
        }
        throw new UnsupportedPacketException(packet);
    }

    public ExPacketPlayIn() {

    }

    public ExPacketPlayIn(Packet<?> packet) {
        super(packet);
    }

}
