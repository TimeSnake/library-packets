package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.basic.util.NmsReflection;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardObjective;
import net.minecraft.world.scores.ScoreboardObjective;

public class ExPacketPlayOutScoreboardObjective extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutScoreboardObjective {

    @NmsReflection
    private final String name;
    private Display display;

    public ExPacketPlayOutScoreboardObjective(PacketPlayOutScoreboardObjective packet) {
        super(packet);
        this.name = packet.b();
    }

    public ExPacketPlayOutScoreboardObjective(String name, String title, Display display, ExPacketPlayOutScoreboardObjective.ScoreboardType type) {
        ScoreboardObjective sb = new PacketScoreboardObjective(name, new ChatComponentText(title), type.getType());

        super.packet = new PacketPlayOutScoreboardObjective(sb, display.getDisplay());

        this.name = name;
        this.display = display;
    }

    @Override
    public String getInfo() {
        return "objective: " + this.name + " " + this.display != null ? this.display.name().toLowerCase() : "";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SCOREBOARD_OBJ;
    }

    public static ExPacketPlayOutScoreboardObjective getPacket(PacketPlayOutScoreboardObjective packet) {
        return new ExPacketPlayOutScoreboardObjective(packet);
    }
}
