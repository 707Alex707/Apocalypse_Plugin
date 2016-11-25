package group.wilson.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
/**
 * Created by Alexandre on 2016-11-15.
 */
public class main extends JavaPlugin {

        @Override
        public void onEnable() {
            //Fired when the server enables the plugin

            //Generates config file if does not exist
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("config.yml found, loading!");
            }
            //Reads and writes information from plugin yml to console
            PluginDescriptionFile pdfFile = getDescription();
            Logger logger = Logger.getLogger("Minecraft");
            logger.info(pdfFile.getName() + " plugin has been enabled  (Version " + pdfFile.getVersion() + ")");

            //Passes events to Listener class
            getServer().getPluginManager().registerEvents(new ListenerMob(this),this);


            //Adds default stored kills value for zombies
            getConfig().addDefault("Zombie kills", Integer.valueOf(0));
            getConfig().options().copyDefaults(true);
            saveConfig();

        }
        @Override
        public void onDisable() {
            //Fired when the server stops and disables all plugins

            //Reads information from plugin yml and prints version information to console
            PluginDescriptionFile pdfFile = getDescription();
            Logger logger = Logger.getLogger("Minecraft");
            logger.info(pdfFile.getName() + " has been disabled  (Version." + pdfFile.getVersion() + ")");
            //Saves kills so that they can be read later
            saveConfig();
        }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if ((cmd.getName().equalsIgnoreCase("kills")) && ((sender instanceof Player)))
        {
            Player player = (Player)sender;

            player.sendMessage(ChatColor.GREEN + "### MobKills ###");
            player.sendMessage(getConfig().getInt("Zombie kills") + " Zombies have been killed on this server!");

            saveConfig();

            return true;
        }
        return false;
    }
        //Change28

}
