package group.wilson.apocalypse;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alexandre on 2016-12-02.
 */
public class RespawnEvent implements Listener {

    //Delceration
    main configGetter;

    //Passes events to Listener class
    public RespawnEvent(main plugin)
    {
        this.configGetter = plugin;
    }

    @EventHandler
    //Runs on Entity Respawn
    public void ClassDefault(PlayerRespawnEvent spawn) {

        //Gets what player died
        final Player p = spawn.getPlayer();

        /*
        ItemStack weapon = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack armor = new ItemStack(Material.IRON_CHESTPLATE);
        p.getInventory().addItem(weapon);

        ItemStack[] respawnkit;

        List<ItemStack> kit = new ArrayList<ItemStack>();
        kit.add(new ItemStack(Material.DIAMOND_SWORD, 1));
        kit.add(new ItemStack(Material.LEATHER_HELMET, 1));
        kit.add(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        kit.add(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        kit.add(new ItemStack(Material.LEATHER_BOOTS, 1));
        p.getInventory().se
        */

        //Gives player Leather armor and gold chestplate + diamond sword on death
        p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));


    }
}
