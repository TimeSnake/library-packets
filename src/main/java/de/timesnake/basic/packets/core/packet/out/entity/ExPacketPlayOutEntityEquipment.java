package de.timesnake.basic.packets.core.packet.out.entity;

import com.mojang.datafixers.util.Pair;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.packets.core.BukkitNmsParser;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.world.entity.EnumItemSlot;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@NmsReflection
public class ExPacketPlayOutEntityEquipment extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityEquipment {

    protected ExPacketPlayOutEntityEquipment(PacketPlayOutEntityEquipment packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityEquipment(net.minecraft.world.entity.Entity entity, List<Tuple<EquipmentSlot,
            ItemStack>> equipment) {
        List<Pair<EnumItemSlot, net.minecraft.world.item.ItemStack>> nmsEquip = new ArrayList<>();
        for (Tuple<EquipmentSlot, ItemStack> slotItem : equipment) {
            nmsEquip.add(new Pair<>(ExEnumItemSlot.parseEquipmentSlot(slotItem.getA()).getNmsSlot(),
                    BukkitNmsParser.parseItem(slotItem.getB())));
        }

        super.packet = new PacketPlayOutEntityEquipment(entity.getBukkitEntity().getEntityId(), nmsEquip);
    }


    public ExPacketPlayOutEntityEquipment(Entity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        List<Pair<EnumItemSlot, net.minecraft.world.item.ItemStack>> nmsEquip = new ArrayList<>();
        for (Tuple<EquipmentSlot, ItemStack> slotItem : equipment) {
            nmsEquip.add(new Pair<>(ExEnumItemSlot.parseEquipmentSlot(slotItem.getA()).getNmsSlot(),
                    BukkitNmsParser.parseItem(slotItem.getB())));
        }

        super.packet = new PacketPlayOutEntityEquipment(entity.getEntityId(), nmsEquip);
    }

    public ExPacketPlayOutEntityEquipment(ExEntity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
        List<Pair<EnumItemSlot, net.minecraft.world.item.ItemStack>> nmsEquip = new ArrayList<>();
        for (Tuple<EquipmentSlot, ItemStack> slotItem : equipment) {
            nmsEquip.add(new Pair<>(ExEnumItemSlot.parseEquipmentSlot(slotItem.getA()).getNmsSlot(),
                    BukkitNmsParser.parseItem(slotItem.getB())));
        }

        super.packet = new PacketPlayOutEntityEquipment(entity.getBukkitEntity().getEntityId(), nmsEquip);
    }

    public static ExPacketPlayOut getPacket(PacketPlayOutEntityEquipment packet) {
        return new ExPacketPlayOutEntityEquipment(packet);
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
