package aemmo.aefishing.Handlers;

import aemmo.aefishing.Aefishing;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CampfireHandler implements Listener {

    public CampfireHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void onInventoryClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.CAMPFIRE && event.getAction().isRightClick()) {
            if (event.getItem() != null && event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasCustomModelData() && event.getItem().getItemMeta().getCustomModelData() == 123 && event.getItem().getItemMeta().hasDisplayName()) {
                int index = 0;
                Campfire campfire = (Campfire) event.getClickedBlock().getState();
                for (int i = 0; i < campfire.getSize(); i++) {
                    if (campfire.getItem(i) != null) {
                        index++;
                    }
                }
                Bukkit.getLogger().info("opravdu funguju" + index);
                event.getPlayer().getInventory().remove(event.getItem());
                campfire.setCookTime(index, 0);
                campfire.setCookTimeTotal(index, 300);
                campfire.setItem(index, event.getItem());
                Bukkit.getLogger().info(campfire.getCookTimeTotal(index) + "");
                campfire.update(true);
            }
        }
    }
}