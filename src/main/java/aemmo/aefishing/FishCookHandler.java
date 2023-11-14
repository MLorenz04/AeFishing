package aemmo.aefishing;

import aemmo.aefishing.Items.Chests.Stats;
import aemmo.aefishing.Items.Fishing.Perla;
import aemmo.aefishing.Items.Ryba;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FishCookHandler implements Listener {

    ArrayList<ItemStack> list = new ArrayList<>();

    Random rand = new Random();

    public FishCookHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);

        list.add(new ItemStack(Material.GOLD_INGOT));
        list.add(new ItemStack(Material.IRON_INGOT));
        list.add(new ItemStack(Material.BONE_MEAL));
        list.add(new ItemStack(Material.PRISMARINE_SHARD));
        list.add(new ItemStack(Material.PRISMARINE_CRYSTALS));
        list.add(new ItemStack(Material.WHEAT_SEEDS));
        list.add(new ItemStack(Material.PUMPKIN_SEEDS));
        list.add(new ItemStack(Material.MELON_SEEDS));
        list.add(new ItemStack(Material.BEETROOT_SEEDS));
        list.add(new ItemStack(Material.POTATO));
        list.add(new ItemStack(Material.CARROT));
        list.add(new ItemStack(Material.GOLD_INGOT));
        list.add(new ItemStack(Material.IRON_INGOT));
        list.add(new ItemStack(Material.BONE_MEAL));
        list.add(new ItemStack(Material.PRISMARINE_SHARD));
        list.add(new ItemStack(Material.PRISMARINE_CRYSTALS));
        list.add(new ItemStack(Material.WHEAT_SEEDS));
        list.add(new ItemStack(Material.PUMPKIN_SEEDS));
        list.add(new ItemStack(Material.MELON_SEEDS));
        list.add(new ItemStack(Material.BEETROOT_SEEDS));
        list.add(new ItemStack(Material.POTATO));
        list.add(new ItemStack(Material.CARROT));
        list.add(new ItemStack(Material.GOLD_INGOT));
        list.add(new ItemStack(Material.IRON_INGOT));
        list.add(new ItemStack(Material.BONE_MEAL));
        list.add(new ItemStack(Material.PRISMARINE_SHARD));
        list.add(new ItemStack(Material.PRISMARINE_CRYSTALS));
        list.add(new ItemStack(Material.WHEAT_SEEDS));
        list.add(new ItemStack(Material.PUMPKIN_SEEDS));
        list.add(new ItemStack(Material.MELON_SEEDS));
        list.add(new ItemStack(Material.BEETROOT_SEEDS));
        list.add(new ItemStack(Material.POTATO));
        list.add(new ItemStack(Material.CARROT));
        list.add(new ItemStack(Material.GOLD_INGOT));
        list.add(new ItemStack(Material.IRON_INGOT));
        list.add(new ItemStack(Material.BONE_MEAL));
        list.add(new ItemStack(Material.PRISMARINE_SHARD));
        list.add(new ItemStack(Material.PRISMARINE_CRYSTALS));
        list.add(new ItemStack(Material.WHEAT_SEEDS));
        list.add(new ItemStack(Material.PUMPKIN_SEEDS));
        list.add(new ItemStack(Material.MELON_SEEDS));
        list.add(new ItemStack(Material.BEETROOT_SEEDS));
        list.add(new ItemStack(Material.POTATO));
        list.add(new ItemStack(Material.CARROT));
        list.add(createHealthPotion(PotionType.INSTANT_HEAL, 1));
        list.add(createHealthPotion(PotionType.STRENGTH, 1));
        list.add(createHealthPotion(PotionType.SPEED, 1));
        list.add(createHealthPotion(PotionType.INSTANT_HEAL, 2));
        list.add(createHealthPotion(PotionType.STRENGTH, 2));
        list.add(createHealthPotion(PotionType.SPEED, 2));
        list.add(new Perla(1).getItem());
        list.add(new ItemStack(Material.GOLDEN_APPLE));
    }
    private ItemStack createHealthPotion(PotionType type, int level) {
        Potion potion = new Potion(type,  level);
        ItemStack healthPotion = potion.toItemStack(1);
        return healthPotion;
    }
    @EventHandler
    public void onFishBrew(BlockCookEvent event) {
        ItemStack ingredient = event.getSource();
        Random random = new Random();
        ItemStack randomItem = this.list.get(random.nextInt(this.list.size()));

        if (ingredient != null && ingredient.getType() == Material.COD && ingredient.hasItemMeta() && ingredient.getItemMeta().hasCustomModelData() && ingredient.getItemMeta().getCustomModelData() == 123 && ingredient.getItemMeta().hasDisplayName()) {
                event.setResult(randomItem);
        }
    }
}

