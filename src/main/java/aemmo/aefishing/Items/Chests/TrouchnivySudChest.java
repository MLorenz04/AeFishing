package aemmo.aefishing.Items.Chests;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class TrouchnivySudChest extends Chest {
    public TrouchnivySudChest() {
        this.list = new HashMap<>();
        this.list.put(new ItemStack(Material.COD), new Stats(3, 8, 80D));
        this.list.put(new ItemStack(Material.VINE), new Stats(2, 6, 55D));
        this.list.put(new ItemStack(Material.NAUTILUS_SHELL), new Stats(1, 1, 15D));
        this.list.put(new ItemStack(Material.RABBIT_HIDE), new Stats(1, 2, 10.0D));
        this.list.put(new ItemStack(Material.INK_SAC), new Stats(1, 2, 25.0D));
        this.list.put(new ItemStack(Material.SCUTE), new Stats(1, 1, 10.0D));
        this.list.put(new ItemStack(Material.WHEAT), new Stats(3, 10, 35.0D));
        this.list.put(new ItemStack(Material.DIAMOND), new Stats(1, 1, 5D));
        this.list.put(new ItemStack(Material.DIAMOND_SWORD), new Stats(1, 1, 2D));
        this.list.put(new ItemStack(Material.EMERALD), new Stats(1, 2, 15.0D));
    }
}