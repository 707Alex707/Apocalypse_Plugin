package group.wilson.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.TextComponent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.bukkit.Bukkit.getServer;
import static sun.audio.AudioPlayer.player;

/**
 * Created by Alexandre on 2016-11-16.
 */
public class ListenerMob implements Listener {

    //Kills
    public int kills;
    public int Reward1 = 50;
    public int Reward2 = 250;

    main configGetter;

    //Passes events to Listener class
    public ListenerMob(main plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.configGetter = plugin;
    }

    @EventHandler
    public void KillZombie(EntityDeathEvent z)
    {
        Entity deadEntity = z.getEntity();
        Entity killer = z.getEntity().getKiller();
        if (((killer instanceof Player)) && ((deadEntity instanceof Zombie)))
        {
            Player player = (Player)killer;

            //Gets and saved each players kills (YES IT SAVED THEM SEPERATELY YAY) -Spencer
            int Killcount = this.configGetter.getConfig().getInt("Zombie kills " + player.getName());
            this.configGetter.getConfig().set("Zombie kills " + player.getName(), Integer.valueOf(Killcount + 1));
            Killcount = this.configGetter.getConfig().getInt("Zombie kills " + player.getName());
            player.sendMessage(ChatColor.GREEN + "+1 kills! You have " + Killcount + " kills ");

            //
            if (Killcount == Reward1){

                player.sendMessage(ChatColor.GOLD + "You have gotten 50 kills! You have recieved 2 extra hearts!");
                player.setMaxHealth(24);

            }
            if (Killcount == Reward2){
                player.sendMessage(ChatColor.GOLD + "You have gotten 250 kills! You have recieved a Perm speed boost and another heart!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1), true);
            }
        }

    }


}
