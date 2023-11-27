package aemmo.aefishing.Handlers;

import aemmo.aefishing.Aefishing;
import aemmo.aefishing.CommandExecutors.SingleFishForMenu;
import aemmo.aefishing.Items.Chests.TrouchnivySud;
import aemmo.aefishing.Items.Fish;
import aemmo.aefishing.Items.Rods.RybaruvPrut;
import aemmo.aefishing.Properties;
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
            new ItemStack(Material.WHEAT, 4),
            new ItemStack(Material.SWEET_BERRIES),
            new ItemStack(Material.BONE),
            new ItemStack(Material.SEAGRASS),
            new ItemStack(Material.SEA_PICKLE),
            new ItemStack(Material.QUARTZ));
    List<ItemStack> list_of_items_uncommon = Arrays.asList(
            new ItemStack(Material.BUBBLE_CORAL_FAN),
            new ItemStack(Material.BRAIN_CORAL_FAN),
            new ItemStack(Material.FIRE_CORAL_FAN),
            new ItemStack(Material.HORN_CORAL_FAN),
            new ItemStack(Material.TUBE_CORAL_FAN),
            new ItemStack(Material.BUBBLE_CORAL_BLOCK),
            new ItemStack(Material.BRAIN_CORAL_BLOCK),
            new ItemStack(Material.FIRE_CORAL_BLOCK),
            new ItemStack(Material.HORN_CORAL_BLOCK),
            new ItemStack(Material.TUBE_CORAL_BLOCK),
            new ItemStack(Material.BRUSH),
            new ItemStack(Material.RAW_GOLD),
            new ItemStack(Material.RABBIT_FOOT),
            new ItemStack(Material.CHAINMAIL_BOOTS),
            new ItemStack(Material.CHAINMAIL_HELMET),
            new ItemStack(Material.CHAINMAIL_LEGGINGS),
            new ItemStack(Material.CHAINMAIL_CHESTPLATE),
            new ItemStack(Material.HEART_POTTERY_SHERD),
            new ItemStack(Material.TROPICAL_FISH_BUCKET),
            new RybaruvPrut(1).getItem(),
            new TrouchnivySud(1).getItem());
    List<ItemStack> list_of_items_rare = Arrays.asList(
            new ItemStack(Material.AMETHYST_SHARD),
            new ItemStack(Material.BLAZE_ROD),
            new ItemStack(Material.EMERALD),
            new ItemStack(Material.ENDER_EYE),
            new ItemStack(Material.SHULKER_SHELL),
            new TrouchnivySud(1).getItem());

    List<ItemStack> list_of_items_epic = Arrays.asList(
            new ItemStack(Material.NETHERITE_SCRAP),
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 16),
            new ItemStack(Material.LODESTONE),
            new ItemStack(Material.PIGLIN_HEAD),
            new ItemStack(Material.HEART_OF_THE_SEA));
    List<ItemStack> list_of_items_legendary = Arrays.asList(
            new ItemStack(Material.AXOLOTL_SPAWN_EGG),
            new ItemStack(Material.CAT_SPAWN_EGG),
            new ItemStack(Material.CAT_SPAWN_EGG),
            new ItemStack(Material.HORSE_SPAWN_EGG),
            new ItemStack(Material.GOAT_SPAWN_EGG),
            new ItemStack(Material.FOX_SPAWN_EGG),
            new ItemStack(Material.PIG_SPAWN_EGG),
            new ItemStack(Material.LLAMA_SPAWN_EGG),
            new ItemStack(Material.SHEEP_SPAWN_EGG),
            new ItemStack(Material.COW_SPAWN_EGG),
            new ItemStack(Material.CAMEL_SPAWN_EGG));
    Random rand = new Random();
    public FishingHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void onFish(PlayerFishEvent fishEvent) {
        if (fishEvent.getCaught() instanceof Item) {
            int randomChange = rand.nextInt(120) + 1;
            if(randomChange <= 6) {
                Fish r = new Fish(1, FishLength());
                List<SingleFishForMenu> list = SerializationHandler.deserializeFishes(Properties.path_users + fishEvent.getPlayer().getUniqueId() + ".yaml");

                list.stream()
                        .filter(ryba -> r.name.equals(ryba.getName()))
                        .findFirst()
                        .ifPresent(ryba -> {
                            if( r.length > ryba.getMax_length()) {
                                ryba.setMaterial(r.getType_of_fish());
                                ryba.setCategory(r.getCategory());
                                ryba.setMax_length(r.getLength());
                            }
                        });

                SerializationHandler.serializeFishes(list, Properties.path_users + fishEvent.getPlayer().getUniqueId() + ".yaml");

                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(r.getItem());
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi" + ChatColor.DARK_AQUA + " rybu!");
            }
            if(randomChange > 8 && randomChange <=13) {
                ItemStack i = list_of_items_common.get(rand.nextInt(list_of_items_common.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GRAY + " obyčejný poklad!");
            }
            if(randomChange > 13 && randomChange <=17) {
                ItemStack i = list_of_items_uncommon.get(rand.nextInt(list_of_items_uncommon.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GREEN + " neobyčejný poklad!");
            }
            if(randomChange > 17 && randomChange <=20) {
                ItemStack i = list_of_items_rare.get(rand.nextInt(list_of_items_rare.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.AQUA + " vzácný poklad!");
            }
            if(randomChange > 20 && randomChange <=22) {
                ItemStack i = list_of_items_epic.get(rand.nextInt(list_of_items_epic.size()));
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.LIGHT_PURPLE + " epický poklad!");
            }
            if(randomChange > 22 && randomChange <=23) {
                ItemStack i = list_of_items_legendary.get(rand.nextInt(list_of_items_legendary.size()));
                Bukkit.broadcastMessage(fishEvent.getPlayer().getName() + " ulovil/a" + ChatColor.GOLD + " legendární" + ChatColor.RESET + " poklad!");
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).getInventory().addItem(i);
                Bukkit.getPlayer(fishEvent.getPlayer().getUniqueId()).sendMessage("Ulovil jsi " + ChatColor.GOLD + " legendární poklad!");
            }
        }
    }

    public double FishLength() {
        double lambda = 3.7D;
        Random random = new Random();
        double x = -Math.log(1.0D - random.nextDouble()) / lambda;
        double cislo = x;
        if(cislo > 1) cislo = 1;
        return cislo;
    }
}