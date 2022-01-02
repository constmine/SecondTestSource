package com.github.constmine.plugin.plugincore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    private final File file;
    private final FileConfiguration config;

    public PlayerConfig(Plugin plugin, String playerName) {
        file = new File(plugin.getDataFolder(), "/" + playerName + ".yml");
        config = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * player의 Config파일을 생성합니다.
     */
    public FileConfiguration createConfig() {
        try {
            if(!file.exists()) {
                setFirstConfig(config);
                config.save(file);
            }
            config.load(file);
        } catch (Exception localException) {
            localException.printStackTrace();
        }

        return config;
    }

    private void setFirstConfig(FileConfiguration config) {
        config.set("setJoinMessage", true);
        config.set("setExitMessage", true);
        config.set("JoinCount", 1);

    }

    public boolean hasConfig() {
        return file.exists();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
