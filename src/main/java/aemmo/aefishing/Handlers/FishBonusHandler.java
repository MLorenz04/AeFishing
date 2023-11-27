package aemmo.aefishing.Handlers;

import aemmo.aefishing.Aefishing;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class FishBonusHandler implements Listener {

    public FishBonusHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory != null && clickedInventory == FishMenuHandler.doubleChestInventory) {
            int clickedSlot = event.getSlot();

            // Kontrola, zda hráč klikl na 8. slot
            if (clickedSlot == 7) {
                Bukkit.getLogger().info("Yesss");
            }
        }
    }
}
