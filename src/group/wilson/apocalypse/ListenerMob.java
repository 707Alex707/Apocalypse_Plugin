package group.wilson.apocalypse;

import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Alexandre on 2016-11-16.
 */
public class ListenerMob implements Listener {

    @EventHandler
    //Runs on Mob Death
    public void mobkill(final EntityDeathEvent event)
    {
        //If player kills a monster this fires
        if (event.getEntity() instanceof Monster)
        {


        }
    }

}
