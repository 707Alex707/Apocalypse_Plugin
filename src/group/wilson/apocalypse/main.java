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

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitScheduler;
import sun.misc.IOUtils;

/**
 * Created by Alexandre,Spencer on 2016-11-15.
 */
public class main extends JavaPlugin {

    //Sets the configGetter in this class
    main configGetter;
    private StatsManager statsManager;

    @Override
    public void onEnable() {

        statsManager = new StatsManager(new File(getDataFolder(),"stats.yml"));
        try {
            statsManager.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Fired when the server enables the plugin


        //Reads and writes information from plugin yml to console
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");
        logger.info(pdfFile.getName() + " plugin has been enabled  (Version " + pdfFile.getVersion() + ")");

        //Passes events to Listener class
        getServer().getPluginManager().registerEvents(new ListenerMob(this,statsManager), this);
        getServer().getPluginManager().registerEvents(new ChestRewards(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);

        //Passes Death Event
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);


    }

    @Override
    public void onDisable() {
        //Fired when the server stops and disables all plugins

        //Reads information from plugin yml and prints version information to console
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");
        logger.info(pdfFile.getName() + " has been disabled  (Version." + pdfFile.getVersion() + ")");
        //Saves kills so that they can be read later
        try {
            statsManager.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int a = 0;

    // This method is called, when somebody uses a command
    private final Map<UUID, Long> cooldown = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if ((cmd.getName().equalsIgnoreCase("chest")) && sender instanceof Player) {

            UUID uniqueId = ((Player) sender).getUniqueId();

            if (cooldown.containsKey(uniqueId)) {
                double diff = (System.currentTimeMillis() - cooldown.get(uniqueId)) / 1_000;

                if (diff < 10) {
                    sender.sendMessage("This is still on cooldown for another " + (10-diff) + " seconds..");
                    return true;
            }

                cooldown.remove(uniqueId);
            }

            cooldown.put(uniqueId, System.currentTimeMillis());

            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "You have recieved a chest!");
            //Gives the player a chest
            ItemStack chest = new ItemStack(Material.CHEST, 1);
            player.getInventory().addItem(chest);
            return true;
        }
        if ((cmd.getName().equalsIgnoreCase("leaderboard")) && sender instanceof Player) {


            Map<String,Integer> sorted = new HashMap<>();

            sorted.forEach((playername,kills) ->{
                sender.sendMessage(playername + ": " + kills);
            });
            return true;
        }
        return false;
    }
}