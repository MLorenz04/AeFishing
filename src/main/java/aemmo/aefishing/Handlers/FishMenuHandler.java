package aemmo.aefishing.Handlers;

import aemmo.aefishing.Items.Fish;
import aemmo.aefishing.Properties;
import aemmo.aefishing.CommandExecutors.SingleFishForMenu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishMenuHandler implements CommandExecutor {

    public static Inventory doubleChestInventory;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            List<SingleFishForMenu> list = SerializationHandler.deserializeFishes(Properties.path_users + ((Player) sender).getUniqueId() + ".yaml");


            Player player = (Player) sender;

            Map<String, List<SingleFishForMenu>> categorizedFish = new HashMap<>();

            for (SingleFishForMenu fish : list) {
                categorizedFish.computeIfAbsent(fish.getCategory(), k -> new ArrayList<>()).add(fish);
            }

            doubleChestInventory = Bukkit.getServer().createInventory(null, 54, "Prázdný doublechest");
            int start_index = 0;
            int[] list_of_indexes = {0, 9, 18, 27, 36, 45};

            for (Map.Entry<String, List<SingleFishForMenu>> entry : categorizedFish.entrySet()) {
                int index = list_of_indexes[start_index];
                String category = entry.getKey();
                List<SingleFishForMenu> categoryFish = entry.getValue();

                ItemStack categoryItem = new ItemStack(Material.NAME_TAG);
                ItemMeta categoryMeta = categoryItem.getItemMeta();
                categoryMeta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.AQUA + category);
                categoryItem.setItemMeta(categoryMeta);

                doubleChestInventory.setItem(index, categoryItem);
                index++;

                for (SingleFishForMenu fish : categoryFish) {
                    if(fish.getMax_length() > 0) {
                        Fish f = new Fish(fish.getMaterial(), 1, fish.getMax_length(), fish.getName(), fish.getCategory());

                        ItemStack fishItem = f.getItem();
                        doubleChestInventory.setItem(index, fishItem);

                    } else {
                        ItemStack unknown = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                        ItemMeta meta = unknown.getItemMeta();

                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.WHITE + "Tato ryba stále čeká na objevení!");

                        meta.setLore(lore);
                        unknown.setItemMeta(meta);

                        doubleChestInventory.setItem(index, unknown);
                    }
                    index++;
                }
                start_index++;
            }

            player.openInventory(doubleChestInventory);

        }
        return true;
    }

}