package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by s201021621 on 2016-12-13.
 */
public class PlayerJoin implements Listener {

    private StatsManager statsManager;

    public PlayerJoin(main plugin,StatsManager statsManager) { this.statsManager = statsManager; }


    @EventHandler
    public void Join(PlayerJoinEvent join) {

        Player player = (Player)join;

        int kills = statsManager.getKills(player, EntityType.ZOMBIE);

        join.getPlayer().sendMessage(ChatColor.GOLD + "Welcome to the apocolypse server! Remember to use " + ChatColor.AQUA + "/chest" + ChatColor.GOLD + " to get free items!");
        join.getPlayer().sendMessage(ChatColor.GOLD + "You currently have " + ChatColor.AQUA + kills + ChatColor.GOLD + " Kills!");

    }
}
