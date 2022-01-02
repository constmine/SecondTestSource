package com.github.constmine.plugin.plugincore.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerExitEvent extends PlayerSendMessage implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.quitMessage(stringToComponent("§e[" + " §cQuit " + "§e] §r" + event.getPlayer().getName()));
    }
}
