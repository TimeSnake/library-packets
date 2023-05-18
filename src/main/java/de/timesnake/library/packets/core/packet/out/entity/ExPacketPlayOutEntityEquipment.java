/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import com.mojang.datafixers.util.Pair;
import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.wrapper.ExEnumItemSlot;
import de.timesnake.library.packets.core.BukkitNmsParser;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.world.entity.EnumItemSlot;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ExPacketPlayOutEntityEquipment extends ExPacketPlayOut implements
    de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityEquipment {

  public static ExPacketPlayOut getPacket(PacketPlayOutEntityEquipment packet) {
    return new ExPacketPlayOutEntityEquipment(packet);
  }

  protected ExPacketPlayOutEntityEquipment(PacketPlayOutEntityEquipment packet) {
    super(packet);
  }

  public ExPacketPlayOutEntityEquipment(Entity entity,
      List<Tuple<EquipmentSlot, ItemStack>> equipment) {
    List<Pair<EnumItemSlot, net.minecraft.world.item.ItemStack>> nmsEquip = new ArrayList<>();
    for (Tuple<EquipmentSlot, ItemStack> slotItem : equipment) {
      nmsEquip.add(new Pair<>(ExEnumItemSlot.parseEquipmentSlot(slotItem.getA()).getNmsSlot(),
          BukkitNmsParser.parseItem(slotItem.getB())));
    }

    super.packet = new PacketPlayOutEntityEquipment(entity.getEntityId(), nmsEquip);
  }

  @Override
  public String getInfo() {
    return "Entity Equipment";
  }

  @Override
  public Type getType() {
    return Type.PLAY_OUT_ENTITY_EQUIPMENT;
  }


}
