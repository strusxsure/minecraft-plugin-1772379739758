package com.stormai.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class FireMazePlugin extends JavaPlugin {
    private MazeManager mazeManager;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        mazeManager = new MazeManager(this);
        configManager = new ConfigManager(this);
        getLogger().info("FireMaze Plugin enabled!");
        getCommand("firemaze").setExecutor(new MazeCommandHandler(this));
        getServer().getPluginManager().registerEvents(new MazeEventListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("FireMaze Plugin disabled!");
    }

    public MazeManager getMazeManager() {
        return mazeManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}