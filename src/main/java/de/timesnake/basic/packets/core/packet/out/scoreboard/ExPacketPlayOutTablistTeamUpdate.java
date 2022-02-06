package de.timesnake.basic.packets.core.packet.out.scoreboard;

import de.timesnake.library.basic.util.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_18_R1.util.CraftChatMessage;

public class ExPacketPlayOutTablistTeamUpdate extends ExPacketPlayOutTablistTeam implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutTablistTeamUpdate {

    private final String prefix;

    public ExPacketPlayOutTablistTeamUpdate(String name, String prefix, ChatColor chatColor) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        @NmsReflection ScoreboardTeam team = new ScoreboardTeam(null, name);

        RefUtil.setInstanceField(team, "m", getEnumChatFormat(chatColor));

        if (prefix != null && prefix.equals("")) {
            prefix = null;
        }
        RefUtil.setInstanceField(team, "g", CraftChatMessage.fromStringOrNull(prefix));

        super.packet = PacketPlayOutScoreboardTeam.a(team, false);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamUpdate(String name, String prefix) {
        super(name);
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getInfo() {
        return "team: " + this.name + " prefix: " + this.prefix + " update";
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_UPDATE;
    }
}
