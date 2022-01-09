package com.github.constmine.plugin.plugincore.player;

import com.github.constmine.plugin.plugincore.tools.StringToComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerExitEvent implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.quitMessage(StringToComponent.changeString("§e[" + " §cQuit " + "§e] §r" + event.getPlayer().getName()));
    }
}
