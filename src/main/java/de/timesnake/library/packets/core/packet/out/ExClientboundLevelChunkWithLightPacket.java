/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out;

import de.timesnake.library.basic.util.Tuple;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import org.jetbrains.annotations.NotNull;

public class ExClientboundLevelChunkWithLightPacket extends ExPacketPlayOut {

    public ExClientboundLevelChunkWithLightPacket(ClientboundLevelChunkWithLightPacket packet) {
        super(packet);
    }

    public Tuple<Integer, Integer> getChunkCoordinates() {
        return new Tuple<>(this.getPacket().b(), this.getPacket().c());
    }

    @NotNull
    @Override
    public ClientboundLevelChunkWithLightPacket getPacket() {
        return (ClientboundLevelChunkWithLightPacket) super.getPacket();
    }

    @Override
    public String getInfo() {
        Tuple<Integer, Integer> chunk = this.getChunkCoordinates();
        return "x=" + chunk.getA() + " y=" + chunk.getB();
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_LEVEL_CHUNK_WITH_LIGHT_PACKET;
    }
}
