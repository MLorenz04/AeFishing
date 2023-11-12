package aemmo.aefishing;

import aemmo.aefishing.Items.Ryba;
import aemmo.aefishing.Items.RybaruvPrut;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FishingHandler implements Listener {
    List<ItemStack> list_of_items_common = Arrays.asList(new ItemStack(Material.APPLE),
            new ItemStack(Material.SUSPICIOUS_SAND),
            new ItemStack(Material.SWEET_BERRIES),
            new ItemStack(Material.BONE),
            new ItemStack(Material.QUARTZ));
    List<ItemStack> list_of_items_uncommon = Arrays.asList(
            new ItemStack(Material.BRUSH),
            new ItemStack(Material.RAW_GOLD),
            new ItemStack(Material.RABBIT_FOOT),
            new ItemStack(Material.CHAINMAIL_BOOTS),
            new ItemStack(Material.CHAINMAIL_HELMET),
            new ItemStack(Material.CHAINMAIL_LEGGINGS),
            new ItemStack(Material.CHAINMAIL_CHESTPLATE),
            new ItemStack(Material.HEART_POTTERY_SHERD));
    List<ItemStack> list_of_items_rare = Arrays.asList(
            new ItemStack(Material.AMETHYST_SHARD),
            new ItemStack(Material.BLAZE_ROD),
            new ItemStack(Material.EMERALD),
            new ItemStack(Material.ENDER_EYE),
            new ItemStack(Material.SHULKER_SHELL));

    List<ItemStack> list_of_items_epic = Arrays.asList(
            new ItemStack(Material.NETHERITE_SCRAP),
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 16),
            new ItemStack(Material.LODESTONE),
            new ItemStack(Material.PIGLIN_HEAD),
            new RybaruvPrut(1).getItem());
    List<ItemStack> list_of_items_legendary = Arrays.asList(
            new ItemStack(Material.AXOLOTL_SPAWN_EGG),
            new ItemStack(Material.CAT_SPAWN_EGG),
            new ItemStack(Material.HORSE_SPAWN_EGG),
            new ItemStack(Material.GOAT_SPAWN_EGG),
            new ItemStack(Material.FOX_SPAWN_EGG),
            new ItemStack(Material.LLAMA_SPAWN_EGG));
    Random rand = new Random();
    public FishingHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void onFish(PlayerFishEvent fishEvent) {
        if (fishEvent.getCaught() instanceof Item) {
            int randomChange = rand.nextInt(100) + 1;
            if(randomChange <= 12) {
                Ryba r = new Ryba(1, FishLength());
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(r.getItem());
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi" + ChatColor.DARK_AQUA + " rybu!");
            }
            if(randomChange > 12 && randomChange <=18) {
                ItemStack i = list_of_items_common.get(rand.nextInt(list_of_items_common.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GRAY + " obyčejný poklad!");
            }
            if(randomChange > 18 && randomChange <=22) {
                ItemStack i = list_of_items_uncommon.get(rand.nextInt(list_of_items_uncommon.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GREEN + " neobyčejný poklad!");
            }
            if(randomChange > 22 && randomChange <=24) {
                ItemStack i = list_of_items_rare.get(rand.nextInt(list_of_items_rare.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.AQUA + " vzácný poklad!");
            }
            if(randomChange > 24 && randomChange <=25) {
                ItemStack i = list_of_items_epic.get(rand.nextInt(list_of_items_epic.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.LIGHT_PURPLE + " epický poklad!");
            }
            if(randomChange > 25 && randomChange <=25.5) {
                ItemStack i = list_of_items_legendary.get(rand.nextInt(list_of_items_legendary.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GOLD + " legendární poklad!");
            }
        }
    }

    public double FishLength() {
        double lambda = 1.2D;
        Random random = new Random();
        double x = -Math.log(1.0D - random.nextDouble()) / lambda;
        double cislo = 0.2D + x;
        return cislo;
    }
}