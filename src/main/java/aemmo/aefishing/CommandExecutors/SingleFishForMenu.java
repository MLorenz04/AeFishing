package aemmo.aefishing.CommandExecutors;

import aemmo.aefishing.Items.Fish;
import org.bukkit.Material;

public class SingleFishForMenu {

     private String name;

     private Material material;
     private double max_length;
     private String category;

     public SingleFishForMenu(Material material, String name, String category, float max_length) {
          this.material = material;
          this.name = name;
          this.max_length = max_length;
          this.category = category;
     }

     public SingleFishForMenu(Fish f) {
          this.material = f.type_of_fish;
          this.name = f.name;
          this.max_length = max_length;
          this.category = category;
     }

     public SingleFishForMenu() {

     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public double getMax_length() {
          return max_length;
     }

     public void setMax_length(double max_length) {
          this.max_length = max_length;
     }

     public String getCategory() {
          return category;
     }

     public void setCategory(String category) {
          this.category = category;
     }

     public Material getMaterial() {
          return material;
     }

     public void setMaterial(Material material) {
          this.material = material;
     }


}
