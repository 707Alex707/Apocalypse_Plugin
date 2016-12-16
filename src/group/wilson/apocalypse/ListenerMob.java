package group.wilson.apocalypse;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import net.minecraft.server.v1_10_R1.EntityZombie;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.TextComponent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.bukkit.Bukkit.getBukkitVersion;
import static org.bukkit.Bukkit.getServer;
import static sun.audio.AudioPlayer.player;

/**
 * Created by Alexandre,Spencer on 2016-11-16.
 */
public class ListenerMob implements Listener {

    //Kills
    public int kills;
    public Entity BossEntity = null;
    public int Boss = 75;
    public int Health = 40;
    public int Reward1 = 50;
    public int Reward2 = 250;
    public int BossActivate = 0;
    public int a = 0;
    main configGetter;

    //Passes events to Listener class
    public ListenerMob(main plugin) { this.configGetter = plugin; }

    @EventHandler
    public void KillZombie(EntityDeathEvent z)
    {
        Entity deadEntity = z.getEntity();
        Entity killer = z.getEntity().getKiller();
        int bonus = (int) (Math.random() * 10);
        if (((killer instanceof Player)) && ((deadEntity instanceof Zombie)))
        {
            Player player = (Player)killer;
            int Killcount;

            if(bonus == 3){
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                this.configGetter.getConfig().set(player.getName() + " Zombie kills", Integer.valueOf(Killcount + 2));
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                player.sendMessage(ChatColor.GOLD + "BONUS! " + ChatColor.GREEN + "+2 kills! "  + Killcount + " kills ");
            }
            else {
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                this.configGetter.getConfig().set(player.getName() + " Zombie kills", Integer.valueOf(Killcount + 1));
                Killcount = this.configGetter.getConfig().getInt(player.getName() + " Zombie kills");
                player.sendMessage(ChatColor.GREEN + "+1 kills! You have " + Killcount + " kills ");
            }
            //
            if (Killcount == Reward1){

                player.sendMessage(ChatColor.GOLD + "You have gotten 50 kills! You have recieved 2 extra hearts!");
                player.setMaxHealth(24);

            }
            if (Killcount == Boss){ BossActivate = 1; }

            if (BossActivate == 1){

                if(a == 0) {
                    Bukkit.broadcastMessage(ChatColor.RED + "A Boss Has Spawned!");
                    Location l = player.getLocation();
                    Entity BossEntity = deadEntity.getWorld().spawnEntity(l, EntityType.ZOMBIE);
                    BossEntity.setCustomName(ChatColor.RED + "Burick");
                    BossEntity.playEffect(EntityEffect.WITCH_MAGIC);
                    BossEntity.playEffect(EntityEffect.FIREWORK_EXPLODE);
                }
                a++;
                while (Health > 0) {

                    if (Health > 0) {
                        BossEntity.getLastDamageCause().setDamage(0);
                        Health--;
                    }

                }
                if (Health == 0){ BossActivate = 0; }
            }
            if (Killcount == Reward2){
                player.setMaxHealth(26);
                player.sendMessage(ChatColor.GOLD + "You have gotten 250 kills! You have recieved a Perm speed boost and another heart!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1), true);
            }
        }

    }
}
