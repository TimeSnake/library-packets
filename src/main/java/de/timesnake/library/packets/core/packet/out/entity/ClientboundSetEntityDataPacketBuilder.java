/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.proxy.ProxyManager;
import de.timesnake.library.entities.proxy.SynchedEntityDataProxy;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class ClientboundSetEntityDataPacketBuilder {

  private static final EntityDataAccessor<Byte> DATA_SHARED_FLAGS_ID_DATA_ACCESSOR =
      ProxyManager.getInstance().getEntityProxy().getDataSharedFlagsIdDataAccessor();
  private static final EntityDataAccessor<Pose> POSE_ENTITY_DATA_ACCESSOR =
      ProxyManager.getInstance().getEntityProxy().getDataPoseDataAccessor();
  private static final EntityDataAccessor<Optional<Component>> DATA_CUSTOM_NAME_DATA_ACCESSOR =
      ProxyManager.getInstance().getEntityProxy().getCustomNameDataAccessor();
  private static final EntityDataAccessor<Boolean> DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR =
      ProxyManager.getInstance().getEntityProxy().getCustomNameVisibleDataAccessor();

  private static final SynchedEntityDataProxy SYNCED_ENTITY_DATA_PROXY =
      ProxyManager.getInstance().getSynchedEntityDataProxy();

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
    this.packet.packedItems().addAll(SYNCED_ENTITY_DATA_PROXY.getItemsById(this.entity.getEntityData()).values().stream()
        .map(SynchedEntityData.DataItem::value).toList());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setPoseFromEntity() {
    this.setPose(this.entity.getPose());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setPose(Pose pose) {
    this.packet.packedItems().removeIf(i -> i.id() == POSE_ENTITY_DATA_ACCESSOR.getId());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(POSE_ENTITY_DATA_ACCESSOR, pose));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameFromEntity() {
    this.setCustomName(this.entity.getCustomName());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomName(String name) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.getId());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR,
        Optional.of(Component.literal(name))));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomName(Component component) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.getId());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR,
        Optional.of(component)));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder resetCustomName() {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_DATA_ACCESSOR.getId());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_CUSTOM_NAME_DATA_ACCESSOR, Optional.empty()));
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameVisibleFromEntity() {
    this.setCustomNameVisible(this.entity.isCustomNameVisible());
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setCustomNameVisible(Boolean flag) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_CUSTOM_NAME_VISIBLE_DATA_ACCESSOR.getId());
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
        (byte) this.packet.packedItems().stream().filter(i -> i.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.getId()).findFirst().get().value();

    if (value) {
      b = (byte) (b | 1 << index);
    } else {
      b = (byte) (b & ~(1 << index));
    }

    this.setFlags(b);
  }

  private void setFlags(byte flags) {
    this.packet.packedItems().removeIf(i -> i.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.getId());
    this.packet.packedItems().add(SynchedEntityData.DataValue.create(DATA_SHARED_FLAGS_ID_DATA_ACCESSOR, flags));
  }

  public static boolean isSharedFlagsPacket(ClientboundSetEntityDataPacket packet) {
    return packet.packedItems().stream().anyMatch(v -> v.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.getId());
  }

  public static boolean isPosePacket(ClientboundSetEntityDataPacket packet) {
    return packet.packedItems().stream().anyMatch(v -> v.id() == POSE_ENTITY_DATA_ACCESSOR.getId());
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
      if (dataValue.id() == POSE_ENTITY_DATA_ACCESSOR.getId()) {
        return ((Pose) dataValue.value());
      }
    }
    return null;
  }

  @Nullable
  private static Boolean getSharedFlag(List<SynchedEntityData.DataValue<?>> packedItems, int index) {
    Byte b = null;

    for (SynchedEntityData.DataValue<?> dataValue : packedItems) {
      if (dataValue.id() == DATA_SHARED_FLAGS_ID_DATA_ACCESSOR.getId()) {
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
