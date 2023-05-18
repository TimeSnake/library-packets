/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;

public class ExPacketPlayOutTablistHeaderFooter extends ExPacketPlayOutTablist implements
    de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistHeaderFooter {

  public static ExPacketPlayOut getPacket(PacketPlayOutPlayerListHeaderFooter packet) {
    return new ExPacketPlayOutTablistHeaderFooter(packet);
  }

  private final String header;
  private final String footer;

  public ExPacketPlayOutTablistHeaderFooter(String header, String footer) {
    if (footer == null) {
      footer = "";
    }

    if (header == null) {
      header = "";
    }

    super.packet =
        new PacketPlayOutPlayerListHeaderFooter(
            IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}"),
            IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}"));

    this.header = header;
    this.footer = footer;
  }

  public ExPacketPlayOutTablistHeaderFooter(PacketPlayOutPlayerListHeaderFooter packet) {
    super.packet = packet;
    if (packet.a != null) {
      this.header = packet.a.getString();
    } else {
      this.header = null;
    }
    if (packet.b != null) {
      this.footer = packet.b.getString();
    } else {
      this.footer = null;
    }
  }

  @Override
  public String getInfo() {
    return "header: " + this.header + " footer: " + this.footer;
  }

  @Override
  public Type getType() {
    return Type.PLAY_OUT_TABLIST_HEADER_FOOTER;
  }
}
