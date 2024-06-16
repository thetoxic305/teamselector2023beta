package me.agent.teamselector;

import com.tomkeuper.bedwars.api.BedWars;
import com.tomkeuper.bedwars.api.addon.Addon;
import me.agent.teamselector.api.TeamSelector;
import me.agent.teamselector.api.TeamSelectorAPI;
import me.agent.teamselector.configuration.Config;
import me.agent.teamselector.configuration.Messages;
import me.agent.teamselector.listeners.ArenaListener;
import me.agent.teamselector.listeners.InventoryListener;
import me.agent.teamselector.listeners.PlayerInteractListener;
import me.agent.teamselector.listeners.SelectorGuiUpdateListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

public class Main extends JavaPlugin {
    public static BedWars bw;
    public static Main plugin;
    public static boolean hasPlaceholderAPI = false;

    /**
     * Register listeners
     */
    private static void registerListeners(Listener... listeners) {
        PluginManager pm = Bukkit.getPluginManager();
        for (Listener l : listeners) {
            pm.registerEvents(l, plugin);
        }
    }


    @Override
    public void onEnable() {
        plugin = this;

        //Disable if pl not found
        if (Bukkit.getPluginManager().getPlugin("BedWars2023") == null) {
            getLogger().severe("BedWars2023 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            hasPlaceholderAPI = false;
        } else {
            hasPlaceholderAPI = true;
            getLogger().info("Successfully hooked into PlaceholderAPI!");
        }

        bw = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

        Bukkit.getServicesManager().register(TeamSelectorAPI.class, new TeamSelector(), this, ServicePriority.Normal);

        getLogger().info("Successfully hooked into BedWars2023!");

        //Create configuration
        Config.addDefaultConfig();

        //Save default messages
        Messages.setupMessages();

        //Register listeners
        registerListeners(new ArenaListener(), new InventoryListener(), new PlayerInteractListener(), new SelectorGuiUpdateListener());
        Metrics metrics = new Metrics(this, 19641);
        BedWars2023Support addonInstance = new BedWars2023Support();
        getServer().getServicesManager().register(Addon.class, addonInstance, Main.getInstance(), ServicePriority.Normal);
    }

    public static Main getInstance() {
        return plugin;
    }
}
