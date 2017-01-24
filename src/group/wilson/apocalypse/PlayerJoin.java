package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by s201021621 on 2016-12-13.
 */
public class PlayerJoin implements Listener {

    private StatsManager statsManager;

    public PlayerJoin(Main plugin, StatsManager statsManager) { this.statsManager = statsManager; }


    @EventHandler
    public void Join(PlayerJoinEvent join) {

        //Gets the joined player
        Player player = join.getPlayer();

        //Creates int kills which gets the kills value from the getKills method in the StatsManager class
        int kills = statsManager.getKills(player, EntityType.ZOMBIE);

        //Sends the joined player a join message with a suggestion to use /chest and their kills
        join.getPlayer().sendMessage(ChatColor.GOLD + "Welcome to the apocalypse server! Remember to use " + ChatColor.AQUA + "/chest" + ChatColor.GOLD + " to get free items!");
        join.getPlayer().sendMessage(ChatColor.GOLD + "You currently have " + ChatColor.AQUA + kills + ChatColor.GOLD + " Kills!");

    }
}
