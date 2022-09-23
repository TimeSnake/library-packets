package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import org.bukkit.ChatColor;

@NmsReflection(usesReflection = true)
public class ExPacketPlayOutTablistTeamCreation extends ExPacketPlayOutTablistTeam implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamCreation {

    private final String prefix;

    public ExPacketPlayOutTablistTeamCreation(String name, String prefix, ChatColor chatColor) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        RefUtil.setInstanceField(team, "m", getEnumChatFormat(chatColor));

        if (prefix == null) {
            prefix = "";
        }

        RefUtil.setInstanceField(team, "g", IChatBaseComponent.a(prefix));

        super.packet = PacketPlayOutScoreboardTeam.a(team, true);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamCreation(String name, String prefix, ChatColor chatColor,
                                              NameTagVisibility visibility) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        RefUtil.setInstanceField(team, "m", getEnumChatFormat(chatColor));
        RefUtil.setInstanceField(team, "k", visibility.getNms());
        RefUtil.setInstanceField(team, "l", visibility.getNms());

        if (prefix == null) {
            prefix = "";
        }

        RefUtil.setInstanceField(team, "g", IChatBaseComponent.a(prefix));

        super.packet = PacketPlayOutScoreboardTeam.a(team, true);
        this.prefix = prefix;
    }

    public ExPacketPlayOutTablistTeamCreation(PacketPlayOutScoreboardTeam packet, String name, String prefix) {
        super(packet, name);
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getInfo() {
        return "name: " + this.name + " prefix: " + this.prefix;
    }

    @Override
    public Type getType() {
        return Type.PLAY_OUT_TABLIST_TEAM_CREATION;
    }

}