/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.packets.core.packet.out.ExPacketPlayOut;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardObjective;
import net.minecraft.world.scores.ScoreboardObjective;

public class ExPacketPlayOutScoreboardObjective extends ExPacketPlayOut implements
        de.timesnake.library.packets.util.packet.ExPacketPlayOutScoreboardObjective {

    public static ExPacketPlayOutScoreboardObjective getPacket(
            PacketPlayOutScoreboardObjective packet) {
        return new ExPacketPlayOutScoreboardObjective(packet);
    }

    private final String name;
    private Display display;

    public ExPacketPlayOutScoreboardObjective(PacketPlayOutScoreboardObjective packet) {
        super(packet);
        this.name = packet.b();
    }

    public ExPacketPlayOutScoreboardObjective(String name, String title, Display display,
            ExPacketPlayOutScoreboardObjective.ScoreboardType type) {
        ScoreboardObjective sb = new PacketScoreboardObjective(name,
                IChatBaseComponent.a(title), type != null ? type.getType() : null);

        super.packet = new PacketPlayOutScoreboardObjective(sb, display.getDisplay());

        this.name = name;
        this.display = display;
    }

    @Override
    public String getInfo() {
        return "objective: " + this.name + " " + this.display != null ? this.display.name()
                .toLowerCase() : "";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SCOREBOARD_OBJ;
    }
}
