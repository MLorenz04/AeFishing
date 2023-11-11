package aemmo.aefishing;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Properties;

public final class AeFishing extends JavaPlugin {

    @Override
    public void onEnable() {
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Bukkit.getLogger().info( "Zapínám! :)");
        FishingHandler h1 = new FishingHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
