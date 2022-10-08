/*
 * library-packets.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.packets.util.packet;

import org.bukkit.entity.Player;

public interface ExPacketPlayOutEntityEffect extends ExPacketPlayOut {

    static ExPacketPlayOutEntityEffect wrap(Player player, Effect effect, byte amplifier, int duration,
                                            boolean ambient, boolean showParticles, boolean showIcon) {
        return new de.timesnake.library.packets.core.packet.out.entity.ExPacketPlayOutEntityEffect(player, effect,
                amplifier, duration, ambient, showParticles, showIcon);
    }

    enum Effect {
        FASTER_MOVEMENT(1),
        SLOWER_MOVEMENT(2),
        FASTER_DIG(3),
        SLOWER_DIG(4),
        INCREASE_DAMAGE(5),
        HEAL(6),
        HARM(7),
        JUMP(8),
        CONFUSION(9),
        REGENERATION(10),
        RESISTANCE(11),
        FIRE_RESISTANCE(12),
        WATER_BREATHING(13),
        INVISIBILITY(14),
        BLINDNESS(15),
        NIGHT_VISION(16),
        HUNGER(17),
        WEAKNESS(18),
        POISON(19),
        WITHER(20),
        HEALTH_BOOST(21),
        ABSORBTION(22),
        SATURATION(23),
        GLOWING(24),
        LEVITATION(25),
        LUCK(26),
        UNLUCK(27),
        SLOW_FALLING(28),
        CONDUIT_POWER(29),
        DOLPHINS_GRACE(30),
        BAD_OMEN(31),
        HERO_OF_THE_VILLAGE(32);

        private final int id;

        Effect(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
