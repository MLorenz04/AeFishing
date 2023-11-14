package aemmo.aefishing.Items.Rods;

import aemmo.aefishing.Items.ItemHolder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class RybaruvPrut extends ItemHolder {
    public RybaruvPrut(int amount) {
        this.item = new ItemStack(Material.FISHING_ROD, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(net.md_5.bungee.api.ChatColor.RESET + "" + net.md_5.bungee.api.ChatColor.of("#964B00") + "Rybářův prut");
        this.meta.addEnchant(Enchantment.LURE, 2, false);
        this.meta.addEnchant(Enchantment.LUCK, 2, false);
        this.lore.add(net.md_5.bungee.api.ChatColor.WHITE + "Starý rybářův prut... Třeba ještě poslouží!");
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}