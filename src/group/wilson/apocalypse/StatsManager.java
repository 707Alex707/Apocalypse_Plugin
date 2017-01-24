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
    private final Map<String, Map<EntityType, Integer>> stats = new HashMap<>();
    private final File file;

    public StatsManager(File file) {
        this.file = file;
    }

    public void addKill(Player player, EntityType type) {
        String playerName = player.getName();

        if (stats.containsKey(playerName)) {
            Map<EntityType, Integer> data = stats.get(playerName);
            data.put(type, data.getOrDefault(type, 0) + 1);

            stats.put(playerName, data);
        } else {
            Map<EntityType, Integer> data = stats.get(playerName);
            data.put(type, 1);

            stats.put(playerName, data);
        }
    }

    public Map<String, Integer> sort(EntityType type) {
        Map<String, Integer> raw = new HashMap<>();

        stats.forEach((playerName, stats) -> {
            raw.put(playerName, stats.getOrDefault(type, 0));
        });

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

    public void load() throws IOException {
        if (!file.exists()) {
            save();
            return;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.getKeys(false).forEach(key -> {
            ConfigurationSection section = config.getConfigurationSection(key);

            HashMap<EntityType, Integer> entityKills = new HashMap<>();

            section.getKeys(false).forEach(typeKey -> {
                entityKills.put(EntityType.valueOf(typeKey), section.getInt(typeKey));
            });

            stats.put(key, entityKills);
        });
    }

    public void save() throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();

            if (!parentFile.exists()) {
                parentFile.mkdir();
            }

            file.createNewFile();
        }

        YamlConfiguration config = new YamlConfiguration();

        stats.forEach((playerName, stats) -> {
            ConfigurationSection section = config.createSection(playerName);

            stats.forEach((type, amount) -> {
                section.set(type.name(), amount);
            });
        });

        config.save(file);
    }
}