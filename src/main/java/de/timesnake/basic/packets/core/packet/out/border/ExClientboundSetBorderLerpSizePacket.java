package de.timesnake.basic.packets.core.packet.out.border;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

public class ExClientboundSetBorderLerpSizePacket extends ExPacketPlayOut implements de.timesnake.basic.packets.util.ExClientboundSetBorderLerpSizePacket {

    public ExClientboundSetBorderLerpSizePacket(ClientboundSetBorderLerpSizePacket packet) {
        super(packet);
    }

    public ExClientboundSetBorderLerpSizePacket(World world, double newSize, double oldSize, long time) {
        super(new ClientboundSetBorderLerpSizePacket(PacketWorldBorder.lerp(((CraftWorld) world).getHandle(), newSize, oldSize, time)));
    }

    @Override
    public String getInfo() {
        return "border lerp size";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_WORLD_BORDER_LERP_SIZE;
    }
}
