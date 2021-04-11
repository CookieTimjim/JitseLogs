package com.itijm.jitselogs.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Sleep implements Listener {

    @EventHandler
    public static void SleepEvent (PlayerBedEnterEvent event) {

        Player player = event.getPlayer();
        World world = player.getWorld();

        if (world.getTime() > 13050 && world.getTime() < 23050) {
            event.setCancelled(true);

            world.setTime(24000);
            world.setThundering(false);
            world.setStorm(false);

            Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " slept through the night!");
        }
    }
}