package group.wilson.apocalypse;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Alexandre on 2016-12-05.
 */
public class ZombieSpawnEvent implements Listener {

    //Delceration
    main configGetter;

    //Passes events to Listener class
    public ZombieSpawnEvent(main plugin)
    {
        this.configGetter = plugin;
    }

    @EventHandler
    //Runs on Entity Respawn
    public void ZombieSpawn(EntitySpawnEvent zombiespawned) {


        if (zombiespawned instanceof Zombie) {

            ((Zombie) zombiespawned).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0), true);
            //spawned.

        }

    }



}
