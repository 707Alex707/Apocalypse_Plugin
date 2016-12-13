package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by s201021621 on 2016-12-13.
 */
public class PlayerJoin implements Listener {


    public PlayerJoin(main plugin) {

    }

    @EventHandler
    public void Join(PlayerJoinEvent join) {

        join.getPlayer().sendMessage(ChatColor.GOLD + "Welcome to the apocolypse server! Remember to use " + ChatColor.AQUA + "/chest" + ChatColor.GOLD + " to get free items!");

    }
}
