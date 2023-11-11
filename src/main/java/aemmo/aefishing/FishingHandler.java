package aemmo.aefishing;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.Bukkit;

public class FishingHandler implements Listener {
    public FishingHandler(AeFishing a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void fishCaughtEvent(PlayerFishEvent event) {

        if(!event.getPlayer().hasPlayedBefore()) {
            Player p = event.getPlayer();
        }
    }
}