package com.github.constmine.plugin.plugincore.tools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class CreateItem {

    /*
    생성자로 호출을 막기 위함
     */
    private CreateItem() {}

    public static ItemStack makeItem(Material material, String displayName) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(StringToComponent.changeString(displayName));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack makeItem(Material material, String displayName, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(StringToComponent.changeString(displayName));
        itemMeta.lore(StringToComponent.changeStringList(lore));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
