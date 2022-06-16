package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore;

@NmsReflection
public class ExPacketPlayOutSideboardScoreRemove extends ExPacketPlayOutSideboard implements de.timesnake.library.packets.util.packet.ExPacketPlayOutSideboardScoreRemove {

    public ExPacketPlayOutSideboardScoreRemove(String sideboardName, String text, int line) {
        super(new PacketPlayOutScoreboardScore(Action.REMOVE.getNms(), sideboardName, text, line), sideboardName,
                line, text);
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_SIDEBOARD_SCORE_REMOVE;
    }


}
