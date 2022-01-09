package com.github.constmine.plugin.plugincore.tools.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigSetting {
    private final File file;
    protected final FileConfiguration config;

    public ConfigSetting(Plugin plugin, String name) {
        file = new File(plugin.getDataFolder(), "/" + name + ".yml");
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

    public static void saveAllConfig(File[] files) {
        for(File file : files) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
