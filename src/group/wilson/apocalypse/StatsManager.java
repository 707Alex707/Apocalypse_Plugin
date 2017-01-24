package group.wilson.apocalypse;

/**
 * Created by sfsup on 2017-01-23.
 */
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsManager {
    //Creates variables for class
    private final Map<String, Map<EntityType, Integer>> stats = new HashMap<>();
    private final File file;

    //sets file to this class
    public StatsManager(File file) {
        this.file = file;
    }

    //Gets the kills for the player
    //recieves the kills and entity type
    public int getKills(Player player, EntityType type){

        //trys to get players kills from stats.yml, if fails returns 0 for player kills
        try {
            stats.get(player.getName()).get(type);
        }catch(java.lang.NullPointerException e)
        {
            return 0;
        }
            return stats.get(player.getName()).get(type);

    }

    //Method for adding kills to the player, receives Player and EntityType
    public void addKill(Player player, EntityType type) {
        //Gets the players name
        String playerName = player.getName();

        //Checks to see if the map stats contains the players name
        if (stats.containsKey(playerName)) {
            //Creates a map and sets the values in the map to the players current kills, if none then set 0, then add 1
            Map<EntityType, Integer> data = stats.get(playerName);
            data.put(type, data.getOrDefault(type, 0) + 1);
            stats.put(playerName, data);

            //If the map doesn't contain the players name, puts players name in stats.yml
        } else {
            Map<EntityType, Integer> data = new HashMap<>();
            data.put(type, 1);

            stats.put(playerName, data);
        }
    }


    //Method to sort players kills, receives EntityType
    public Map<String, Integer> sort(EntityType type) {
        //creates new map for playername and stats
        Map<String, Integer> raw = new HashMap<>();

        //for each playername and stats(or kills) in the map, puts those values in the "raw" map
        stats.forEach((playerName, stats) -> {

            raw.put(playerName, stats.getOrDefault(type, 0));
        });

        //Returns sorted kill values in the "raw" map
        return raw.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    //loads stats.yml, Throws IOException
    public void load() throws IOException {
        //If stats.yml doesn't exist, saves config(which creates the file)
        if (!file.exists()) {
            save();
            return;
        }

        //YamlConfiguration is a config method for Bukkit(Minecraft servers)
        //Creates virtual config for class, then loads the current one in the plugins folder(assigns it to the virtual on in the class)
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Gets the keys(or mob kills)
        //for each set of mob kills, assigns them ot the map "entityKills" then puts those values to the public map "stats"
        config.getKeys(false).forEach(key -> {
            ConfigurationSection section = config.getConfigurationSection(key);

            HashMap<EntityType, Integer> entityKills = new HashMap<>();

            section.getKeys(false).forEach(typeKey -> {
                entityKills.put(EntityType.valueOf(typeKey), section.getInt(typeKey));
            });

            stats.put(key, entityKills);
        });
    }

    //Method to save config or "stats.yml" and throws IOException
    public void save() throws IOException {
        //If config doesn't exist creates new config or overwrites the current one
        if (!file.exists()) {
            File parentFile = file.getParentFile();

            if (!parentFile.exists()) {
                parentFile.mkdir();
            }

            file.createNewFile();
        }

        //Creates virtual config
        YamlConfiguration config = new YamlConfiguration();

        //for each playername and amount of kills, creates section for them(like a new line in an array)
        stats.forEach((playerName, stats) -> {
            ConfigurationSection section = config.createSection(playerName);

            stats.forEach((type, amount) -> {
                section.set(type.name(), amount);
            });
        });

        //Saves the config
        config.save(file);
    }
}