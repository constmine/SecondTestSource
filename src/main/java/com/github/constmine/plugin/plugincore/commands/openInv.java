package com.github.constmine.plugin.plugincore.commands;

import com.github.constmine.plugin.plugincore.Inventory.NewInventory;
import com.github.constmine.plugin.plugincore.tools.CreateItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class openInv implements CommandExecutor, TabExecutor {
    /*
    Todo
    커맨드 입력 후
    플레이어에게 새로운 인벤토리 창을 보여줌.
    이를 위해 새로운 인벤토리 클래스를 만들어서
    클래스를 새롭게 만듦.
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        NewInventory inv = new NewInventory(9, "Test");
        inv.setItemInventory(2, CreateItem.makeItem(Material.GRASS_BLOCK, "잔디 블럭 그 자체"));
        player.openInventory(inv.getInv());

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        return null;
    }
}
