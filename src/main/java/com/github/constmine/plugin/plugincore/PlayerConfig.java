package com.github.constmine.plugin.plugincore;

import com.github.constmine.plugin.plugincore.tools.config.ConfigSetting;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class PlayerConfig extends ConfigSetting {
    private Player player;

    public PlayerConfig(Plugin plugin, Player player) {
        super(plugin, player.getName());
        this.player = player;
    }

    public void saveLocation() {
        config.set("location.X", player.getLocation().getX());
        config.set("location.Y", player.getLocation().getY());
        config.set("location.Z", player.getLocation().getZ());
        config.set("location.Pitch", player.getLocation().getPitch());
        config.set("location.Yaw", player.getLocation().getYaw());
        saveConfig();
    }

    public void saveIP() {
        config.set("IP", Objects.requireNonNull(Objects.requireNonNull(player.getAddress()).getHostName()));
    }

    /**
     * getConfig.save()로 쓰기 귀찮을 때
     * @param saveName 저장할 이름
     * @param object 저장할 객체
     */
    public void save(String saveName, Object object) {
        config.set(saveName, object);
    }

    /**
     * 이미 객체 생성할때 Player넣었는데 그냥 허전해서 만듦...
     * @return player - player를 반환한다.
     */
    @Deprecated
    public Player getPlayer() {
        return player;
    }
}
