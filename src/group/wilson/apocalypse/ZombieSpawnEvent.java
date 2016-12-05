package group.wilson.apocalypse;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Alexandre on 2016-12-05.
 */
public class ZombieSpawnEvent {

    //Delceration
    main configGetter;

    //Passes events to Listener class
    public ZombieSpawnEvent(main plugin)
    {
        this.configGetter = plugin;
    }

    @EventHandler
    //Runs on Entity Respawn
    public void ZombieSpawn(EntityDeathEvent zombiespawned) {


        if (zombiespawned.getEntityType() == EntityType.ZOMBIE) {

            Entity spawned = zombiespawned.getEntity();

            //spawned.





        }

    }



}
