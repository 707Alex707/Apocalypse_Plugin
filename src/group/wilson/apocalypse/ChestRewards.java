package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s201021621 on 2016-11-30.
 */
public class ChestRewards implements Listener {

    main configGetter;

    public ChestRewards(main plugin) {
        this.configGetter = plugin;
    }


    @EventHandler
    public void catchChestOpen(PlayerInteractEvent event) {

        Entity p = event.getPlayer();
        Player player = (Player) p;

        //Very important check which allows no error to occur if you do anything other then open a chest as well as checks to see if you have openned one.
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                event.getAction() == Action.LEFT_CLICK_BLOCK) &&
                event.getClickedBlock().getType() == Material.CHEST){


            event.getClickedBlock().setType(Material.AIR);

            event.setCancelled(true);

            int rando = (int) (Math.random() * 10);


            //---------------------------------------------------------------------------------
            if (rando == 1) {
                ItemStack Axe = new ItemStack(Material.DIAMOND_AXE, 1);
                ItemMeta meta = Axe.getItemMeta();
                List<String> lores = new ArrayList<String>();
                lores.add(ChatColor.DARK_PURPLE + "The axe of a long lost survivor");

                meta.setDisplayName(ChatColor.DARK_RED + "Survivor Axe");
                meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                meta.addEnchant(Enchantment.DURABILITY, 2, true);
                meta.setLore(lores);
                Axe.setItemMeta(meta);
                Axe.setDurability((short) 1000);
                player.getInventory().addItem(Axe);
                player.sendMessage(ChatColor.GOLD + "You opened a" + ChatColor.AQUA + " RARE " + ChatColor.GOLD + "loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando > 1) {
                ItemStack IronSword = new ItemStack(Material.IRON_SWORD, 1);
                ItemMeta meta2 = IronSword.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable iron sword");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Sword");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.setLore(lores2);
                IronSword.setItemMeta(meta2);
                IronSword.setDurability((short) 250);
                player.getInventory().addItem(IronSword);
                player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");
            }
            //---------------------------------------------------------------------------------


            
        }
    }
}
