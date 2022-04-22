package de.timesnake.basic.packets.core.packet.out;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.chat.ChatMessageType;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutChat;

@NmsReflection
public class ExPacketPlayOutChat extends ExPacketPlayOut {

    private final Slot slot;
    private final String text;

    public ExPacketPlayOutChat(Slot slot, String text) {
        this.slot = slot;
        this.text = text;

        ChatMessageType type = null;

        switch (slot) {
            case GAME_INFO:
                type = ChatMessageType.a;
                break;
            case CHAT:
                type = ChatMessageType.b;
                break;
            case SYSTEM:
                type = ChatMessageType.c;
                break;

        }


        // TODO 1.18 check uuid
        this.packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\",\"color\":\"white\"}"), type, null);

    }

    public enum Slot {
        CHAT, GAME_INFO, SYSTEM
    }

    @Override
    public String getInfo() {
        return slot.name() + " " + text;
    }

    @Override
    public Type getType() {
        return null;
    }
}
