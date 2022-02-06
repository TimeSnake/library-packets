package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.UnsupportedPacketException;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.basic.util.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.EnumChatFormat;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import org.bukkit.ChatColor;

import java.util.Collection;
import java.util.Optional;

public abstract class ExPacketPlayOutTablistTeam extends ExPacketPlayOutTablist implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablistTeam {

    protected final String name;

    public ExPacketPlayOutTablistTeam(Packet<? extends PacketListener> packet, String name) {
        super(packet);
        this.name = name;
    }

    public ExPacketPlayOutTablistTeam(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    public static ExPacketPlayOut getPacket(PacketPlayOutScoreboardTeam packet) throws UnsupportedPacketException {
        @NmsReflection String name = (String) RefUtil.getInstanceField(packet, "i");
        @NmsReflection int type = (int) RefUtil.getInstanceField(packet, "h");

        if (type == 0) {
            @NmsReflection String prefix = ((Optional<PacketPlayOutScoreboardTeam.b>) RefUtil.getInstanceField(packet, "k")).get().f().getString();
            return new ExPacketPlayOutTablistTeamCreation(packet, name, prefix);
        } else if (type == 1) {
            return new ExPacketPlayOutTablistTeamRemove(name);
        } else if (type == 2) {
            @NmsReflection String prefix = ((Optional<PacketPlayOutScoreboardTeam.b>) RefUtil.getInstanceField(packet, "k")).get().f().getString();
            return new ExPacketPlayOutTablistTeamUpdate(name, prefix);
        } else if (type == 3) {
            @NmsReflection Collection<String> entries = (Collection<String>) RefUtil.getInstanceField(packet, "j");
            return new ExPacketPlayOutTablistTeamPlayerAdd(name, entries.iterator().next());
        } else if (type == 4) {
            @NmsReflection Collection<String> entries = (Collection<String>) RefUtil.getInstanceField(packet, "j");
            return new ExPacketPlayOutTablistTeamPlayerRemove(name, entries.iterator().next());
        }
        throw new UnsupportedPacketException(packet);

    }

    static EnumChatFormat getEnumChatFormat(ChatColor chatColor) {
        if (chatColor == null) {
            chatColor = ChatColor.WHITE;
        }

        switch (chatColor) {
            case BLACK:
                return EnumChatFormat.a;
            case DARK_BLUE:
                return EnumChatFormat.b;
            case DARK_GREEN:
                return EnumChatFormat.c;
            case DARK_AQUA:
                return EnumChatFormat.d;
            case DARK_RED:
                return EnumChatFormat.e;
            case DARK_PURPLE:
                return EnumChatFormat.f;
            case GOLD:
                return EnumChatFormat.g;
            case GRAY:
                return EnumChatFormat.h;
            case DARK_GRAY:
                return EnumChatFormat.i;
            case BLUE:
                return EnumChatFormat.j;
            case GREEN:
                return EnumChatFormat.k;
            case AQUA:
                return EnumChatFormat.l;
            case RED:
                return EnumChatFormat.m;
            case LIGHT_PURPLE:
                return EnumChatFormat.n;
            case YELLOW:
                return EnumChatFormat.o;
            case WHITE:
                return EnumChatFormat.p;
            case MAGIC:
                return EnumChatFormat.q;
            case BOLD:
                return EnumChatFormat.r;
            case STRIKETHROUGH:
                return EnumChatFormat.s;
            case UNDERLINE:
                return EnumChatFormat.t;
            case ITALIC:
                return EnumChatFormat.u;
            case RESET:
                return EnumChatFormat.v;
        }
        return null;
    }
}
