package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

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

            player.sendMessage(ChatColor.GOLD + "You opened a loot chest!");

        }

    }


}
