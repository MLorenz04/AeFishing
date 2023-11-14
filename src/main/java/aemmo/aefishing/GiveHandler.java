package aemmo.aefishing;

import aemmo.aefishing.Items.Chests.TrouchnivySud;
import aemmo.aefishing.Items.Fishing.Perla;
import aemmo.aefishing.Items.Rods.RybaruvPrut;
import aemmo.aefishing.Items.Rods.ZapomenutyPrut;
import aemmo.aefishing.Items.Ryba;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GiveHandler {
    static HashMap<String, ItemStack> list = new HashMap<>();
      public static void handleGive(String[] args, CommandSender sender) {
          list.put("trouchnivy_sud", (new TrouchnivySud(1)).getItem());
          list.put("zapomenuty_prut", (new ZapomenutyPrut(1)).getItem());
          list.put("rybaruv_prut", (new RybaruvPrut(1)).getItem());
          list.put("perla", (new Perla(1)).getItem());
           if (args.length == 3) {
                 ItemStack i = list.get(args[1].toLowerCase());
                   int val = Integer.valueOf(args[2]).intValue();
                   i.setAmount(val);
                   Bukkit.getPlayer(args[0]).getInventory().addItem(i);
                 } else {
                 sender.sendMessage("Neplatný příkaz");
              }
          list.clear();
         }
     }

