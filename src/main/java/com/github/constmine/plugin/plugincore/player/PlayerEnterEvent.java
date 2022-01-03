package com.github.constmine.plugin.plugincore.player;

import com.github.constmine.plugin.plugincore.PlayerConfig;
import com.github.constmine.plugin.plugincore.PluginCore;
import com.github.constmine.plugin.plugincore.tools.StringToComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;



public class PlayerEnterEvent extends PlayerSendMessage implements Listener {
    private final PluginCore plugin;

    public PlayerEnterEvent(Plugin plugin) {
        this.plugin = (PluginCore) plugin;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        event.joinMessage(StringToComponent.changeString("§e[" + " §bJoin " + "§e] §r" + playerName));

        /*
        PlayerConfig 클래스에서 플레이어이름으로하는 파일을 생성
        입장횟수를 + 1 하거나 또는 첫접속시에는 Config파일 생성
         */
        PlayerConfig playerConfig = new PlayerConfig(plugin, playerName);
        FileConfiguration config = playerConfig.getConfig();

        if(playerConfig.hasConfig()) {
            config.set("JoinCount", config.getInt("JoinCount") + 1);
            config.set("location.X", player.getLocation().getX());
            config.set("location.Y", player.getLocation().getY());
            config.set("location.Z", player.getLocation().getZ());
            config.set("location.Pitch", player.getLocation().getPitch());
            config.set("location.Yaw", player.getLocation().getYaw());
            playerConfig.saveConfig();
        } else {
            playerConfig.createConfig();
        }


        if(config.getInt("JoinCount") == 10) {
            event.getPlayer().sendMessage("10번 접속하셨습니다!");
        }
    }

}
