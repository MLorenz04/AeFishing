package aemmo.aefishing.Items;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Ryba extends ItemHolder {
    Random random = new Random();
    List<String> fishes = Arrays.asList("Amur bílý", "Bolen dravý", "Candát obecný", "Cejn siný", "Drsek menší", "Hlavatka mramorovaná", "Hrouzek běloploutvý", "Jelec jesen", "Jeseter malý", "Ježdík žlutý", "Kapr obecný", "Mník jednovousý", "Lipan podhorní", "Parma obecná", "Perlín ostrobřichý", "Pstruh obecný", "Sekavčík horský", "Sumec velký", "Štika obecná", "Vranka obecná", "Vyza velká");
    public Ryba(int amount, double length) {
        DecimalFormat format = new DecimalFormat("#.##");
        DecimalFormat format2 = new DecimalFormat("#.#");
        this.item = new ItemStack(Material.COD, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(ChatColor.RESET + "" + ChatColor.DARK_AQUA + fishes.get(random.nextInt(fishes.size())) + " (" + format.format(length) + "m)");
        this.lore.add(ChatColor.WHITE + "Obyčejná ryba plovoucí v blízkých vodách");
        this.lore.add(ChatColor.WHITE + "Délka: " + format2.format(length * 100) + "cm");
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}