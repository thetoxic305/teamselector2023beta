package me.agent.teamselector;

import com.tomkeuper.bedwars.api.BedWars;
import com.tomkeuper.bedwars.api.addon.Addon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class BedWars2023Support extends Addon {
    BedWars instance = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

    public BedWars2023Support() {
        this.instance.getAddonsUtil().registerAddon(this);
    }

    public String getAuthor() {
        return "AgentNoobff";
    }

    public Plugin getPlugin() {
        return Main.getInstance();
    }

    public String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    public String getDescription() {
        return "Team Selector Add-on for BedWars2023 Minigame.";
    }

    public String getName() {
        return "Team Selector";
    }

    public void load() {
        Bukkit.getPluginManager().enablePlugin(Main.getInstance());
    }

    public void unload() {
        Bukkit.getPluginManager().disablePlugin(Main.getInstance());
    }
}