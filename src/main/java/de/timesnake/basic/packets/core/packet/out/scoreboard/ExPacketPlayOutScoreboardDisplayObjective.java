package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.world.scores.ScoreboardObjective;

@NmsReflection
public class ExPacketPlayOutScoreboardDisplayObjective extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutScoreboardDisplayObjective {

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

    public static ExPacketPlayOutScoreboardDisplayObjective getPacket(PacketPlayOutScoreboardDisplayObjective packet) {
        return new ExPacketPlayOutScoreboardDisplayObjective(packet);
    }
}
