/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.listener;

import net.minecraft.network.protocol.Packet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PacketHandler {

  Class<? extends Packet<?>>[] type();

  boolean modify() default false;
}
