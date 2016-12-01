package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s201021621 on 2016-11-30.
 */
public class ChestRewards implements Listener {

    main configGetter;

    public ChestRewards(main plugin)
    {
        this.configGetter = plugin;
    }

    public ChestRewards() {

    }

    @EventHandler

    public void catchChestOpen(InventoryOpenEvent event)
    {
        Entity p = event.getPlayer();
        if(event.getInventory().getType().equals(InventoryType.CHEST))
        {
            Player player = (Player)p;

            event.getInventory().getLocation().getBlock().getType().equals(new ItemStack(Material.AIR));

            event.setCancelled(true);

            ItemStack Axe = new ItemStack(Material.DIAMOND_AXE, 1);
            ItemMeta meta = Axe.getItemMeta();
            List<String> lores = new ArrayList<String>();
            lores.add(ChatColor.DARK_PURPLE + "The axe of a long lost survivor");

            meta.setDisplayName(ChatColor.DARK_RED + "Survivor Axe");
            meta.setLore(lores);
            Axe.setItemMeta(meta);
            Axe.setDurability((short) 800);
            player.getInventory().addItem(Axe);


            
            player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");

        }

    }


}
