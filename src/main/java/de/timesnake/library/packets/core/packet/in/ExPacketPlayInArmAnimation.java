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

package de.timesnake.library.packets.core.packet.in;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.network.protocol.game.PacketPlayInArmAnimation;

@NmsReflection
public class ExPacketPlayInArmAnimation extends ExPacketPlayIn implements de.timesnake.library.packets.util.packet.ExPacketPlayInArmAnimation {

    public ExPacketPlayInArmAnimation(PacketPlayInArmAnimation packet) {
        super(packet);
    }

    @Override
    public ExEnumHand getHand() {
        return ExEnumHand.fromNms(((PacketPlayInArmAnimation) this.packet).b());
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.PLAY_IN_ARM_ANIMATION;
    }
}
