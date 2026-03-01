# FireMaze Plugin

A Minecraft Spigot plugin for a challenging fire-themed maze experience.

## Features

- **Heat Damage System**: Players take continuous damage while in the maze
- **Lava Traps**: Pressure plates trigger lava beneath players
- **Fire Mob Spawns**: Blazes spawn at trap locations
- **Timed Flame Walls**: Configurable flame wall sections
- **Configurable Settings**: Adjustable damage rates and spawn chances

## Installation

1. Build the plugin using Maven: `mvn clean package`
2. Copy the generated JAR from `target/FireMazePlugin-1.0.jar` to your server's `plugins` folder
3. Restart your Spigot/Paper server

## Commands

- `/firemaze start` - Teleport to the Fire Maze
- `/firemaze help` - Show help information

## Configuration

Edit `plugins/FireMazePlugin/config.yml` to adjust:
- `heat-damage-rate`: Damage per interval (default: 1.0)
- `mob-spawn-chance`: Percentage chance for mob spawns (default: 20)
- `flame-wall-duration`: Duration of flame walls in ticks (default: 200)