package group.wilson.apocalypse;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.awt.*;

import static net.md_5.bungee.api.ChatColor.*;

/**
 * Created by s201021621 on 2016-11-21.
 */
public final class TestListener implements Listener {
    public TestListener(main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    public TestListener() {

    }
}