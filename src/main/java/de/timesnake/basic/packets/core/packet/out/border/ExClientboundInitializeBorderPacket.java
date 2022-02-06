package de.timesnake.basic.packets.core.packet.out.border;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;

public class ExClientboundInitializeBorderPacket extends ExPacketPlayOut implements de.timesnake.basic.packets.util.ExClientboundInitializeBorderPacket {

    public ExClientboundInitializeBorderPacket(ClientboundInitializeBorderPacket packet) {
        super(packet);
    }

    public ExClientboundInitializeBorderPacket(World world, double centerX, double centerZ, double startSize, double shrinkSize, long time, int warningDistance, int warningTime) {

        super(new ClientboundInitializeBorderPacket(new PacketWorldBorder(((CraftWorld) world).getHandle(), centerX, centerZ, startSize, shrinkSize, time, warningDistance, warningTime)));
    }

    @Override
    public String getInfo() {
        return "border init";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_WORLD_BORDER_INIT;
    }
}
