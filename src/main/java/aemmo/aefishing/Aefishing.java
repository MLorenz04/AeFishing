package aemmo.aefishing;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Aefishing extends JavaPlugin {

    @Override
    public void onEnable() {
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Bukkit.getLogger().info( "Zapínám! :)");
        FishingHandler h1 = new FishingHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin down! :(");
    }
}
