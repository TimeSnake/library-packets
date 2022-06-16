package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.network.protocol.game.PacketPlayOutOpenBook;

@NmsReflection
public class ExPacketPlayOutOpenBook extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutOpenBook {

    public static ExPacketPlayOutOpenBook getPacket(PacketPlayOutOpenBook packet) {
        return new ExPacketPlayOutOpenBook(packet);
    }

    public ExPacketPlayOutOpenBook(PacketPlayOutOpenBook packet) {
        super(packet);
    }

    public ExPacketPlayOutOpenBook(boolean mainHand) {
        super(new PacketPlayOutOpenBook(mainHand ? ExEnumHand.MAIN_HAND.getNMS() : ExEnumHand.OFF_HAND.getNMS()));
    }

    @Override
    public String getInfo() {
        return "open_book";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_OPEN_BOOK;
    }
}
