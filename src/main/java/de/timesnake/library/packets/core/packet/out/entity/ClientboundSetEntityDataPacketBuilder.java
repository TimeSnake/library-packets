/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.entity;

import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClientboundSetEntityDataPacketBuilder {

  private static final EntityDataAccessor<Byte> DATA_SHARED_FLAGS_ID = ProxyManager.getInstance().getEntityProxy().getDataSharedFlagsId();

  private final net.minecraft.world.entity.Entity entity;
  private List<SynchedEntityData.DataValue<?>> packedItems = new LinkedList<>();

  public ClientboundSetEntityDataPacketBuilder(net.minecraft.world.entity.Entity entity) {
    this.entity = entity;
  }

  public ClientboundSetEntityDataPacket build() {
    return new ClientboundSetEntityDataPacket(entity.getId(), packedItems);
  }

  public ClientboundSetEntityDataPacketBuilder setFlagsFromEntity() {
    this.entity.getEntityData().markDirty(DATA_SHARED_FLAGS_ID);
    this.packedItems = this.entity.getEntityData().packDirty();
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setDefaultFlags() {
    this.packedItems = new LinkedList<>();
    for (Type type : Type.values()) {
      this.setFlag(type, false);
    }
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setFlag(Type type, boolean value) {
    this.setSharedFlag(type.getIndex(), value);
    return this;
  }

  public ClientboundSetEntityDataPacketBuilder setFlags(Map<Type, Boolean> values) {
    values.forEach((key, value1) -> this.setSharedFlag(key.getIndex(), value1));
    return this;
  }

  private void setSharedFlag(int index, boolean value) {
    SynchedEntityData synchedEntityData = entity.getEntityData();

    byte b = synchedEntityData.get(DATA_SHARED_FLAGS_ID);

    if (value) {
      b = (byte) (b | 1 << index);
    } else {
      b = (byte) (b & ~(1 << index));
    }

    this.packedItems.add(SynchedEntityData.DataValue.create(DATA_SHARED_FLAGS_ID, b));
  }

  public static boolean isPosePacket(ClientboundSetEntityDataPacket packet) {
    return packet.packedItems().stream().anyMatch(v -> v.id() == DATA_SHARED_FLAGS_ID.getId());
  }

  public static Boolean getFlagOfPacket(ClientboundSetEntityDataPacket packet, Type type) {
    return getSharedFlag(packet, type.getIndex());
  }

  public static Map<Type, Boolean> getFlagsOfPacket(ClientboundSetEntityDataPacket packet) {
    return Arrays.stream(Type.values())
        .map(t -> new Tuple<>(t, getSharedFlag(packet, t.getIndex())))
        .filter(t -> t.getB() != null)
        .collect(Collectors.toMap(Tuple::getA, Tuple::getB));
  }

  private static Boolean getSharedFlag(ClientboundSetEntityDataPacket packet, int index) {
    Byte b = null;

    for (SynchedEntityData.DataValue<?> dataValue : packet.packedItems()) {
      if (dataValue.id() == DATA_SHARED_FLAGS_ID.getId()) {
        b = ((byte) dataValue.value());
      }
    }

    if (b == null) {
      return null;
    }

    return ((b >> index) & 1) == 1;
  }

  public enum Type {
    ON_FIRE(0), SNEAKING(1), SLEEPING(2), SPRINTING(3), SWIMMING(4), VISIBLE(5), GLOWING(6), GLIDING(7);

    private final int index;

    Type(int index) {
      this.index = index;
    }

    public int getIndex() {
      return index;
    }
  }
}
