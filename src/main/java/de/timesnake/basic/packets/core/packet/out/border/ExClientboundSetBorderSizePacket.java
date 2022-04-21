package de.timesnake.basic.packets.core.packet.out.border;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

public class ExClientboundSetBorderSizePacket extends ExPacketPlayOut implements de.timesnake.basic.packets.util.ExClientboundSetBorderSizePacket {

    public ExClientboundSetBorderSizePacket(ClientboundSetBorderSizePacket packet) {
        super(packet);
    }

    public ExClientboundSetBorderSizePacket(World world, double size) {
        super(new ClientboundSetBorderSizePacket(PacketWorldBorder.size(((CraftWorld) world).getHandle(), size)));
    }

    @Override
    public String getInfo() {
        return "border size";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_WORLD_BORDER_SIZE;
    }
}
