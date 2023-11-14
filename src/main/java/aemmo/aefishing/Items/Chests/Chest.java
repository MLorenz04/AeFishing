
package aemmo.aefishing.Items.Chests;


import java.util.HashMap;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Chest {
    public HashMap<Object, Stats> list;
    Random rand = new Random();

    public void getDrop(Player p) {
        p.sendMessage(org.bukkit.ChatColor.WHITE + "Otevíráš " + net.md_5.bungee.api.ChatColor.of("#964B00") + "trouchnivý barel!");
        this.list.forEach((item, stat) -> {
            int random = rand.nextInt(100) + 1;
            if(random < stat.getChance()) {
                ItemStack finalItem = ((ItemStack) item);
                finalItem.setAmount(rand.nextInt(stat.getMaxAmount() + 1 - stat.getMinAmount()) + stat.getMinAmount());
                p.getInventory().addItem(finalItem);
            }
        });
    }
}