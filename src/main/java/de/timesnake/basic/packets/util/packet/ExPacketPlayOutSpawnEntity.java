package de.timesnake.basic.packets.util.packet;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;

public interface ExPacketPlayOutSpawnEntity extends ExPacketPlayOut {

    static ExPacketPlayOutSpawnEntity wrap(Entity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity);
    }

    static ExPacketPlayOutSpawnEntity wrap(ExEntity entity) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity);
    }

    static ExPacketPlayOutSpawnEntity wrap(Entity entity, int data) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, data);
    }

    static ExPacketPlayOutSpawnEntity wrap(ExEntity entity, int data) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, data);
    }

    static ExPacketPlayOutSpawnEntity wrap(Entity entity, ItemFrameRotation rotation) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, rotation);
    }

    static ExPacketPlayOutSpawnEntity wrap(ExEntity entity, ItemFrameRotation rotation) {
        return new de.timesnake.basic.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity(entity, rotation);
    }

    static ItemFrameRotation blockFaceToRotation(BlockFace face) {
        return switch (face) {
            case DOWN -> ItemFrameRotation.DOWN;
            case UP -> ItemFrameRotation.UP;
            case NORTH -> ItemFrameRotation.NORTH;
            case SOUTH -> ItemFrameRotation.SOUTH;
            case WEST -> ItemFrameRotation.WEST;
            case EAST -> ItemFrameRotation.EAST;
            default -> null;
        };
    }

    enum ItemFrameRotation {

        DOWN(0),
        UP(1),
        NORTH(2),
        SOUTH(3),
        WEST(4),
        EAST(5);

        private final int nms;

        ItemFrameRotation(int nms) {
            this.nms = nms;
        }

        public int getNms() {
            return nms;
        }
    }
}
