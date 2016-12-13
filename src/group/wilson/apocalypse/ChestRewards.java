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

            int rando = (int) (Math.random() * 210);


            if (rando < 3) {
                ItemStack DSword = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta meta = DSword.getItemMeta();
                List<String> lores = new ArrayList<String>();
                lores.add(ChatColor.DARK_PURPLE + "The Legendary Sword Of A King");

                meta.setDisplayName(ChatColor.GOLD + "Excalibur");
                meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                meta.addEnchant(Enchantment.DURABILITY, 5, true);
                meta.setLore(lores);
                DSword.setItemMeta(meta);
                player.getInventory().addItem(DSword);
                player.sendMessage(ChatColor.GOLD + "You opened a" + ChatColor.LIGHT_PURPLE + " LEGENDARY " + ChatColor.GOLD + "loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando < 15 && rando > 3) {
                ItemStack Axe = new ItemStack(Material.DIAMOND_AXE, 1);
                ItemMeta meta = Axe.getItemMeta();
                List<String> lores = new ArrayList<String>();
                lores.add(ChatColor.DARK_PURPLE + "The axe of a long lost survivor");

                meta.setDisplayName(ChatColor.DARK_RED + "Survivor Axe");
                meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                meta.addEnchant(Enchantment.DURABILITY, 2, true);
                meta.setLore(lores);
                Axe.setItemMeta(meta);
                Axe.setDurability((short) 500);
                player.getInventory().addItem(Axe);
                player.sendMessage(ChatColor.GOLD + "You opened a" + ChatColor.AQUA + " RARE " + ChatColor.GOLD + "loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando > 15 && rando < 30) {
                ItemStack IronSword = new ItemStack(Material.IRON_SWORD, 1);
                ItemMeta meta2 = IronSword.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable iron sword");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Sword");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.setLore(lores2);
                IronSword.setItemMeta(meta2);
                player.getInventory().addItem(IronSword);
                player.sendMessage(ChatColor.GOLD + "You opened an " + ChatColor.GREEN + "UNCOMMON" + ChatColor.GOLD + " loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando > 30 && rando < 60) {
                ItemStack[] items = {new ItemStack(Material.COOKED_FISH, 9), new ItemStack(Material.STONE_SWORD, 1), new ItemStack((Material.LEATHER_CHESTPLATE))};
                player.getInventory().addItem(items);
                player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando > 60 && rando < 90) {
                ItemStack[] items = {new ItemStack(Material.COOKED_BEEF, 5), new ItemStack(Material.LEATHER_BOOTS, 1), new ItemStack((Material.CHAINMAIL_HELMET))};
                player.getInventory().addItem(items);
                player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");
            }
            //---------------------------------------------------------------------------------
            if (rando > 90 && rando < 120) {
                ItemStack[] items = {new ItemStack(Material.COOKED_CHICKEN, 7), new ItemStack(Material.CHAINMAIL_LEGGINGS, 1), new ItemStack((Material.WOOD_SWORD))};
                player.getInventory().addItem(items);
                player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");
            }
            if (rando > 120 && rando < 135) {
                ItemStack IronHelm = new ItemStack(Material.IRON_HELMET, 1);
                ItemMeta meta2 = IronHelm.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable iron helmet");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Helmet");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta2.setLore(lores2);
                IronHelm.setItemMeta(meta2);
                player.getInventory().addItem(IronHelm);
                player.sendMessage(ChatColor.GOLD + "You opened an " + ChatColor.GREEN + "UNCOMMON" + ChatColor.GOLD + " loot chest!");
            }
            if (rando > 135 && rando < 150) {
                ItemStack IronHelm = new ItemStack(Material.IRON_CHESTPLATE, 1);
                ItemMeta meta2 = IronHelm.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable iron chestplate");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Chestplate");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta2.setLore(lores2);
                IronHelm.setItemMeta(meta2);
                player.getInventory().addItem(IronHelm);
                player.sendMessage(ChatColor.GOLD + "You opened an " + ChatColor.GREEN + "UNCOMMON" + ChatColor.GOLD + " loot chest!");
            }
            if (rando > 150 && rando < 165) {
                ItemStack IronHelm = new ItemStack(Material.IRON_LEGGINGS, 1);
                ItemMeta meta2 = IronHelm.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable pair of iron pants");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Leggings");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta2.setLore(lores2);
                IronHelm.setItemMeta(meta2);
                player.getInventory().addItem(IronHelm);
                player.sendMessage(ChatColor.GOLD + "You opened an " + ChatColor.GREEN + "UNCOMMON" + ChatColor.GOLD + " loot chest!");
            }
            if (rando > 165 && rando < 180) {
                ItemStack IronHelm = new ItemStack(Material.IRON_BOOTS, 1);
                ItemMeta meta2 = IronHelm.getItemMeta();
                List<String> lores2 = new ArrayList<String>();
                lores2.add(ChatColor.DARK_PURPLE + "A reliable pair of iron boots");

                meta2.setDisplayName(ChatColor.DARK_RED + "Reliable Iron Boots");
                meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta2.setLore(lores2);
                IronHelm.setItemMeta(meta2);
                player.getInventory().addItem(IronHelm);
                player.sendMessage(ChatColor.GOLD + "You opened an " + ChatColor.GREEN + "UNCOMMON" + ChatColor.GOLD + " loot chest!");
            }
            if (rando > 180 && rando < 210) {
                ItemStack[] items = {new ItemStack(Material.COOKED_FISH, 9), new ItemStack(Material.STONE_SWORD, 1), new ItemStack((Material.CHAINMAIL_CHESTPLATE))};
                player.getInventory().addItem(items);
                player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");
            }
        }
    }
}
