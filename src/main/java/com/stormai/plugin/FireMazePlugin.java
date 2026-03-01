package com.stormai.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class FireMazePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("FireMaze Plugin enabled!");
        getCommand("firemaze").setExecutor(new MazeCommandHandler(this));
        getServer().getPluginManager().registerEvents(new MazeEventListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("FireMaze Plugin disabled!");
    }
}