package org.spring4mc.spigot.listener;

import org.bukkit.event.EventPriority;

public @interface SpigotEventOrder {
    EventPriority value() default EventPriority.NORMAL;
}
