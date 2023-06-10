/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.packets.util.packet.ExPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class ExClientboundSetBorderCenterPacket extends ExPacketPlayOut implements
		de.timesnake.library.packets.util.ExClientboundSetBorderCenterPacket {

	public ExClientboundSetBorderCenterPacket(ClientboundSetBorderCenterPacket packet) {
		super(packet);
	}

	public ExClientboundSetBorderCenterPacket(World world, double centerX, double centerZ) {
		super(new ClientboundSetBorderCenterPacket(
				PacketWorldBorder.center(((CraftWorld) world).getHandle(), centerX
						, centerZ)));
	}

	@Override
	public String getInfo() {
		return "border center";
	}

	@Override
	public ExPacket.Type getType() {
		return ExPacket.Type.PLAY_OUT_WORLD_BORDER_CENTER;
	}
}
