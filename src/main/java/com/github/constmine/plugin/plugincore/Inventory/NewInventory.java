package com.github.constmine.plugin.plugincore.Inventory;

import com.github.constmine.plugin.plugincore.tools.StringToComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NewInventory {
    private final Inventory inv;

    /*
     * 생성자를 호출하면서 새로운 인벤토리 생성
     * size값을 8이하 또는 55 이상으로 설정시에 예외 발생.
     */
    public NewInventory(int size, String InventoryName) {
//        if(size < 9 || size > 54) {
//            Bukkit.getLogger().info("§c인벤토리의 최소 크기는 9 이상 54 이하 입니다.");
//            inv = Bukkit.createInventory(null, 9, StringToComponent.changeString(InventoryName));
//        } else {
            inv = Bukkit.createInventory(null, size, StringToComponent.changeString(InventoryName));
//        }
    }

    public Inventory getInv() {
        return inv;
    }

    /*
     * index 값은 0보다 크고 inv의 size값에 -1한 것보다 작아야 한다.
     */
    public void setItemInventory(int index, ItemStack itemStack) {
//        if(inv.getSize() > index + 1) {
            inv.setItem(index, itemStack);
//        }
    }
}
