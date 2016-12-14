package group.wilson.apocalypse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;



/**
 * Created by s201021621 on 2016-11-17.
 */


//public class Scoreboard implements Listener {
//    private Team team;
//    private org.bukkit.scoreboard.Scoreboard board;
//    main configGetter;
//
//    public Scoreboard(main plugin) {
//        this.configGetter = plugin;
//    }
//
//    public void scoreboard(Player p) {
//        board = Bukkit.getScoreboardManager().getNewScoreboard();
//
//        Objective objective = board.registerNewObjective("Test", "Test2");
//        objective.setDisplayName(ChatColor.YELLOW.toString() + ChatColor.BOLD + "TEST");
//        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
//
//        team = board.registerNewTeam("team");
//        team.setPrefix(ChatColor.RED + "[team]");
//
//        Score score = objective.getScore(ChatColor.WHITE + "Kills: " + ChatColor.GREEN + this.configGetter.getConfig().getInt(p.getName() + " Zombie kills"));
//        score.setScore(1);
//    }
//
//    @EventHandler
//    public void join(PlayerJoinEvent e){
//        Player p = e.getPlayer();
//        p.setScoreboard(board);
//    }
//}
