package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;

public abstract class ExPacketPlayOutTablist extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablist {

    public ExPacketPlayOutTablist(Packet<? extends PacketListener> packet) {
        super(packet);
    }

    public ExPacketPlayOutTablist() {

    }
}
