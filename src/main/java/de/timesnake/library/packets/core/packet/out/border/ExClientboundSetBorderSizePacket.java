/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class ExClientboundSetBorderSizePacket extends ExPacketPlayOut implements
		de.timesnake.library.packets.util.ExClientboundSetBorderSizePacket {

	public ExClientboundSetBorderSizePacket(ClientboundSetBorderSizePacket packet) {
		super(packet);
	}

	public ExClientboundSetBorderSizePacket(World world, double size) {
		super(new ClientboundSetBorderSizePacket(
				PacketWorldBorder.size(((CraftWorld) world).getHandle(), size)));
	}

	@Override
	public String getInfo() {
		return "border size";
	}

	@Override
	public ExPacket.Type getType() {
		return ExPacket.Type.PLAY_OUT_WORLD_BORDER_SIZE;
	}
}
