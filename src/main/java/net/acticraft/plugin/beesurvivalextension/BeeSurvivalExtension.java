package net.acticraft.plugin.beesurvivalextension;

import net.acticraft.plugin.beesurvivalextension.SpawnArea.SpawnRegion;
import net.acticraft.plugin.beesurvivalextension.SurvivalPlayer.ScoreBoard;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeeSurvivalExtension extends JavaPlugin {

    private static BeeSurvivalExtension instance;

    private final YamlConfiguration conf = new YamlConfiguration();
    public String servername = getConfig().getString("servername");
    public String serverid = getConfig().getString("serverid");
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.of("#FFBF00")+"[BeeSurvivalExtension] Plugin enabled!");
        Bukkit.getPluginManager().registerEvents(new SpawnRegion(), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoard(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BeeSurvivalExtension getInstance() {
        return instance;
    }

}
