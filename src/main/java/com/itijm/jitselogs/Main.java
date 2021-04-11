package com.itijm.jitselogs;

import com.itijm.jitselogs.Handlers.Join;
import com.itijm.jitselogs.Util.DiscordWebhook;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Join(), this);
        DiscordWebhook.send(0x3deb34, "Server startup", false);
    }

    @Override
    public void onDisable() {
        DiscordWebhook.send(0xed1a28, "Server shutdown", true);
    }
}
