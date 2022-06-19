package de.timesnake.library.packets.core.packet.out.scoreboard;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.scores.ScoreboardObjective;
import net.minecraft.world.scores.criteria.IScoreboardCriteria;

@NmsReflection
public class PacketScoreboardObjective extends ScoreboardObjective {

    public PacketScoreboardObjective(String name, IChatBaseComponent title,
                                     IScoreboardCriteria.EnumScoreboardHealthDisplay type) {
        super(null, name, null, title, type);
    }

    public PacketScoreboardObjective(String name, IScoreboardCriteria.EnumScoreboardHealthDisplay type) {
        super(null, name, null, IChatBaseComponent.a(""), type);
    }
}
