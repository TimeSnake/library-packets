/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

public interface ExPacketPlayOutSideboard extends ExPacketPlayOut {

  String getSideboardName();

  int getLine();

  String getText();
}
