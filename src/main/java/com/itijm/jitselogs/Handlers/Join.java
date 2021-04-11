package com.itijm.jitselogs.Handlers;

import com.itijm.jitselogs.Util.DiscordWebhook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) {
            String message = player.getName() + " joined on " + player.getAddress().toString().replace("/", "").split(":")[0];
            DiscordWebhook.embed(0xE3D4D3, message, false);
        } else {
            String message = "**NEW JOIN:** " + player.getName() + " joined on " + player.getAddress().toString().replace("/", "").split(":")[0];
            DiscordWebhook.embed(0xE3D4D3, message, true);
        }
    }

}
