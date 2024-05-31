/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out;


import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.map.CraftMapView;
import org.bukkit.map.MapView;

public class ClientboundMapItemDataPacketBuilder {

  public static ClientboundMapItemDataPacket of(MapView view, CraftPlayer player) {
    return new ClientboundMapItemDataPacket(new MapId(view.getId()), view.getScale().getValue(), view.isLocked(),
        null, new MapItemSavedData.MapPatch(0, 0, 128, 128,
        ((CraftMapView) view).render(player).buffer));
  }
}
