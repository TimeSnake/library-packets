/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.basic.util.Tuple;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public interface ExPacketPlayOutEntityEquipment extends ExPacketPlayOut {

  static ExPacketPlayOutEntityEquipment wrap(Entity entity,
      List<Tuple<EquipmentSlot, ItemStack>> equipment) {
    return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEquipment(
        entity,
        equipment);
  }
}
