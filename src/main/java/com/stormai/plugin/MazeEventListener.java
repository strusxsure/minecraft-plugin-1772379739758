package com.stormai.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class MazeEventListener implements Listener {
    private final FireMazePlugin plugin;

    public MazeEventListener(FireMazePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!plugin.getMazeManager().isInMaze(player.getLocation())) {
            return;
        }

        // Apply heat damage over time
        new BukkitRunnable() {
            int timer = 0;
            @Override
            public void run() {
                if (!player.isOnline() || !plugin.getMazeManager().isInMaze(player.getLocation())) {
                    cancel();
                    return;
                }

                timer++;
                if (timer % 60 == 0) { // Every 3 seconds (20 ticks * 60)
                    player.damage(plugin.getConfigManager().getHeatDamageRate());
                    player.setFireTicks(60);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 60, 1));
                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.PHYSICAL) return;

        Block block = event.getClickedBlock();
        if (block == null || block.getType() != Material.STONE_PRESSURE_PLATE) return;

        Player player = event.getPlayer();
        if (!plugin.getMazeManager().isInMaze(player.getLocation())) return;

        // Trigger lava trap
        Location loc = block.getLocation().add(0, -1, 0);
        loc.getBlock().setType(Material.LAVA);
        player.sendMessage(ChatColor.RED + "A lava trap was triggered beneath you!");

        // Spawn fire mob
        loc.getWorld().spawnEntity(loc.add(0, 1, 0), EntityType.BLAZE);
    }
}