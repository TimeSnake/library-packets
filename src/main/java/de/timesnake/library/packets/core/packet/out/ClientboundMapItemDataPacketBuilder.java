/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_20_R1.map.CraftMapView;
import org.bukkit.map.MapView;

public class ClientboundMapItemDataPacketBuilder {

  public static ClientboundMapItemDataPacket of(MapView view, CraftPlayer player) {
    return new ClientboundMapItemDataPacket(view.getId(), view.getScale().getValue(), view.isLocked(),
        null, new MapItemSavedData.MapPatch(0, 0, 128, 128,
        ((CraftMapView) view).render(player).buffer));
  }
}
