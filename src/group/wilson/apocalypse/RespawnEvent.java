package group.wilson.apocalypse;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;


/**
 * Created by Alexandre on 2016-12-02.
 */
public class RespawnEvent implements Listener {

    //Passes events to Listener class
    public RespawnEvent(Main plugin)
    {

    }

    @EventHandler
    //Runs on Entity Respawn
    public void ClassDefault(PlayerRespawnEvent spawn) {

        //Gets what player died
        final Player p = spawn.getPlayer();


        //Gives player Leather armor and gold chestplate + diamond sword on death
        p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
        p.getInventory().addItem(new ItemStack(Material.BREAD, 4));
        p.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));


    }
}
