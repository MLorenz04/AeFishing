package aemmo.aefishing.Handlers;

import aemmo.aefishing.Aefishing;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryHandler implements Listener {

    public InventoryHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() != null && event.getClickedInventory().equals(FishMenuHandler.doubleChestInventory)) {
            event.setCancelled(true);
        }
    }
}