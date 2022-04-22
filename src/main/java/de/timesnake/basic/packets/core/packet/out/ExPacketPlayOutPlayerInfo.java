package de.timesnake.basic.packets.core.packet.out;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

@NmsReflection
public class ExPacketPlayOutPlayerInfo extends ExPacketPlayOut implements de.timesnake.basic.packets.util.packet.ExPacketPlayOutPlayerInfo {


    public ExPacketPlayOutPlayerInfo(Player player, Action action) {
        super.packet = new PacketPlayOutPlayerInfo(action.getAction(), ((CraftPlayer) player).getHandle());
    }

    public ExPacketPlayOutPlayerInfo(EntityPlayer player, Action action) {
        super.packet = new PacketPlayOutPlayerInfo(action.getAction(), player);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }
}
