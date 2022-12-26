/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.packets.core.packet.out.border;

import net.minecraft.server.level.WorldServer;
import net.minecraft.world.level.border.WorldBorder;

public class PacketWorldBorder extends WorldBorder {

    public static PacketWorldBorder lerp(WorldServer worldServer, double newSize, double oldSize, long time) {
        return new PacketWorldBorder(worldServer, 0, 0, newSize, oldSize, time, 0, 0);
    }

    public static PacketWorldBorder center(WorldServer worldServer, double centerX, double centerZ) {
        return new PacketWorldBorder(worldServer, centerX, centerZ, 0, 0, 0, 0, 0);
    }

    public static PacketWorldBorder size(WorldServer worldServer, double size) {
        return new PacketWorldBorder(worldServer, 0, 0, size, size, 0, 0, 0);
    }

    public static PacketWorldBorder init(WorldServer worldServer, double centerX, double centerZ, double newSize,
                                         double oldSize, long time, int warningDistance, int warningTime) {
        return new PacketWorldBorder(worldServer, centerX, centerZ, newSize, oldSize, time, warningDistance,
                warningTime);
    }

    private final double centerX;
    private final double centerZ;
    private final double newSize;
    private final double oldSize;
    private final long time;
    //private final int f;
    private final int warningDistance;
    private final int warningTime;

    public PacketWorldBorder(WorldServer worldServer, double centerX, double centerZ, double newSize, double oldSize,
                             long time, int warningDistance, int warningTime) {
        this.centerX = centerX;
        this.centerZ = centerZ;
        this.newSize = newSize;
        this.oldSize = oldSize;
        this.time = time;
        //this.f = super.k;
        this.warningDistance = warningDistance;
        this.warningTime = warningTime;

        this.world = worldServer;
    }

    @Override
    public double a() {
        return this.centerX;
    }

    @Override
    public double b() {
        return this.centerZ;
    }

    @Override
    public double i() {
        return this.newSize;
    }

    @Override
    public double k() {
        return this.oldSize;
    }

    @Override
    public long j() {
        return this.time;
    }

    /*
    @Override
    public int m() {
        return this.f;
    }

     */

    @Override
    public int r() {
        return this.warningDistance;
    }

    @Override
    public int q() {
        return this.warningTime;
    }
}
