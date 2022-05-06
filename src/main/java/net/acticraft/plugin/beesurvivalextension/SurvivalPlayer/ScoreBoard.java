package net.acticraft.plugin.beesurvivalextension.SurvivalPlayer;

import me.clip.placeholderapi.PlaceholderAPI;
import net.acticraft.plugin.api.beeapi.scoreboard.BeeScoreboard;
import net.acticraft.plugin.beesurvivalextension.BeeSurvivalExtension;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreBoard implements Listener {
    private final Map<UUID, BeeScoreboard> boards = new HashMap<>();



    public ScoreBoard() {
        Bukkit.getServer().getScheduler().runTaskTimer(BeeSurvivalExtension.getInstance(), () -> {
            for (BeeScoreboard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }

    @EventHandler

    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        BeeScoreboard beesc = new BeeScoreboard(player);

        beesc.updateTitle(ChatColor.of("#FFBF00")+""+ChatColor.BOLD + "McBee");

        this.boards.put(player.getUniqueId(), beesc);


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        BeeScoreboard beesc = this.boards.remove(player.getUniqueId());

        if (beesc != null) {
            beesc.delete();
        }

    }

    //TODO do a scoreboard
    private void updateBoard(BeeScoreboard lobbysb) {
        lobbysb.updateLines(
                "",
                ChatColor.of("#FFBF00")+""+ChatColor.BOLD + "Player Stats",
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Name: " + ChatColor.of("#FAD5A5")+lobbysb.getPlayer().getName(),
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Ping: " + ChatColor.of("#FAD5A5")+lobbysb.getPlayer().getPing(),
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Health: " + ChatColor.of("#FAD5A5")+lobbysb.getPlayer().getHealth()+"❤",
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Kills: " + ChatColor.of("#FAD5A5")+lobbysb.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Deaths: " + ChatColor.of("#FAD5A5")+lobbysb.getPlayer().getStatistic(Statistic.DEATHS),
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Money: " + ChatColor.of("#FAD5A5")+ PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"$%vault_eco_balance_fixed%"),
                "",
                ChatColor.of("#FFBF00")+""+ChatColor.BOLD + "SlimeFun Stats",
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Xp Spend " + ChatColor.of("#FAD5A5")+ PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%slimefun_researches_total_xp_levels_spent%xp"),
                ChatColor.of("#738291")+""+ChatColor.BOLD+"| "+ChatColor.of("#F28C28")+""+ChatColor.BOLD+"Unlocked: " + ChatColor.of("#FAD5A5")+ PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%slimefun_researches_percentage_researches_unlocked%%"),
                "",
                ChatColor.of("#FFBF00")+""+ChatColor.BOLD + "discord.gg/mcbee"


        );



    }

}