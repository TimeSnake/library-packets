package de.timesnake.library.packets.core;


import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;

public class UnsupportedPacketException extends Exception {

    private final Packet<? extends PacketListener> packet;

    public UnsupportedPacketException(Packet<? extends PacketListener> packet) {
        this.packet = packet;
    }

    public Packet<? extends PacketListener> getPacket() {
        return packet;
    }

    @Override
    public String getMessage() {
        return "Packet " + this.packet.getClass().getSimpleName() + " is not supported";
    }
}
