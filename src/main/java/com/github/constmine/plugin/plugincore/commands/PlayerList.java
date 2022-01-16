package com.github.constmine.plugin.plugincore.commands;

import com.github.constmine.plugin.plugincore.Inventory.NewInventory;
import com.github.constmine.plugin.plugincore.tools.StringToComponent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlayerList implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        NewInventory inventory = new NewInventory(54, "현재 플레이어 목록");

        if(isPlayerFlow(player)) {
            for (Player p : player.getServer().getOnlinePlayers()) {
                inventory.getInv().addItem(getPlayerHead(p.getName()));
            }
        }

        player.openInventory(inventory.getInv());

        return false;
    }

    public boolean isPlayerFlow(Player player) {
        return player.getServer().getOnlinePlayers().size() > 0 && player.getServer().getOnlinePlayers().size() < 54;
    }

    public ItemStack getPlayerHead(String playerName) {
        boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
        Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type, 1);

        if(!isNewVersion) {
            item.setDurability((short) 3);
        }

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(playerName);
        meta.displayName(StringToComponent.changeString(meta.getOwner()));
        item.setItemMeta(meta);

        return item;
    }
}
