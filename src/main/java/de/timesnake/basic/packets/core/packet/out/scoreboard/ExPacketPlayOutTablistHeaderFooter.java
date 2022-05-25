package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;

@NmsReflection
public class ExPacketPlayOutTablistHeaderFooter extends ExPacketPlayOutTablist implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablistHeaderFooter {

    private final String header;
    private final String footer;

    public ExPacketPlayOutTablistHeaderFooter(String header, String footer) {
        if (footer == null) {
            footer = "";
        }

        if (header == null) {
            header = "";
        }

        super.packet =
                new PacketPlayOutPlayerListHeaderFooter(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}"), IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}"));

        this.header = header;
        this.footer = footer;
    }

    public ExPacketPlayOutTablistHeaderFooter(PacketPlayOutPlayerListHeaderFooter packet) {
        super.packet = packet;
        if (packet.a != null) {
            this.header = packet.a.getString();
        } else {
            this.header = null;
        }
        if (packet.b != null) {
            this.footer = packet.b.getString();
        } else {
            this.footer = null;
        }
    }

    public static ExPacketPlayOut getPacket(PacketPlayOutPlayerListHeaderFooter packet) {
        return new ExPacketPlayOutTablistHeaderFooter(packet);
    }

    @Override
    public String getInfo() {
        return "header: " + this.header + " footer: " + this.footer;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_HEADER_FOOTER;
    }
}
