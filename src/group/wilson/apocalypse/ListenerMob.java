package group.wilson.apocalypse;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import net.minecraft.server.v1_10_R1.EntityZombie;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.TextComponent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.bukkit.Bukkit.getBukkitVersion;
import static org.bukkit.Bukkit.getServer;
import static sun.audio.AudioPlayer.player;

/**
 * Created by Alexandre,Spencer on 2016-11-16.
 */
public class ListenerMob implements Listener {

    //Reward numbers the method checks for
    public int Reward1 = 50;
    public int Reward2 = 250;
    //Sets the configGetter in this class
    main configGetter;

    //Passes events to Listener class
    public ListenerMob(main plugin) { this.configGetter = plugin; }

    //EventHandler, handles the event received (EvtityDeathEvent)
    @EventHandler
    public void KillZombie(EntityDeathEvent z)
    {
        //Gets the deadEntity or Entity killed
        Entity deadEntity = z.getEntity();
        //Gets the killer of the entity
        Entity killer = z.getEntity().getKiller();
        //Generates a random number between 1 - 10 for the bonus number
        int bonus = (int) (Math.random() * 10);
        //Checks to see if the entity killed was a zombie or not
        if (((killer instanceof Player)) && ((deadEntity instanceof Zombie)))
        {
            //Creates Player Entity from killer
            Player player = (Player)killer;
            //Creates integer Killcount to temporarily assign players kill value to
            int Killcount;

            //checks to see if bonus number is 3, if it is gives player 2 kills instead of 1
            if(bonus == 3){
                //Gets players current zombies kills from config, if the value doesn't exist, 0 is assigned
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                //Adds 2 to the value of the players kills
                this.configGetter.getConfig().set(player.getName() + " Zombie kills", Integer.valueOf(Killcount + 2));
                //Updates Killcount value in order to display it to player
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                //Sends player message that they have received a bonus and their current kills
                player.sendMessage(ChatColor.GOLD + "BONUS! " + ChatColor.GREEN + "+2 kills! "  + Killcount + " kills ");
            }
            else {
                //Gets players current zombies kills from config, if the value doesn't exist, 0 is assigned
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                //Adds 2 to the value of the players kills
                this.configGetter.getConfig().set(player.getName() + " Zombie kills", Integer.valueOf(Killcount + 1));
                //Updates Killcount value in order to display it to player
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                //Sends player message that they have received a kill and displays their current kills
                player.sendMessage(ChatColor.GREEN + "+1 kills! You have " + Killcount + " kills ");
            }
            //Checks to see if the Killcount is equal to the Reward1s value
            if (Killcount == Reward1){

                //Tells player they have gotten 50 kills that they are receiving 2 extra hearts
                player.sendMessage(ChatColor.GOLD + "You have gotten 50 kills! You have recieved 2 extra hearts!");
                //Sets the players health to 24 or 12 hearts
                player.setMaxHealth(24);

            }
            //Checks to see if the Killcount is equal to the Reward2s value
            if (Killcount == Reward2){
                //Sets the players health to 26 or 13 hearts
                player.setMaxHealth(26);
                //Tells them they have gotten 50 kills and that they are receiving an extra heart and a permanent speed boost
                player.sendMessage(ChatColor.GOLD + "You have gotten 250 kills! You have recieved a Perm speed boost and another heart!");
                //Sets the players speed to 2 permanently
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1), true);
            }
        }

    }
}
