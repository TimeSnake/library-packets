package de.timesnake.basic.packets.core;

import de.timesnake.basic.packets.util.listener.InconsistentPacketListenerException;
import de.timesnake.basic.packets.util.listener.PacketHandler;
import de.timesnake.basic.packets.util.listener.PacketPlayInListener;
import de.timesnake.basic.packets.util.listener.PacketPlayOutListener;
import de.timesnake.basic.packets.util.packet.ExPacket;
import de.timesnake.basic.packets.util.packet.ExPacketPlayIn;
import de.timesnake.basic.packets.util.packet.ExPacketPlayOut;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ListenerManager {

    protected ConcurrentHashMap<ExPacket.Type, ConcurrentHashMap<PacketPlayOutListener, Set<Method>>> playOutListeners = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<ExPacket.Type, ConcurrentHashMap<PacketPlayOutListener, Set<Method>>> modifyPlayOutListeners = new ConcurrentHashMap<>();

    protected ConcurrentHashMap<ExPacket.Type, ConcurrentHashMap<PacketPlayInListener, Set<Method>>> playInListeners = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<ExPacket.Type, ConcurrentHashMap<PacketPlayInListener, Set<Method>>> modifyPlayInListeners = new ConcurrentHashMap<>();

    public void addListener(PacketPlayOutListener listener) {

        Class<?> clazz = listener.getClass();

        do {
            for (Method method : clazz.getDeclaredMethods()) {

                if (method.isAnnotationPresent(PacketHandler.class)) {

                    if (method.getParameters().length != 2) {
                        throw new InconsistentPacketListenerException("invalid parameter size");
                    }

                    PacketHandler annotation = method.getAnnotation(PacketHandler.class);
                    ExPacket.Type[] methodTypes = annotation.type();
                    for (ExPacket.Type type : methodTypes) {

                        if (!ExPacketPlayOut.class.isAssignableFrom(method.getParameterTypes()[0]) || !method.getParameterTypes()[1].equals(Player.class)) {
                            throw new InconsistentPacketListenerException("invalid parameter-types");
                        }

                        this.addMethod(listener, method, type, annotation.modify());
                    }
                }
            }

            clazz = clazz.getSuperclass();


        } while (clazz != null && PacketPlayOutListener.class.isAssignableFrom(clazz));
    }

    private void addMethod(PacketPlayOutListener listener, Method method, ExPacket.Type type, boolean modify) {
        if (!type.hasSubTypes()) {
            if (modify) {
                this.modifyPlayOutListeners.computeIfAbsent(type, k -> new ConcurrentHashMap<>()).computeIfAbsent(listener, k -> new HashSet<>()).add(method);
            } else {
                this.playOutListeners.computeIfAbsent(type, k -> new ConcurrentHashMap<>()).computeIfAbsent(listener,
                        k -> new HashSet<>()).add(method);
            }
            return;
        }

        for (ExPacket.Type subType : type.getSubTypes()) {
            this.addMethod(listener, method, subType, modify);
        }
    }

    public void addListener(PacketPlayInListener listener) {

        Class<?> clazz = listener.getClass();

        do {
            for (Method method : clazz.getDeclaredMethods()) {

                if (method.isAnnotationPresent(PacketHandler.class)) {

                    if (method.getParameters().length != 2) {
                        throw new InconsistentPacketListenerException("invalid parameter size");
                    }

                    PacketHandler annotation = method.getAnnotation(PacketHandler.class);
                    ExPacket.Type[] methodTypes = annotation.type();
                    for (ExPacket.Type type : methodTypes) {

                        if (!ExPacketPlayIn.class.isAssignableFrom(method.getParameterTypes()[0]) || !method.getParameterTypes()[1].equals(Player.class)) {
                            throw new InconsistentPacketListenerException("invalid parameter-types");
                        }

                        this.addMethod(listener, method, type, annotation.modify());
                    }
                }
            }

            clazz = clazz.getSuperclass();


        } while (clazz != null && PacketPlayOutListener.class.isAssignableFrom(clazz));
    }

    private void addMethod(PacketPlayInListener listener, Method method, ExPacket.Type type, boolean modify) {
        if (!type.hasSubTypes()) {
            if (modify) {
                this.modifyPlayInListeners.computeIfAbsent(type, k -> new ConcurrentHashMap<>()).computeIfAbsent(listener, k -> new HashSet<>()).add(method);
            } else {
                this.playInListeners.computeIfAbsent(type, k -> new ConcurrentHashMap<>()).computeIfAbsent(listener,
                        k -> new HashSet<>()).add(method);
            }
            return;
        }

        for (ExPacket.Type subType : type.getSubTypes()) {
            this.addMethod(listener, method, subType, modify);
        }
    }

    public void removeListener(PacketPlayOutListener listener, ExPacket.Type... types) {
        List<ConcurrentHashMap<PacketPlayOutListener, Set<Method>>> listeners = this.playOutListeners.entrySet().stream().filter(t -> types.length == 0 || Arrays.stream(types).anyMatch(type -> t.getKey().equals(type))).map(Map.Entry::getValue).toList();
        listeners.addAll(this.modifyPlayOutListeners.entrySet().stream().filter(t -> types.length == 0 || Arrays.stream(types).anyMatch(type -> t.getKey().equals(type))).map(Map.Entry::getValue).toList());

        for (ConcurrentHashMap<PacketPlayOutListener, ?> listenerMethods : listeners) {
            listenerMethods.remove(listener);
        }
    }

    public void removeListener(PacketPlayInListener listener, ExPacket.Type... types) {
        List<ConcurrentHashMap<PacketPlayInListener, Set<Method>>> listeners = this.playInListeners.entrySet().stream().filter(t -> types.length == 0 || Arrays.stream(types).anyMatch(type -> t.getKey().equals(type))).map(Map.Entry::getValue).toList();
        listeners.addAll(this.modifyPlayInListeners.entrySet().stream().filter(t -> types.length == 0 || Arrays.stream(types).anyMatch(type -> t.getKey().equals(type))).map(Map.Entry::getValue).toList());

        for (ConcurrentHashMap<PacketPlayInListener, ?> listenerMethods : listeners) {
            listenerMethods.remove(listener);
        }
    }

    public ExPacketPlayOut handlePacket(ExPacketPlayOut packet, Player receiver) {

        ExPacketPlayOut finalPacket = packet;
        new Thread(() -> {
            Set<Map.Entry<PacketPlayOutListener, Set<Method>>> set = this.playOutListeners.getOrDefault(finalPacket.getType(), new ConcurrentHashMap<>()).entrySet();

            for (Map.Entry<PacketPlayOutListener, Set<Method>> subSet : set) {
                PacketPlayOutListener listener = subSet.getKey();

                for (Method method : subSet.getValue()) {
                    try {
                        method.invoke(listener, finalPacket, receiver);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        boolean block = false;

        Set<Map.Entry<PacketPlayOutListener, Set<Method>>> set = this.modifyPlayOutListeners.getOrDefault(packet.getType(), new ConcurrentHashMap<>()).entrySet();

        for (Map.Entry<PacketPlayOutListener, Set<Method>> subSet : set) {
            PacketPlayOutListener listener = subSet.getKey();

            for (Method method : subSet.getValue()) {
                try {
                    ExPacketPlayOut editedPacket = (ExPacketPlayOut) method.invoke(listener, packet, receiver);
                    if (editedPacket == null) {
                        block = true;
                    } else {
                        packet = editedPacket;
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return block ? null : packet;
    }

    public ExPacketPlayIn handlePacket(ExPacketPlayIn packet, Player sender) {

        ExPacketPlayIn finalPacket = packet;
        new Thread(() -> {
            Set<Map.Entry<PacketPlayInListener, Set<Method>>> set = this.playInListeners.getOrDefault(finalPacket.getType(), new ConcurrentHashMap<>()).entrySet();

            for (Map.Entry<PacketPlayInListener, Set<Method>> subSet : set) {
                PacketPlayInListener listener = subSet.getKey();

                for (Method method : subSet.getValue()) {
                    try {
                        method.invoke(listener, finalPacket, sender);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        boolean block = false;

        Set<Map.Entry<PacketPlayInListener, Set<Method>>> set = this.modifyPlayInListeners.getOrDefault(packet.getType(), new ConcurrentHashMap<>()).entrySet();

        for (Map.Entry<PacketPlayInListener, Set<Method>> subSet : set) {
            PacketPlayInListener listener = subSet.getKey();

            for (Method method : subSet.getValue()) {
                try {
                    ExPacketPlayIn editedPacket = (ExPacketPlayIn) method.invoke(listener, packet, sender);
                    if (editedPacket == null) {
                        block = true;
                    } else {
                        packet = editedPacket;
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return block ? null : packet;
    }

}
