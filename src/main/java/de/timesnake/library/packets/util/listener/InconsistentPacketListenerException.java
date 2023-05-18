/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.listener;

public class InconsistentPacketListenerException extends RuntimeException {

  public InconsistentPacketListenerException() {

  }

  public InconsistentPacketListenerException(String message) {
    super(message);
  }
}
