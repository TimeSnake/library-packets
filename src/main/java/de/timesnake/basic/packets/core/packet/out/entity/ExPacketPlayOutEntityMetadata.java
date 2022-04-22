package de.timesnake.basic.packets.core.packet.out.entity;

import de.timesnake.basic.entities.entity.bukkit.ExPlayer;
import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.network.syncher.DataWatcherObject;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@NmsReflection
public class ExPacketPlayOutEntityMetadata extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutEntityMetadata {

    public static ExPacketPlayOutEntityMetadata getPacket(PacketPlayOutEntityMetadata packet) {
        return new ExPacketPlayOutEntityMetadata(packet);
    }

    public ExPacketPlayOutEntityMetadata(PacketPlayOutEntityMetadata packet) {
        super(packet);
    }

    public ExPacketPlayOutEntityMetadata(Player player, DataType type) {
        switch (type) {
            case UPDATE:
                super.packet = new PacketPlayOutEntityMetadata(player.getEntityId(), new ExPlayer(player).getDataWatcher(), true);
                break;
        }
    }

    public ExPacketPlayOutEntityMetadata(EntityExtension<?> entity, DataType type) {
        this(entity.getExtension(), type);
    }

    public ExPacketPlayOutEntityMetadata(ExEntity entity, DataType type) {
        switch (type) {
            case UPDATE:
                super.packet = new PacketPlayOutEntityMetadata(entity.getId(), entity.getDataWatcher(), true);
                break;
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
        int entityId = (int) RefUtil.getInstanceField(packet, "a");
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

        PacketPlayOutEntityMetadata clonedPacket = new PacketPlayOutEntityMetadata(entityId, new DataWatcher(null), true);
        RefUtil.setInstanceField(clonedPacket, "b", itemList);
        return new ExPacketPlayOutEntityMetadata(clonedPacket);
    }

    /**
     * This clone method supports only the {@link DataWatcher.Item} with a {@link Byte} generic.
     *
     * @return the cloned {@link ExPacketPlayOutEntityMetadata}
     */
    public ExPacketPlayOutEntityMetadata clonePose() {
        int entityId = (int) RefUtil.getInstanceField(packet, "a");
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

        PacketPlayOutEntityMetadata clonedPacket = new PacketPlayOutEntityMetadata(entityId, new DataWatcher(null), true);
        RefUtil.setInstanceField(clonedPacket, "a", entityId);
        RefUtil.setInstanceField(clonedPacket, "b", itemList);
        return new ExPacketPlayOutEntityMetadata(clonedPacket);
    }

    public Integer getEntityId() {
        return (Integer) RefUtil.getInstanceField(packet, "a");
    }

    public boolean setGlowing(boolean flag) {
        List<DataWatcher.Item<?>> packetB = this.getFieldB();
        if (packetB.isEmpty()) {
            return false;
        }
        DataWatcher.Item<?> item = packetB.get(0);
        DataWatcherObject<?> itemA = item.a();
        if (itemA.a() == 0 && item.b() instanceof Byte) {
            Byte itemB = (Byte) RefUtil.getInstanceField(item, "b");
            if (flag) {
                RefUtil.setInstanceField(item, "b", ((byte) (itemB | 0x40)));
            } else {
                RefUtil.setInstanceField(item, "b", ((byte) (itemB & ~0x40)));
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
        if (itemA.a() == 0 && item.b() instanceof Byte) {
            Byte itemB = (Byte) RefUtil.getInstanceField(item, "b");
            if ((itemB & 0x80) != 0x80 && flag) {
                RefUtil.setInstanceField(item, "b", ((byte) (itemB | 0x80)));
                return true;
            } else {
                RefUtil.setInstanceField(item, "b", ((byte) (itemB & ~0x80)));
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
        if (itemA.a() == 0 && item.b() instanceof EntityPose) {
            RefUtil.setInstanceField(item, "b", pose.getPose());
            return true;
        }
        return false;
    }

    private List<DataWatcher.Item<?>> getFieldB() {
        return (List<DataWatcher.Item<?>>) RefUtil.getInstanceField(super.packet, "b");
    }

    @Override
    public String getInfo() {
        return "entity metadata";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_ENTITY_METADATA;
    }
}
