package de.timesnake.library.packets.core.packet.out.entity;

import com.mojang.datafixers.util.Pair;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemStack;

import java.util.LinkedList;
import java.util.List;

public class ClientboundSetEquipmentPacketBuilder {

  private final Entity entity;
  private final List<Pair<EquipmentSlot, ItemStack>> items = new LinkedList<>();

  public ClientboundSetEquipmentPacketBuilder(Entity entity) {
    this.entity = entity;
  }

  public ClientboundSetEquipmentPacket build() {
    return new ClientboundSetEquipmentPacket(entity.getId(), items);
  }

  public ClientboundSetEquipmentPacketBuilder addItem(EquipmentSlot equipmentSlot, ItemStack item) {
    this.items.add(new Pair<>(equipmentSlot, item));
    return this;
  }

  public ClientboundSetEquipmentPacketBuilder addItem(EquipmentSlot equipmentSlot, org.bukkit.inventory.ItemStack item) {
    this.items.add(new Pair<>(equipmentSlot, CraftItemStack.asNMSCopy(item)));
    return this;
  }
}
