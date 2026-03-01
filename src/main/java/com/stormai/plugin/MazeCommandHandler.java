package com.stormai.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MazeCommandHandler implements CommandExecutor {
    private final FireMazePlugin plugin;

    public MazeCommandHandler(FireMazePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GOLD + "FireMaze Commands:");
            sender.sendMessage(ChatColor.AQUA + "/firemaze start - Enter the Fire Maze");
            sender.sendMessage(ChatColor.AQUA + "/firemaze help - Show help");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                player.sendMessage(ChatColor.GREEN + "Teleporting to Fire Maze...");
                plugin.getMazeManager().teleportPlayerToMaze(player);
                break;
            case "help":
                sender.sendMessage(ChatColor.GOLD + "FireMaze Help:");
                sender.sendMessage(ChatColor.AQUA + "Survive the heat, avoid lava traps, and defeat fire mobs!");
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Unknown command. Use /firemaze help for help.");
        }

        return true;
    }
}