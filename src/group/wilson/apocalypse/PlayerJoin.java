package group.wilson.apocalypse;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by s201021621 on 2016-12-13.
 */
public class PlayerJoin implements Listener {

    main configGetter;
    public PlayerJoin(main plugin)
    {
        this.configGetter = plugin;
    }

    @EventHandler
    public void Join(PlayerJoinEvent join) {

        int Killcount = this.configGetter.getConfig().getInt(join.getPlayer().getName() + " Zombie kills");

        join.getPlayer().sendMessage(ChatColor.GOLD + "Welcome to the apocolypse server! Remember to use " + ChatColor.AQUA + "/chest" + ChatColor.GOLD + " to get free items!");
        join.getPlayer().sendMessage(ChatColor.GOLD + "You currently have " + ChatColor.AQUA + Killcount + ChatColor.GOLD + " Kills!");

    }
}
