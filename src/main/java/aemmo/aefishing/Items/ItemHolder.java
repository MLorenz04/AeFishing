package aemmo.aefishing.Items;


 import java.util.ArrayList;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 public class ItemHolder
         {
       public ItemStack item;
       public ItemMeta meta;
      public ArrayList<String> lore = new ArrayList<>();

       public ItemStack getItem() {
             return this.item;
           }

       public ItemMeta getMeta() {
             return this.meta;
           }

       public void setMeta(ItemMeta meta) {
             this.meta = meta;
           }

       public ArrayList<String> getLore() {
             return this.lore;
           }

       public void setLore(ArrayList<String> lore) {
             this.lore = lore;
           }

       public void setItem(ItemStack item) {
        this.item = item;
           }
     }
