/*    */ package aemmo.aefishing;
/*    */
/*    */ import java.util.Set;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.permissions.PermissionAttachmentInfo;
/*    */
/*    */
public class Properties
         {

 public static String sberatel = ChatColor.DARK_AQUA + "Sběratelské";
    /* 28 */   public static String mineral = ChatColor.AQUA + "Minerál";
    /* 29 */   public static String pouzitelne = ChatColor.LIGHT_PURPLE + "Aktivovatelné";
    /*    */
    /* 31 */   public static String brneni = ChatColor.GREEN + "Brnění";
    /* 32 */   public static String platidlo = ChatColor.GOLD + "Platidlo";
    /* 33 */   public static String esence = ChatColor.of("#ad0e70") + "Esence";
    /* 34 */   public static String prsten = ChatColor.DARK_PURPLE + "Prsten";
    /* 35 */   public static String key = ChatColor.of("#2af5a7") + "Klíč";
    /*    */
    /* 37 */   public static String material = ChatColor.of("#c27b2b") + "Materiál";
    /* 38 */   public static String ryba = ChatColor.of("#4f90d6") + "Ryba";
    /* 39 */   public static String tools = ChatColor.of("#1ed497") + "Nástroj";
    /* 40 */   public static String weapon = ChatColor.of("#ab3232") + "Zbraň";
    /* 41 */   public static String prefix = "[AEMMO] ";
    /*    */
    /* 43 */   public static String path_config = "plugins/AeFishing/configs/";
    /*    */
    /* 45 */   public static String path_skills = "plugins/AeFishing/skills/";
    /* 46 */   public static String path_users = "plugins/AeFishing/users/";
    /* 47 */   public static String path_chests = "plugins/AeFishing/chests/";
    /* 48 */   public static String header = "-=-=-=-=-=-=- AEMMO -=-=-=-=-=-=-";
    /* 49 */   public static String divider = "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-";
    /*    */
    /*    */   public static boolean havePermission(String s, Player p) {
        /* 52 */     boolean perm = false;
        /* 53 */     Set<PermissionAttachmentInfo> permissions = p.getEffectivePermissions();
        /*    */
        /* 55 */     for (PermissionAttachmentInfo permission : permissions) {
            /* 56 */       String permissionName = permission.getPermission();
            /* 57 */       if (permissionName.equals(s)) {
                /* 58 */         perm = true;
                /*    */       }
            /*    */     }
        /* 61 */     return perm;
        /*    */   }
    /*    */
    /*    */   public static String numberToRoman(int number) {
        /* 65 */     switch (number) {
            /*    */       case 1:
                /* 67 */         return "I";
            /*    */       case 2:
                /* 69 */         return "II";
            /*    */       case 3:
                /* 71 */         return "III";
            /*    */       case 4:
                /* 73 */         return "IV";
            /*    */       case 5:
                /* 75 */         return "V";
            /*    */       case 6:
                /* 77 */         return "VI";
            /*    */       case 7:
                /* 79 */         return "VII";
            /*    */       case 8:
                /* 81 */         return "VIII";
            /*    */       case 9:
                /* 83 */         return "IX";
            /*    */       case 10:
                /* 85 */         return "X";
            /*    */     }
        /* 87 */     return "";
        /*    */   }
    /*    */   public static boolean checkCustomItem(ItemStack i) {
        /* 90 */     if (!i.hasItemMeta())
            /* 91 */       return false;
        /* 92 */     if (!i.getItemMeta().hasCustomModelData())
            /* 93 */       return false;
        /* 94 */     if (!i.getItemMeta().hasLore())
            /* 95 */       return false;
        /* 96 */     return true;
        /*    */   }
    /*    */ }


/* Location:              C:\Users\matya\Documents\Aeternias.jar!\aeternias\aeternias\classes\Properties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */