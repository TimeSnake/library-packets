/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class ExClientboundInitializeBorderPacket extends ExPacketPlayOut implements de.timesnake.library.packets.util.ExClientboundInitializeBorderPacket {

    public ExClientboundInitializeBorderPacket(ClientboundInitializeBorderPacket packet) {
        super(packet);
    }

    public ExClientboundInitializeBorderPacket(World world, double centerX, double centerZ, double startSize,
                                               double shrinkSize, long time, int warningDistance, int warningTime) {

        super(new ClientboundInitializeBorderPacket(new PacketWorldBorder(((CraftWorld) world).getHandle(), centerX,
                centerZ, startSize, shrinkSize, time, warningDistance, warningTime)));
    }

    @Override
    public String getInfo() {
        return "border init";
    }

    @Override
    public ExPacket.Type getType() {
        return ExPacket.Type.PLAY_OUT_WORLD_BORDER_INIT;
    }
}
