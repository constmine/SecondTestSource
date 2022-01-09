package com.github.constmine.plugin.plugincore.player;

import com.github.constmine.plugin.plugincore.PlayerConfig;
import com.github.constmine.plugin.plugincore.PluginCore;
import com.github.constmine.plugin.plugincore.tools.StringToComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;



public class PlayerEnterEvent implements Listener {
    private final PluginCore plugin;

    public PlayerEnterEvent(Plugin plugin) {
        this.plugin = (PluginCore) plugin;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        event.joinMessage(Component.text(""));
//        event.joinMessage(StringToComponent.changeString(
//                        "§e[" + " §bJoin " + "§e] §r" + playerName
//                )
//        );

        Component JoinMessage = StringToComponent.changeString("§e[" + " §bJoin " + "§e] §r" + playerName);

        /*
        PlayerConfig 클래스에서 플레이어이름으로하는 파일을 생성
        입장횟수를 + 1 하거나 또는 첫접속시에는 Config파일 생성
         */
        PlayerConfig playerConfig = new PlayerConfig(plugin, player);
        FileConfiguration config = playerConfig.getConfig();
        if(playerConfig.hasConfig()) {
            config.set("JoinCount", config.getInt("JoinCount") + 1);
            playerConfig.saveIP();
            playerConfig.saveLocation();

        } else {
            playerConfig.createConfig();
        }

        Bukkit.broadcast(JoinMessage.hoverEvent(HoverEvent.showText(
                Component.text(
                         "§a"+ playerName + "§f님은 §e" + config.getInt("JoinCount") + "§f번 서버에 들어오셨습니다!"
        ))));



        if(config.getInt("JoinCount") == 10) {
            event.getPlayer().sendMessage("10번 접속하셨습니다!");
        }
    }

}
