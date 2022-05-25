package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.basic.packets.core.UnsupportedPacketException;
import de.timesnake.basic.packets.core.packet.out.ExPacketPlayOut;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore;
import net.minecraft.server.ScoreboardServer;

@NmsReflection(usesReflection = true)
public abstract class ExPacketPlayOutSideboard extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutSideboard {

    protected final String sideboardName;
    protected final int line;
    protected final String text;

    public ExPacketPlayOutSideboard(Packet<? extends PacketListener> packet, String sideboardName, int line,
                                    String text) {
        super(packet);
        this.sideboardName = sideboardName;
        this.line = line;
        this.text = text;
    }

    public ExPacketPlayOutSideboard(String sideboardName, Integer line, String text) {
        this.sideboardName = sideboardName;
        this.line = line;
        this.text = text;
    }

    public static ExPacketPlayOut getPacket(PacketPlayOutScoreboardScore packet) throws UnsupportedPacketException {
        ScoreboardServer.Action type = (ScoreboardServer.Action) RefUtil.getInstanceField(packet, "d");
        int line = (int) RefUtil.getInstanceField(packet, "c");
        String text = (String) RefUtil.getInstanceField(packet, "a");
        String scoreboardName = (String) RefUtil.getInstanceField(packet, "b");

        if (type.equals(Action.CHANGE.getNms())) {
            return new ExPacketPlayOutSideboardScoreSet(scoreboardName, text, line);
        } else if (type.equals(Action.REMOVE.getNms())) {
            return new ExPacketPlayOutSideboardScoreRemove(scoreboardName, text, line);
        }

        throw new UnsupportedPacketException(packet);
    }

    @Override
    public String getSideboardName() {
        return sideboardName;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getInfo() {
        return "line: " + this.line + " text: " + this.text;
    }

    public enum Action {
        CHANGE(ScoreboardServer.Action.a),
        REMOVE(ScoreboardServer.Action.b);


        private final ScoreboardServer.Action nms;

        Action(ScoreboardServer.Action nms) {
            this.nms = nms;
        }

        public ScoreboardServer.Action getNms() {
            return nms;
        }
    }
}
