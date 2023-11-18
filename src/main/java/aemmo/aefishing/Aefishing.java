package aemmo.aefishing;

import aemmo.aefishing.CommandExecutors.CommandMenu;
import aemmo.aefishing.Handlers.*;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Aefishing extends JavaPlugin {

    @Override
    public void onEnable() {
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Bukkit.getLogger().info( "Zapínám! :)");
        new FishingHandler(this);
        new ChestListener(this);
        new FishCookHandler(this);
        new FirstJoinHandler(this);
        new InventoryHandler(this);
        PluginCommand command = getCommand("ae_give");
        PluginCommand command2 = getCommand("fish");

        if (command != null)
            command.setExecutor(new CommandMenu());

        if(command2 != null)
            command2.setExecutor(new FishMenuHandler());

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin down! :(");
    }
}
