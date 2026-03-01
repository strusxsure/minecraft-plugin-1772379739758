package com.stormai.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class MazeManager {
    private final FireMazePlugin plugin;
    private final Location mazeCenter;
    private final int mazeRadius;

    public MazeManager(FireMazePlugin plugin) {
        this.plugin = plugin;
        this.mazeCenter = new Location(plugin.getServer().getWorlds().get(0), 100, 60, 100);
        this.mazeRadius = 50;
    }

    public boolean isInMaze(Location location) {
        return location.getWorld().equals(mazeCenter.getWorld()) &&
               location.distance(mazeCenter) <= mazeRadius;
    }

    public void teleportPlayerToMaze(Player player) {
        World world = mazeCenter.getWorld();
        Location spawnPoint = mazeCenter.clone().add(0, 5, 0);
        player.teleport(spawnPoint);
    }

    public void createFlameWall(Block centerBlock) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                Block flameBlock = centerBlock.getRelative(x, 0, z);
                if (flameBlock.getType() == Material.AIR) {
                    flameBlock.setType(Material.FIRE);
                }
            }
        }
    }
}