/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.packets.core.ExPacket;
import de.timesnake.library.packets.core.UnsupportedPacketException;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundInitializeBorderPacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderCenterPacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderLerpSizePacket;
import de.timesnake.library.packets.core.packet.out.border.ExClientboundSetBorderSizePacket;
import de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEquipment;
import de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityHeadRotation;
import de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityLook;
import de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityMetadata;
import de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutSpawnEntity;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardDisplayObjective;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutScoreboardObjective;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutSideboard;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistHeaderFooter;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistPlayer;
import de.timesnake.library.packets.core.packet.out.scoreboard.ExPacketPlayOutTablistTeam;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutMap;
import net.minecraft.network.protocol.game.PacketPlayOutOpenBook;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardObjective;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.network.protocol.game.PacketPlayOutUnloadChunk;

public abstract class ExPacketPlayOut extends ExPacket implements
    de.timesnake.library.packets.util.packet.ExPacketPlayOut {

  public static ExPacketPlayOut getPacket(Packet<? extends PacketListener> packet)
      throws UnsupportedPacketException {

    if (packet instanceof PacketPlayOutScoreboardTeam) {
      return ExPacketPlayOutTablistTeam.getPacket(((PacketPlayOutScoreboardTeam) packet));
    } else if (packet instanceof PacketPlayOutPlayerInfo) {
      return ExPacketPlayOutTablistPlayer.getPacket(((PacketPlayOutPlayerInfo) packet));
    } else if (packet instanceof PacketPlayOutPlayerListHeaderFooter) {
      return ExPacketPlayOutTablistHeaderFooter.getPacket(
          ((PacketPlayOutPlayerListHeaderFooter) packet));
    } else if (packet instanceof PacketPlayOutScoreboardScore) {
      return ExPacketPlayOutSideboard.getPacket(((PacketPlayOutScoreboardScore) packet));
    } else if (packet instanceof PacketPlayOutEntityMetadata) {
      return ExPacketPlayOutEntityMetadata.getPacket(((PacketPlayOutEntityMetadata) packet));
    } else if (packet instanceof PacketPlayOutScoreboardObjective) {
      return ExPacketPlayOutScoreboardObjective.getPacket(
          ((PacketPlayOutScoreboardObjective) packet));
    } else if (packet instanceof PacketPlayOutScoreboardDisplayObjective) {
      return ExPacketPlayOutScoreboardDisplayObjective.getPacket(
          ((PacketPlayOutScoreboardDisplayObjective) packet));
    } else if (packet instanceof PacketPlayOutOpenBook) {
      return ExPacketPlayOutOpenBook.getPacket(((PacketPlayOutOpenBook) packet));
    } else if (packet instanceof PacketPlayOutEntityEquipment) {
      return ExPacketPlayOutEntityEquipment.getPacket(((PacketPlayOutEntityEquipment) packet));
    } else if (packet instanceof PacketPlayOutEntityHeadRotation) {
      return ExPacketPlayOutEntityHeadRotation.getPacket((PacketPlayOutEntityHeadRotation) packet);
    } else if (packet instanceof PacketPlayOutEntity.PacketPlayOutEntityLook) {
      return ExPacketPlayOutEntityLook.getPacket(
          ((PacketPlayOutEntity.PacketPlayOutEntityLook) packet));
    } else if (packet instanceof ClientboundSetBorderCenterPacket) {
      return new ExClientboundSetBorderCenterPacket(((ClientboundSetBorderCenterPacket) packet));
    } else if (packet instanceof ClientboundSetBorderSizePacket) {
      return new ExClientboundSetBorderSizePacket(((ClientboundSetBorderSizePacket) packet));
    } else if (packet instanceof ClientboundSetBorderLerpSizePacket) {
      return new ExClientboundSetBorderLerpSizePacket(
          ((ClientboundSetBorderLerpSizePacket) packet));
    } else if (packet instanceof ClientboundInitializeBorderPacket) {
      return new ExClientboundInitializeBorderPacket(((ClientboundInitializeBorderPacket) packet));
    } else if (packet instanceof PacketPlayOutSpawnEntity) {
      return new ExPacketPlayOutSpawnEntity(((PacketPlayOutSpawnEntity) packet));
    } else if (packet instanceof PacketPlayOutMap) {
      return new ExPacketPlayOutMap((PacketPlayOutMap) packet);
    } else if (packet instanceof ClientboundLevelChunkWithLightPacket) {
      return new ExClientboundLevelChunkWithLightPacket(
          ((ClientboundLevelChunkWithLightPacket) packet));
    } else if (packet instanceof PacketPlayOutUnloadChunk) {
      return new ExPacketPlayOutChunkUnload(((PacketPlayOutUnloadChunk) packet));
    }
    throw new UnsupportedPacketException(packet);
  }

  public ExPacketPlayOut(Packet<? extends PacketListener> packet) {
    super(packet);
  }

  public ExPacketPlayOut() {
    super();
  }

}
