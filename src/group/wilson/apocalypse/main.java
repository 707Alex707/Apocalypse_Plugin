package group.wilson.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created by Alexandre,Spencer on 2016-11-15.
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
        getServer().getPluginManager().registerEvents(new ListenerMob(this), this);
        getServer().getPluginManager().registerEvents(new ChestRewards(this), this);

        //Passes Death Event
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);
        getServer().getPluginManager().registerEvents(new ZombieSpawnEvent(this), this);

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

    int a = 0;

    // This method is called, when somebody uses the command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        {
            if ((cmd.getName().equalsIgnoreCase("chest")) && sender instanceof Player && a == 0) {

                Player player = (Player) sender;
                Bukkit.broadcastMessage("You have recieved a chest!");
                ItemStack chest = new ItemStack(Material.CHEST, 1);
                player.getInventory().addItem(chest);
                a = 1;
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage("You can use /chest again!");
                        a = 0;
                    }
                }, 1200);
                return true;
            }

            return false;
        }


    }
}