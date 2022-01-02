package com.github.constmine.plugin.plugincore;

import com.github.constmine.plugin.plugincore.player.PlayerEnterEvent;
import com.github.constmine.plugin.plugincore.player.PlayerExitEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvent(new PlayerEnterEvent(this));
        registerEvent(new PlayerExitEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    /*
    Todo
    지네릭스로 표현하기
     */
    public void registerEvent(Listener object) {
        getServer().getPluginManager().registerEvents(object, this);
    }


}
