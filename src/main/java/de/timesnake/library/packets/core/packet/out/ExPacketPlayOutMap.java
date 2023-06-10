/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import net.minecraft.network.protocol.game.PacketPlayOutMap;
import net.minecraft.world.level.saveddata.maps.WorldMap;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R1.map.CraftMapView;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;

public class ExPacketPlayOutMap extends ExPacketPlayOut {

	public ExPacketPlayOutMap(PacketPlayOutMap packet) {
		super(packet);
	}

	public ExPacketPlayOutMap(int id, byte scale, boolean locked, byte[] colors) {
		super(new PacketPlayOutMap(id, scale, locked, null, new WorldMap.b(0, 0, 128, 128, colors)));
	}

	public ExPacketPlayOutMap(int id, byte scale, boolean locked, MapView view, Player player) {
		super(new PacketPlayOutMap(id, scale, locked, null, new WorldMap.b(0, 0, 128, 128,
				((CraftMapView) view).render(((CraftPlayer) player)).buffer)));
	}

	@Override
	public String getInfo() {
		return null;
	}

	@Override
	public Type getType() {
		return null;
	}
}
