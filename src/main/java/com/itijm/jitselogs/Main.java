package com.itijm.jitselogs;

import com.itijm.jitselogs.Handlers.Chat;
import com.itijm.jitselogs.Handlers.Join;
import com.itijm.jitselogs.Util.DiscordWebhook;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);
        DiscordWebhook.embed(0xE3D4D3, "Server startup", false);
    }

    @Override
    public void onDisable() {
        DiscordWebhook.embed(0xE3D4D3, "Server shutdown", true);
    }
}
