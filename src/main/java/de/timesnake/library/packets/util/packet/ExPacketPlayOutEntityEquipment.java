/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.basic.util.Tuple;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ExPacketPlayOutEntityEquipment extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEquipment wrap(Entity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEquipment(entity,
                equipment);
    }
}
