package com.itijm.jitselogs;

import com.itijm.jitselogs.Commands.Bump;
import com.itijm.jitselogs.Handlers.Chat;
import com.itijm.jitselogs.Handlers.Join;
import com.itijm.jitselogs.Handlers.Sleep;
import com.itijm.jitselogs.Util.DiscordWebhook;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);
        getServer().getPluginManager().registerEvents(new Sleep(), this);
        this.getCommand("bump").setExecutor(new Bump());
        new DiscordWebhook.EmbedBuilder()
            .setColor(0xE3D4D3)
            .setMessage("Server startup")
            .send();
    }

    @Override
    public void onDisable() {
        new DiscordWebhook.EmbedBuilder()
                .setColor(0xE3D4D3)
                .setMessage("Server shutdown")
                .send();
    }
}
