package com.github.constmine.plugin.plugincore.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Locale;

public class PlayerInvClickEvent implements Listener {


    /*
    나중에 Inventory를
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();

        switch (title.toLowerCase(Locale.ROOT)) {
            case "test" :
            case "현재 플레이어 목록" :
                event.setCancelled(true);
        }
    }
}
