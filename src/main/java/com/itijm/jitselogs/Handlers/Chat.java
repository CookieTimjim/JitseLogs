package com.itijm.jitselogs.Handlers;

import com.itijm.jitselogs.Util.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public static void onChat(AsyncPlayerChatEvent event) {
        DiscordWebhook.message(event.getMessage(), event.getPlayer().getName());
    }
}
