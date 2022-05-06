package net.acticraft.plugin.beesurvivalextension.SpawnArea;

import net.acticraft.plugin.api.beeapi.regions.PlayerExitRegionEvent;
import net.acticraft.plugin.api.beeapi.regions.Region;
import net.acticraft.plugin.api.beeapi.regions.Regions;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class SpawnRegion implements Listener {

    Location loc1 = new Location(Bukkit.getWorld("Lobby"), 399, 50, 383);
    Location loc2 = new Location(Bukkit.getWorld("Lobby"), -382, 255, -463);
    Region region = new Region("Spawn", loc1, loc2);


    @EventHandler
    public void onRegionEnter(PlayerMoveEvent event) {
        List<Region> RegionList =  Regions.getRegionsInLocation(event.getPlayer().getLocation());
        if(RegionList.contains("region")) {
            event.getPlayer().sendTitle(ChatColor.of("#FFBF00")+"Welcome", ChatColor.of("#FAD5A5")+"You entered spawn region",0, 0, 40);

        }
    }

    @EventHandler
    public void leave(PlayerExitRegionEvent event) {
            event.setCanceled(true);
        event.getPlayer().resetTitle();
    }
}
