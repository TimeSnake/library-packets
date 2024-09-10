/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.basic.util.Tuple;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ClientboundSetEntityDataPacketBuilder {

  private static final EntityDataAccessor<Byte> DATA_SHARED_FLAGS_ID_DATA_ACCESSOR;
  private static final EntityDataAccessor<Pose> POSE_ENTITY_DATA_ACCESSOR;
  private static final EntityDataAccessor<Optional<Component>> DATA_CUSTOM_NAME_DATA_ACCESSOR;
  private static final EntityDataAccessor<Boolean> DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR;

  static {
    try {
      Field dataAccessorField = Entity.class.getDeclaredField("DATA_SHARED_FLAGS_ID");
      dataAccessorField.setAccessible(true);
      DATA_SHARED_FLAGS_ID_DATA_ACCESSOR = (EntityDataAccessor<Byte>) dataAccessorField.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    try {
      Field dataAccessorField = Entity.class.getDeclaredField("DATA_POSE");
      dataAccessorField.setAccessible(true);
      POSE_ENTITY_DATA_ACCESSOR = (EntityDataAccessor<Pose>) dataAccessorField.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    try {
      Field dataAccessorField = Entity.class.getDeclaredField("DATA_CUSTOM_NAME");
      dataAccessorField.setAccessible(true);
      DATA_CUSTOM_NAME_DATA_ACCESSOR = (EntityDataAccessor<Optional<Component>>) dataAccessorField.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    try {
      Field dataAccessorField = Entity.class.getDeclaredField("DATA_CUSTOM_NAME_VISIBLE");
      dataAccessorField.setAccessible(true);
      DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR = (EntityDataAccessor<Boolean>) dataAccessorField.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  private static SynchedEntityData.DataItem<?>[] getSyncedEntityData_itemsById(SynchedEntityData synchedEntityData) {
    SynchedEntityData.DataItem<?>[] list;
    try {
      Field dataAccessorField = SynchedEntityData.class.getDeclaredField("itemsById");
      dataAccessorField.setAccessible(true);
      list = (SynchedEntityData.DataItem<?>[]) dataAccessorField.get(synchedEntityData);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  private final net.minecraft.world.entity.Entity entity;
  private final ClientboundSetEntityDataPacket packet;

  public ClientboundSetEntityDataPacketBuilder(Entity entity) {
    this.entity = entity;
    this.packet = new ClientboundSetEntityDataPacket(entity.getId(), new LinkedList<>());
  }

  public ClientboundSetEntityDataPacketBuilder(Entity entity, ClientboundSetEntityDataPacket packet) {
    this.entity = entity;
    this.packet = new ClientboundSetEntityDataPacket(packet.id(), new LinkedList<>(packet.packedItems()));
  }

  public ClientboundSetEntityDataPacket build() {
    return this.packet;
  }

  public ClientboundSetEntityDataPacketBuilder setAllFromEntity() {
    this.packet.packedItems().clear();
    this.packet.packedItems().addAll(Arrays.stream(getSyncedEntityData_itemsById(this.entity.getEntityData()))
        .map(SynchedEntityData.DataItem::value).toList());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setPoseFromEntity() {
    this.setPose(this.entity.getPose());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setPose(Pose pose) {
    this.packet.packedItems().removeIf(i -> i.id() == POSE_ENTITY_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(POSE_ENTITY_DATA_ACCESSOR, pose));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameFromEntity() {
    this.setCustomName(this.entity.getCustomName());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomName(String name) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR,
        Optional.of(Component.literal(name))));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomName(Component component) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR,
        Optional.of(component)));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder resetCustomName() {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR, Optional.empty()));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameVisibleFromEntity() {
    this.setCustomNameVisible(this.entity.isCustomNameVisible());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameVisible(Boolean flag) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR, flag));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setFlagsFromEntity() {
    this.setFlags(this.entity.getEntityData().get(DATA_SHARED_FLAGS_ID_DATA_ACCESSOR));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setDefaultFlags() {
    for (SharedFlags sharedFlags : SharedFlags.values()) {
      this.setFlag(sharedFlags, false);
    }
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setFlag(SharedFlags sharedFlags, boolean value) {
    this.setSharedFlag(sharedFlags.getIndex(), value);
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setFlags(Map<SharedFlags, Boolean> values) {
    values.forEach((key, value1) -> this.setSharedFlag(key.getIndex(), value1));
    return this;
  }

  private void setSharedFlag(int index, boolean value) {
    byte b =
        (byte) this.packet.packedItems().stream().filter(i -> i.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.id()).findFirst().get().value();

    if (value) {
      b = (byte) (b | 1 << index);
    } else {
      b = (byte) (b & ~(1 << index));
    }

    this.setFlags(b);
  }

  private void setFlags(byte flags) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.id());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_SHARED_FLAGS_ID_DATA_ACCESSOR, flags));
  }

  public static boolean isSharedFlagsPacket(ClientboundSetEntityDataPacket packet) {
    return packet.packedItems().stream().anyMatch(v -> v.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.id());
  }

  public static boolean isPosePacket(ClientboundSetEntityDataPacket packet) {
    return packet.packedItems().stream().anyMatch(v -> v.id() == POSE_ENTITY_DATA_ACCESSOR.id());
  }

  @Nullable
  public static Boolean getFlagOfPacket(ClientboundSetEntityDataPacket packet, SharedFlags sharedFlags) {
    return getSharedFlag(packet.packedItems(), sharedFlags.getIndex());
  }

  public static Map<SharedFlags, Boolean> getFlagsOfPacket(ClientboundSetEntityDataPacket packet) {
    return Arrays.stream(SharedFlags.values())
        .map(t -> new Tuple<>(t, getSharedFlag(packet.packedItems(), t.getIndex())))
        .filter(t -> t.getB() != null)
        .collect(Collectors.toMap(Tuple::getA, Tuple::getB));
  }

  @Nullable
  public static Pose getPoseOfPacket(ClientboundSetEntityDataPacket packet) {
    for (SynchedEntityData.DataValue<?> dataValue : packet.packedItems()) {
      if (dataValue.id() == POSE_ENTITY_DATA_ACCESSOR.id()) {
        return ((Pose) dataValue.value());
      }
    }
    return null;
  }

  @Nullable
  private static Boolean getSharedFlag(List<SynchedEntityData.DataValue<?>> packedItems, int index) {
    Byte b = null;

    for (SynchedEntityData.DataValue<?> dataValue : packedItems) {
      if (dataValue.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.id()) {
        b = ((byte) dataValue.value());
      }
    }

    if (b == null) {
      return null;
    }

    return ((b >> index) & 1) == 1;
  }

  public enum SharedFlags {
    ON_FIRE(0),
    CROUCHING(1),
    /**
     * 2 unused
     */
    SPRINTING(3),
    SWIMMING(4),
    VISIBLE(5),
    GLOWING(6),
    GLIDING(7);

    private final int index;

    SharedFlags(int index) {
      this.index = index;
    }

    public int getIndex() {
      return index;
    }
  }
}
