/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.scoreboard;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import org.bukkit.ChatColor;

import java.lang.reflect.Field;


public class ExPacketPlayOutTablistTeamCreation extends ExPacketPlayOutTablistTeam implements de.timesnake.library.packets.util.packet.ExPacketPlayOutTablistTeamCreation {

    private final String prefix;

    public ExPacketPlayOutTablistTeamCreation(String name, String prefix, ChatColor chatColor) {
        super(name);
        if (name == null || name.equals("")) {
            this.prefix = null;
            return;
        }

        ScoreboardTeam team = new ScoreboardTeam(null, name);

        try {
            Field m = ScoreboardTeam.class.getDeclaredField("m");
            m.setAccessible(true);
            m.set(team, getEnumChatFormat(chatColor));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (prefix == null) {
            prefix = "";
        }

        try {
            Field g = ScoreboardTeam.class.getDeclaredField("g");
            g.setAccessible(true);
            g.set(team, IChatBaseComponent.a(prefix));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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

        try {
            Field m = ScoreboardTeam.class.getDeclaredField("m");
            m.setAccessible(true);
            m.set(team, getEnumChatFormat(chatColor));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (prefix == null) {
            prefix = "";
        }

        try {
            Field g = ScoreboardTeam.class.getDeclaredField("g");
            g.setAccessible(true);
            g.set(team, IChatBaseComponent.a(prefix));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Field k = ScoreboardTeam.class.getDeclaredField("k");
            k.setAccessible(true);
            k.set(team, visibility.getNms());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Field l = ScoreboardTeam.class.getDeclaredField("l");
            l.setAccessible(true);
            l.set(team, visibility.getNms());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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
