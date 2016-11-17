package group.wilson.apocalypse;

import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Alexandre on 2016-11-16.
 */
public class ListenerMob implements Listener {

    @EventHandler
    //Runs on Mob Death
    public void mobkill(final EntityDeathEvent event) throws FileNotFoundException {


        //If player kills a monster this fires
        if (event.getEntity() instanceof Monster)
        {
            BufferedReader in = new BufferedReader(new FileReader("kills.txt"));
            //Need to get the text from the txt first
            int kills = 0;
            new Scoreboard(kills);

        }
    }

}
