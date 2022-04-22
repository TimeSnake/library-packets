package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;

@NmsReflection
public class ExPacketPlayOutTablistTeamRemove extends ExPacketPlayOutTablistTeam implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablistTeamRemove {

    public ExPacketPlayOutTablistTeamRemove(String name) {
        super(name);
        ScoreboardTeam team = new ScoreboardTeam(null, name);
        super.packet = PacketPlayOutScoreboardTeam.a(team);
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_REMOVE;
    }

    @Override
    public String getInfo() {
        return "team " + this.name + " remove";
    }

}
