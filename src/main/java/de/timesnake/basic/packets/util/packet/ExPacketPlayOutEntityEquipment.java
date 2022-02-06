package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.library.basic.util.Tuple;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ExPacketPlayOutEntityEquipment extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEquipment wrap(Entity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityEquipment(entity, equipment);
    }

    static ExPacketPlayOutEntityEquipment wrap(ExEntity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        return new de.timesnake.basic.packets.core.packet.out.ExPacketPlayOutEntityEquipment(entity, equipment);
    }
}
