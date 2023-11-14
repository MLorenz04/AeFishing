package aemmo.aefishing;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Aefishing extends JavaPlugin {

    @Override
    public void onEnable() {
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Bukkit.getLogger().info( "Zapínám! :)");
        new FishingHandler(this);
        new ChestHandler(this);
        PluginCommand command = getCommand("ae_give");
        if (command != null) {
            command.setExecutor(new CommandMenu());
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin down! :(");
    }
}
