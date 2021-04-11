package com.itijm.jitselogs.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bump implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bump")) {
            Player player;
            if (args[0] != null) {
                player = Bukkit.getPlayer(args[0]);

            } else {
                player = (Player) sender;

            }

            player.setVelocity(player.getLocation().getDirection().multiply(Double.parseDouble(args[1])));
            player.setVelocity(player.getLocation().getDirection().setY(Double.parseDouble(args[2])));

        }

        return true;
    }
}
