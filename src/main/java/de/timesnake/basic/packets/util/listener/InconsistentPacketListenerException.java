package de.timesnake.basic.packets.util.listener;

public class InconsistentPacketListenerException extends RuntimeException {

    public InconsistentPacketListenerException() {

    }

    public InconsistentPacketListenerException(String message) {
        super(message);
    }
}
