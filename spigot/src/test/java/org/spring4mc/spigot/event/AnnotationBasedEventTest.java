package org.spring4mc.spigot.event;

import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring4mc.Application;
import org.spring4mc.spigot.listener.SpigotEventListener;
import org.spring4mc.spigot.listener.SpigotEventOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CompletableFuture;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
public class AnnotationBasedEventTest {
    @Autowired
    private ApplicationContext context;

    @Component
    public static class Listener {

        @SpigotEventListener
        @SpigotEventOrder(EventPriority.LOW)
        public void onPlayerJoinEvent(PlayerJoinEvent event) {
            // Do sync stuff
        }

        @SpigotEventListener
        public EventExecutionResult onAsyncJoin(EventExecutionContext<AsyncPlayerPreLoginEvent> event) {
            // Some kind of async task
            final CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {});


            return event.advanceOnCompletion(task);
        }

        // Easier way of doing ^
        @SpigotEventListener
        public CompletableFuture<Void> onAsyncJoinAsync(AsyncPlayerPreLoginEvent event) {
            return CompletableFuture.runAsync(() -> {});
        }
    }
}
