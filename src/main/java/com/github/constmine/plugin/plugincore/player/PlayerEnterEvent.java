package com.github.constmine.plugin.plugincore.player;

import com.github.constmine.plugin.plugincore.PlayerConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;



public class PlayerEnterEvent extends PlayerSendMessage implements Listener {
    private final Plugin plugin;

    public PlayerEnterEvent(Plugin plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        event.joinMessage(stringToComponent("§e[" + " §bJoin " + "§e] §r" + playerName));


        /*
        PlayerConfig 클래스에서 플레이어이름으로하는 파일을 생성
        입장횟수를 + 1 하거나 또는 첫접속시에는 Config파일 생성
         */
        PlayerConfig playerConfig = new PlayerConfig(plugin, playerName);
        FileConfiguration config = playerConfig.getConfig();

        if(playerConfig.hasConfig()) {
            config.set("JoinCount", config.getInt("JoinCount") + 1);
            playerConfig.saveConfig();
        } else {
            playerConfig.createConfig();
        }


        if(config.getInt("JoinCount") == 10) {
            event.getPlayer().sendMessage("10번 접속하셨습니다!");
        }
    }

}
