package group.wilson.apocalypse;

import net.minecraft.server.v1_10_R1.Item;
import net.minecraft.server.v1_10_R1.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

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

        org.bukkit.inventory.ItemStack is = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SWORD, 1);
        p.getInventory().addItem(is);



    }
}
