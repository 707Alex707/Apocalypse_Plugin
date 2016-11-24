package group.wilson.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

/**
 * Created by Alexandre on 2016-11-15.
 */
public class main extends JavaPlugin {

        @Override
        public void onEnable() {
            //Fired when the server enables the plugin

            //Reads and writes information from plugin yml to console
            PluginDescriptionFile pdfFile = getDescription();
            Logger logger = Logger.getLogger("Minecraft");
            logger.info(pdfFile.getName() + " plugin has been enabled  (Version " + pdfFile.getVersion() + ")");

            //Passes events to Listener class
            new ListenerMob(this);


        }
        @Override
        public void onDisable() {
            //Fired when the server stops and disables all plugins

            //Reads information from plugin yml and prints version information to console
            PluginDescriptionFile pdfFile = getDescription();
            Logger logger = Logger.getLogger("Minecraft");
            logger.info(pdfFile.getName() + " has been disabled  (Version." + pdfFile.getVersion() + ")");
        }

        //Change28

}
