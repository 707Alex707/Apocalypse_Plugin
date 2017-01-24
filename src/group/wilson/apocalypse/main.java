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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
        saveConfig();
    }

    int a = 0;

    // This method is called, when somebody uses the command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        {
            //Checks to see if the command contains the text "chest" and if the sender is a player
            //After the command is used, it checks to see if a == 0 or rather if then command is on a cooldown.
            if ((cmd.getName().equalsIgnoreCase("chest")) && sender instanceof Player && a == 0) {

                //Creates Player entity reference from "sender" of the command
                Player player = (Player) sender;
                //Sends the player a message
                player.sendMessage(ChatColor.GOLD + "You have recieved a chest!");
                //Gives the player a chest
                ItemStack chest = new ItemStack(Material.CHEST, 1);
                player.getInventory().addItem(chest);
                //sets a to 1 which activates cooldown
                a = 1;
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        player.sendMessage(ChatColor.GOLD + "You can use /chest again!");
                        a = 0;
                    }
                }, 1200);
                return true;
            }

            if ((cmd.getName().equalsIgnoreCase("leaderboard")) && sender instanceof Player){


                //Creates Player entity reference from "sender" of the command
                Player player = (Player) sender;
                //Sends the player a message
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Leaderboard");


                //Array to hold config lines
                ArrayList<String> configbyline = new ArrayList<String>();

                try {

                    // First of all, you need to define file you want to read.
                    File fileToRead = new File("plugins/Apocalypse/config.yml");

                    // Setup BufferedReader
                    BufferedReader br = new BufferedReader(new FileReader(fileToRead));

                    //Read line by line
                    String line = null;


                    //
                    while ((line = br.readLine()) != null) {

                        //Adds each line to array
                        configbyline.add(line);

                    }

                    //Converts arraylist to string array
                    String [] data_array = new String[configbyline.size()];
                    configbyline.toArray(data_array);

                    for(int i = 0; i < data_array.length; i++) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + data_array[i]);
                    }



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }








                return true;
            }





            return false;
        }
    }











}