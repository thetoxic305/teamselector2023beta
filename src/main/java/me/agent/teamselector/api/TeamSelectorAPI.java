package me.agent.teamselector.api;

import com.tomkeuper.bedwars.api.arena.team.ITeam;
import org.bukkit.entity.Player;

public interface TeamSelectorAPI {

    /**
     * Get player's selected team
     */
    ITeam getSelectedTeam(Player player);


    /**
     * Get api version
     */
    int getApiVersion();
}
