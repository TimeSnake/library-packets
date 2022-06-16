package de.timesnake.library.packets.util.packet;

import net.minecraft.network.protocol.Packet;

import javax.annotation.Nonnull;

public interface ExPacketPlayOut extends ExPacket {

    @Nonnull
    Packet<?> getPacket();

}
