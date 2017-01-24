package group.wilson.apocalypse;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Alexandre,Spencer on 2016-11-16.
 */
public class ListenerMob implements Listener {
    private StatsManager statsManager;
    //Reward numbers the method checks for
    public int Reward1 = 50;
    public int Reward2 = 250;
    //Passes events to Listener class
    public ListenerMob(Main plugin, StatsManager statsManager) { this.statsManager = statsManager; }


    //EventHandler, handles the event received (EntityDeathEvent)
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
            int kills;
            //Creates Player Entity from killer
            Player player = (Player) killer;
            if(bonus == 3) {

                //Adds kill to player
                statsManager.addKill(player, EntityType.ZOMBIE);
                statsManager.addKill(player, EntityType.ZOMBIE);

                kills = statsManager.getKills(player, EntityType.ZOMBIE);
                //Sends player message that they have received a kill and displays their current kills
                player.sendMessage(ChatColor.GOLD + "+2 kills! You have " + kills + " kills ");
            }
            else {
                //Adds kill to player
                statsManager.addKill(player, EntityType.ZOMBIE);

                kills = statsManager.getKills(player, EntityType.ZOMBIE);
                //Sends player message that they have received a kill and displays their current kills
                player.sendMessage(ChatColor.GREEN + "+1 kills! You have " + kills + " kills ");
            }
            //Checks to see if the Killcount is equal to the Reward1s value
            if (kills == Reward1){

                //Tells player they have gotten 50 kills that they are receiving 2 extra hearts
                player.sendMessage(ChatColor.GOLD + "You have gotten 50 kills! You have recieved 2 extra hearts!");
                //Sets the players health to 24 or 12 hearts
                player.setMaxHealth(24);

            }
            //Checks to see if the Killcount is equal to the Reward2s value
            if (kills == Reward2){
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
