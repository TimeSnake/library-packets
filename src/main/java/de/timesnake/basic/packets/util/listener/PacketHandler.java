package de.timesnake.basic.packets.util.listener;

import de.timesnake.basic.packets.util.packet.ExPacket;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PacketHandler {

    ExPacket.Type[] type();

    boolean modify() default false;
}
