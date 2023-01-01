/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.Util;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.network.syncher.DataWatcherObject;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ExPacketPlayOutEntityMetadata extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutEntityMetadata {

    public static ExPacketPlayOutEntityMetadata getPacket(PacketPlayOutEntityMetadata packet) {
        return new ExPacketPlayOutEntityMetadata(packet);
    }

    public ExPacketPlayOutEntityMetadata(PacketPlayOutEntityMetadata packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityMetadata(Player player, DataType type) {
        if (type == DataType.UPDATE) {
            super.packet = new PacketPlayOutEntityMetadata(player.getEntityId(),
                    new ExPlayer(player).getDataWatcher(), true);
        }
    }

    public ExPacketPlayOutEntityMetadata(Entity entity, DataType type) {
        if (type == DataType.UPDATE) {
            super.packet = new PacketPlayOutEntityMetadata(entity.getEntityId(), new ExEntity(((CraftEntity) entity)).getDataWatcher(), true);
        }
    }

    public ExPacketPlayOutEntityMetadata(Entity entity, DataType type, boolean flag) {
        if (type == DataType.UPDATE) {
            super.packet = new PacketPlayOutEntityMetadata(entity.getEntityId(), new ExEntity(((CraftEntity) entity)).getDataWatcher(), flag);
        }
    }

    public Integer getNMSIndex() {
        if (super.getPacket() != null) {
            List<DataWatcher.Item<?>> packetB = this.getFieldB();
            if (packetB.isEmpty()) {
                return null;
            }
            DataWatcher.Item<?> item = packetB.get(0);
            DataWatcherObject<?> itemA = item.a();
            return itemA.a();
        }
        return null;
    }

    /**
     * This clone method supports only the {@link DataWatcher.Item} with a {@link Byte} generic.
     *
     * @return the cloned {@link ExPacketPlayOutEntityMetadata}
     */
    public ExPacketPlayOutEntityMetadata cloneByte() {
        int entityId = (int) Util.getInstanceField(packet, "a");
        List<DataWatcher.Item<?>> itemList = new ArrayList<>();

        for (DataWatcher.Item<?> item : this.getFieldB()) {
            Object itemB = item.b();
            if (itemB instanceof Byte) {
                DataWatcherObject<Byte> itemA = (DataWatcherObject<Byte>) item.a();
                int index = itemA.a();
                Byte clonedByte = Byte.parseByte(String.valueOf(item.b()));

                DataWatcherObject<Byte> clonedItemA = new DataWatcherObject<>(index, itemA.b());
                itemList.add(new DataWatcher.Item<>(clonedItemA, clonedByte));
            } else if (itemB instanceof Integer) {

            }
        }

        PacketPlayOutEntityMetadata clonedPacket = new PacketPlayOutEntityMetadata(entityId, new DataWatcher(null),
                true);
        Util.setInstanceField(clonedPacket, "b", itemList);
        return new ExPacketPlayOutEntityMetadata(clonedPacket);
    }

    /**
     * This clone method supports only the {@link DataWatcher.Item} with a {@link Byte} generic.
     *
     * @return the cloned {@link ExPacketPlayOutEntityMetadata}
     */
    public ExPacketPlayOutEntityMetadata clonePose() {
        int entityId = (int) Util.getInstanceField(packet, "a");
        List<DataWatcher.Item<?>> itemList = new ArrayList<>();

        for (DataWatcher.Item<?> item : this.getFieldB()) {
            Object itemB = item.b();
            if (itemB instanceof EntityPose) {
                DataWatcherObject<EntityPose> itemA = (DataWatcherObject<EntityPose>) item.a();
                int index = itemA.a();
                EntityPose clonedPose = (EntityPose) item.b();

                DataWatcherObject<EntityPose> clonedItemA = new DataWatcherObject<>(index, itemA.b());
                itemList.add(new DataWatcher.Item<>(clonedItemA, clonedPose));
            } else if (itemB instanceof Integer) {

            }
        }

        PacketPlayOutEntityMetadata clonedPacket = new PacketPlayOutEntityMetadata(entityId, new DataWatcher(null),
                true);
        Util.setInstanceField(clonedPacket, "a", entityId);
        Util.setInstanceField(clonedPacket, "b", itemList);
        return new ExPacketPlayOutEntityMetadata(clonedPacket);
    }

    public Integer getEntityId() {
        return (Integer) Util.getInstanceField(packet, "a");
    }

    public boolean setGlowing(boolean flag) {
        List<DataWatcher.Item<?>> packetB = this.getFieldB();
        if (packetB.isEmpty()) {
            return false;
        }
        DataWatcher.Item<?> item = packetB.get(0);
        DataWatcherObject<?> itemA = item.a();
        if (itemA.a() == MetadataIndex.BASE.getIndex() && item.b() instanceof Byte) {
            Byte itemB = (Byte) Util.getInstanceField(item, "b");
            if (flag) {
                Util.setInstanceField(item, "b", ((byte) (itemB | 0x40)));
            } else {
                Util.setInstanceField(item, "b", ((byte) (itemB & ~0x40)));
            }
            return true;
        }
        return false;
    }

    public boolean setFlyingWithElytra(boolean flag) {
        List<DataWatcher.Item<?>> packetB = this.getFieldB();
        if (packetB.isEmpty()) {
            return false;
        }
        DataWatcher.Item<?> item = packetB.get(0);
        DataWatcherObject<?> itemA = item.a();
        if (itemA.a() == MetadataIndex.BASE.getIndex() && item.b() instanceof Byte) {
            Byte itemB = (Byte) Util.getInstanceField(item, "b");
            if ((itemB & 0x80) != 0x80 && flag) {
                Util.setInstanceField(item, "b", ((byte) (itemB | 0x80)));
                return true;
            } else {
                Util.setInstanceField(item, "b", ((byte) (itemB & ~0x80)));
                return !flag;
            }
        }
        return false;
    }

    public boolean setPose(EntityPose pose) {
        List<DataWatcher.Item<?>> packetB = this.getFieldB();
        if (packetB.isEmpty()) {
            return false;
        }
        DataWatcher.Item<?> item = packetB.get(0);
        DataWatcherObject<?> itemA = item.a();
        if (itemA.a() == MetadataIndex.POSE.getIndex() && item.b() instanceof EntityPose) {
            Util.setInstanceField(item, "b", pose.getPose());
            return true;
        }
        return false;
    }

    private List<DataWatcher.Item<?>> getFieldB() {
        return (List<DataWatcher.Item<?>>) Util.getInstanceField(super.packet, "b");
    }

    @Override
    public String getInfo() {
        return "entity metadata";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_METADATA;
    }

    private enum MetadataIndex {
        BASE(0),
        POSE(18);

        private final int index;

        MetadataIndex(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
