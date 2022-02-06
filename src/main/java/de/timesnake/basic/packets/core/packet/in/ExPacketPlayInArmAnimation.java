package de.timesnake.basic.packets.core.packet.in;

import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.network.protocol.game.PacketPlayInArmAnimation;

public class ExPacketPlayInArmAnimation extends ExPacketPlayIn implements de.timesnake.basic.packets.util.packet.ExPacketPlayInArmAnimation {

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
