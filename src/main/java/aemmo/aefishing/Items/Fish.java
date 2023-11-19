package aemmo.aefishing.Items;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Fish extends ItemHolder {
    Random random = new Random();
    public static List<FishCategory> fishCategoryList = Arrays.asList(
            /* Kaprovití */
            new FishCategory(Material.COD,"Amur bílý", "Kaprovití"),
            new FishCategory(Material.COD,"Bolen dravý", "Kaprovití"),
            new FishCategory(Material.COD,"Cejn siný", "Kaprovití"),
            new FishCategory(Material.COD,"Ježdík žlutý", "Kaprovití"),
            new FishCategory(Material.COD,"Kapr obecný", "Kaprovití"),
            /* Dravé ryby */
            new FishCategory(Material.SALMON,"Drsek menší", "Dravé ryby"),
            new FishCategory(Material.SALMON,"Okoun říční", "Dravé ryby"),
            new FishCategory(Material.SALMON,"Sumec velký", "Dravé ryby"),
            new FishCategory(Material.SALMON,"Štika obecná", "Dravé ryby"),
            /* Tropické ryby */
            new FishCategory(Material.TROPICAL_FISH,"Bodlok žlutý", "Tropická ryba"),
            new FishCategory(Material.TROPICAL_FISH,"Bojovnice pestrá", "Tropická ryba"),
            new FishCategory(Material.TROPICAL_FISH,"Cichlida papouščí", "Tropická ryba"),
            new FishCategory(Material.TROPICAL_FISH,"Chňapal císařský", "Tropická ryba"),
            new FishCategory(Material.TROPICAL_FISH,"Paví oko", "Tropická ryba"),
            new FishCategory(Material.TROPICAL_FISH,"Tlamovec Johannův", "Tropická ryba"),
            /* Severské ryby */
            new FishCategory(Material.SALMON,"Koruška evropská", "Severské ryby"),
            new FishCategory(Material.SALMON,"Mník jednovousý", "Severské ryby"),
            new FishCategory(Material.SALMON,"Pstruh obecný", "Severské ryby"),
            new FishCategory(Material.SALMON,"Sekavčík horský", "Severské ryby"),
            new FishCategory(Material.SALMON,"Štítník červený", "Severské ryby"),
            /* Mořské ryby */
            new FishCategory(Material.TROPICAL_FISH,"Bodlok bahamský", "Mořské ryby"),
            new FishCategory(Material.TROPICAL_FISH,"Kněžík srpkovitý", "Mořské ryby"),
            new FishCategory(Material.TROPICAL_FISH,"Lodivod mořský", "Mořské ryby"),
            new FishCategory(Material.PUFFERFISH,"Leskyně skvrnitá", "Mořské ryby"),
            new FishCategory(Material.TROPICAL_FISH, "Muréna hvězdovitá", "Mořské ryby"),
            new FishCategory(Material.PUFFERFISH,"Rozedranec skvrnoploutvý", "Mořské ryby"),
            /* Africké ryby */
            new FishCategory(Material.TROPICAL_FISH,"Afrotetra konžská", "Africké ryby"),
            new FishCategory(Material.TROPICAL_FISH,"Latimérie podivná", "Africké ryby"),
            new FishCategory(Material.COD,"Okoun nilský", "Africké ryby"),
            new FishCategory(Material.TROPICAL_FISH,"Tlamovec pestrý", "Africké ryby")



    );

    public static List<FishCategory> getFishCategoryList() {
        return fishCategoryList;
    }

    public static void setFishCategoryList(List<FishCategory> fishCategoryList) {
        Fish.fishCategoryList = fishCategoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Material getType_of_fish() {
        return type_of_fish;
    }

    public void setType_of_fish(Material type_of_fish) {
        this.type_of_fish = type_of_fish;
    }

    public String name;

    public double length;

    public String category;
    public Material type_of_fish;
    public Fish(int amount, double length) {
        this.length = length;
        FishCategory fish = fishCategoryList.get(random.nextInt(fishCategoryList.size()));
        this.type_of_fish = fish.material;
        this.category = fish.category;
        this.name = fish.name;
        DecimalFormat format = new DecimalFormat("#.##");
        DecimalFormat format2 = new DecimalFormat("#.#");
        this.item = new ItemStack(fish.material, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(ChatColor.RESET + "" + ChatColor.DARK_AQUA + fish.name + " (" + format.format(length) + "m)");
        this.lore.add(ChatColor.WHITE + "Obyčejná ryba plovoucí v blízkých vodách");
        this.lore.add(ChatColor.WHITE + fish.category);
        this.lore.add(ChatColor.WHITE + "Délka: " + format2.format(length * 100) + "cm");
        this.meta.setCustomModelData(123);
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public Fish(Material type_of_fish,int amount, double length, String name, String category) {
        this.category = category;
        this.length = length;
        this.name = name;
        this.type_of_fish = type_of_fish;
        DecimalFormat format = new DecimalFormat("#.##");
        DecimalFormat format2 = new DecimalFormat("#.#");
        this.item = new ItemStack(type_of_fish, amount);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(ChatColor.RESET + "" + ChatColor.DARK_AQUA + name + " (" + format.format(length) + "m)");
        this.lore.add(ChatColor.WHITE + "Obyčejná ryba plovoucí v blízkých vodách");
        this.lore.add(ChatColor.WHITE + category);
        this.lore.add(ChatColor.WHITE + "Délka: " + format2.format(length * 100) + "cm");
        this.meta.setCustomModelData(123);
        this.meta.setLore(this.lore);
        this.item.setItemMeta(this.meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}