/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.world.scores.ScoreboardObjective;

public class ExPacketPlayOutScoreboardDisplayObjective extends ExPacketPlayOut implements de.timesnake.library.packets.util.packet.ExPacketPlayOutScoreboardDisplayObjective {

    public static ExPacketPlayOutScoreboardDisplayObjective getPacket(PacketPlayOutScoreboardDisplayObjective packet) {
        return new ExPacketPlayOutScoreboardDisplayObjective(packet);
    }

    private final String name;

    public ExPacketPlayOutScoreboardDisplayObjective(PacketPlayOutScoreboardDisplayObjective packet) {
        super(packet);

        this.name = packet.c();
    }

    public ExPacketPlayOutScoreboardDisplayObjective(String name, Slot slot) {
        ScoreboardObjective sb = new PacketScoreboardObjective(name, null);
        super.packet = new PacketPlayOutScoreboardDisplayObjective(slot.getType(), sb);

        this.name = name;
    }

    @Override
    public String getInfo() {
        return "display objective: " + this.name != null ? this.name : "";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SCOREBOARD_DISPLAY_OBJ;
    }
}
