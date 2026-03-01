package com.stormai.plugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    private final FileConfiguration config;

    public ConfigManager(FireMazePlugin plugin) {
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    public double getHeatDamageRate() {
        return config.getDouble("heat-damage-rate", 1.0);
    }

    public int getMobSpawnChance() {
        return config.getInt("mob-spawn-chance", 20);
    }

    public int getFlameWallDuration() {
        return config.getInt("flame-wall-duration", 200);
    }
}