package me.agent.teamselector.listeners;

import me.agent.teamselector.api.events.TeamSelectorAbortEvent;
import me.agent.teamselector.api.events.TeamSelectorChooseEvent;
import me.agent.teamselector.teamselector.TeamSelectorGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SelectorGuiUpdateListener implements Listener {

    @EventHandler
    public void onTeamJoin(TeamSelectorChooseEvent e) {
        if (e.isCancelled()) return;
        TeamSelectorGUI.updateGUIs();
    }

    @EventHandler
    public void onAbort(TeamSelectorAbortEvent e) {
        TeamSelectorGUI.updateGUIs();
    }
}
