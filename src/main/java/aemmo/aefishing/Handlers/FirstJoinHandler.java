 package aemmo.aefishing.Handlers;

import aemmo.aefishing.Aefishing;
import aemmo.aefishing.Items.Fish;
 import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
 import java.util.List;

import aemmo.aefishing.Properties;
import aemmo.aefishing.CommandExecutors.SingleFishForMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerJoinEvent;
 import org.bukkit.plugin.Plugin;

 public class FirstJoinHandler implements Listener {
       public FirstJoinHandler(Aefishing a1) {
             Bukkit.getPluginManager().registerEvents(this, (Plugin)a1);
       }


       @EventHandler
       public void PlayerJoin(PlayerJoinEvent event) throws IOException {
           File f1 = new File(Properties.path_users + event.getPlayer().getUniqueId() + ".yaml");
           if (f1.exists()) return;

           Player p = event.getPlayer();
           List<SingleFishForMenu> list = new ArrayList<>();

            for(int i = 0; i< Fish.fishCategoryList.size(); i++) {
                list.add(new SingleFishForMenu(Fish.fishCategoryList.get(i).material, Fish.fishCategoryList.get(i).name, Fish.fishCategoryList.get(i).category, 0.00f));
            }
            SerializationHandler.serializeFishes(list, Properties.path_users + p.getPlayer().getUniqueId() + ".yaml");
       }
 }


/* Location:              C:\Users\matya\Documents\Aeternias.jar!\aeternias\aeternias\handlers\FirstJoinHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */