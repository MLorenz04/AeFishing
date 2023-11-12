package aemmo.aefishing.Items;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class RybaruvPrut extends ItemHolder {
    public RybaruvPrut(int amount) {
        this.item = new ItemStack(Material.FISHING_ROD, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(net.md_5.bungee.api.ChatColor.RESET + "" + ChatColor.GRAY + "Rybářův prut");
        this.meta.addEnchant(Enchantment.LURE, 2, false);
        this.meta.addEnchant(Enchantment.LUCK, 2, false);
        this.lore.add(net.md_5.bungee.api.ChatColor.WHITE + "Starý a zapomenutý rybářův prut... Třeba ještě poslouží!");
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}