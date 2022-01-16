package com.github.constmine.plugin.plugincore;

import com.github.constmine.plugin.plugincore.commands.PlayerList;
import com.github.constmine.plugin.plugincore.commands.openInv;
import com.github.constmine.plugin.plugincore.player.PlayerEnterEvent;
import com.github.constmine.plugin.plugincore.player.PlayerExitEvent;
import com.github.constmine.plugin.plugincore.tools.config.ConfigSetting;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class PluginCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§bPlugin Loading!");

        registerCommmand("openInv", new openInv());
        registerCommmand("playerList", new PlayerList());

        registerEvent(new PlayerEnterEvent(this));
        registerEvent(new PlayerExitEvent());
    }

    @Override
    public void onDisable() {
        getLogger().info("§5Plugin Unloading.");

        ConfigSetting.saveAllConfig(Objects.requireNonNull(this.getDataFolder().listFiles()));
    }

    /*
    Todo
    지네릭스로 표현하기
     */
    public void registerEvent(Listener object) {
        getServer().getPluginManager().registerEvents(object, this);
    }

    public void registerCommmand(String commandName, CommandExecutor command) {
        Objects.requireNonNull(getCommand(commandName)).setExecutor(command);
    }

}
