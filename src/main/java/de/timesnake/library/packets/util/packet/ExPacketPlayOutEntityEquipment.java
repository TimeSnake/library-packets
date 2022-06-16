package de.timesnake.library.packets.util.packet;

import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.entity.extension.ExEntity;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ExPacketPlayOutEntityEquipment extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEquipment wrap(Entity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEquipment(entity,
                equipment);
    }

    static ExPacketPlayOutEntityEquipment wrap(ExEntity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEquipment(entity,
                equipment);
    }
}
