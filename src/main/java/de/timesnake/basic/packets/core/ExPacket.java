package de.timesnake.basic.packets.core;

import net.minecraft.network.PacketListener;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.Packet;

import javax.annotation.Nonnull;

public abstract class ExPacket implements de.timesnake.basic.packets.util.packet.ExPacket {

    protected Packet<? extends PacketListener> packet;

    public ExPacket(Packet<? extends PacketListener> packet) {
        this.packet = packet;
    }

    public ExPacket() {

    }

    public @Nonnull
    Packet<? extends PacketListener> getPacket() {
        return packet;
    }

    public static Object invokeChatSerializer(String text) {
        return IChatBaseComponent.ChatSerializer.a(text);
    }

}
