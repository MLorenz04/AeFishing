package aemmo.aefishing;

import aemmo.aefishing.Items.Chests.TrouchnivySud;
import aemmo.aefishing.Items.Chests.TrouchnivySudChest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ChestHandler implements Listener {

    public ChestHandler(Aefishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if (event.getItem() == null)
            return;
        if (!event.getItem().hasItemMeta())
            return;
        if (!event.getItem().getItemMeta().hasCustomModelData())
            return;
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;
        ItemStack item = event.getItem();

        if (item.getItemMeta().getCustomModelData() == 123456 && item.getType() == Material.BARREL)
            TrouchnivySud(event);
    }

    public void TrouchnivySud(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        event.setCancelled(true);

        int count = p.getInventory().getItemInMainHand().getAmount();
        if (count >= 2) {
            ItemStack newItem = (new TrouchnivySud(count - 1)).getItem();
            p.getInventory().setItemInMainHand(newItem);
        } else {
            p.getInventory().setItemInMainHand(null);
        }
        (new TrouchnivySudChest()).getDrop(event.getPlayer());
    }

}
