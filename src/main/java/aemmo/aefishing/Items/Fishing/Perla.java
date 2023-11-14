package aemmo.aefishing.Items.Fishing;

import aemmo.aefishing.Items.ItemHolder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Perla extends ItemHolder {
    public Perla(int amount) {
        this.item = new ItemStack(Material.SNOWBALL, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "Perla");
        this.lore.add(ChatColor.WHITE + "Velice vzácná perla do sbírky!");
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}