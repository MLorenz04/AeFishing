package aemmo.aefishing.Items.Chests;

import aemmo.aefishing.Items.ItemHolder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TrouchnivySud extends ItemHolder {
    public TrouchnivySud(int amount) {
        this.item = new ItemStack(Material.BARREL, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(ChatColor.RESET + "" + net.md_5.bungee.api.ChatColor.of("#964B00") + "Trouchnivý sud");
        this.lore.add(ChatColor.WHITE + "Neznámý barel plovoucí místníi vodami");
        this.lore.add(ChatColor.WHITE + "Klikni pravým pro použití!");
        this.meta.setLore(this.lore);
        this.meta.setCustomModelData(123456);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}

