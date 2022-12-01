/*
 * workspace.library-packets.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.packets.core.packet.out.entity;

import com.mojang.datafixers.util.Pair;
import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.wrapper.ExEnumItemSlot;
import de.timesnake.library.packets.core.BukkitNmsParser;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.world.entity.EnumItemSlot;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ExPacketPlayOutEntityEquipment extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityEquipment {

    public static ExPacketPlayOut getPacket(PacketPlayOutEntityEquipment packet) {
        return new ExPacketPlayOutEntityEquipment(packet);
    }

    protected ExPacketPlayOutEntityEquipment(PacketPlayOutEntityEquipment packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityEquipment(Entity entity, List<Tuple<EquipmentSlot, ItemStack>> equipment) {
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
