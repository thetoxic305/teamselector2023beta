package me.agent.teamselector.configuration;

import com.tomkeuper.bedwars.api.language.Language;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;

public class Messages {

    @SuppressWarnings("WeakerAccess")
    public static final String PATH = "addons.team-selector.";
    public static final String GUI_NAME = PATH + "inventory-name";
    public static final String SELECTOR_NAME = PATH + "selector-name";
    public static final String SELECTOR_LORE = PATH + "selector-lore";
    public static final String CHOICE_NAME = PATH + "choice.name";
    public static final String CHOICE_LORE = PATH + "choice.lore";
    public static final String SWITCH_DISABLED = PATH + "switch-disabled";
    public static final String TEAM_JOIN = PATH + "team-join";
    public static final String TEAM_FULL = PATH + "team-full";
    public static final String TEAM_NOT_BALANCED = PATH + "teams-not-balanced";
    public static final String PARTY_DENIED = PATH + "party-deny";
    public static final String CANT_JOIN_WHILE_STARTING = PATH + "cant-join-while-starting";
    public static final String ALREADY_IN_TEAM = PATH + "already-in-team";

    /**
     * Setup Default Messages
     */
    public static void setupMessages() {
        for (Language l : Language.getLanguages()) {
            addDefault(l, GUI_NAME, "&8Team Selector", "&8Alege o Echipa");
            addDefault(l, SELECTOR_NAME, "&9Team Selector", "&9Alege o Echipa");
            addDefault(l, SELECTOR_LORE, Collections.singletonList("&7Right-Click to to open!"), Collections.singletonList("&7Deschide cu click-dreapta!"));
            addDefault(l, CHOICE_LORE, Arrays.asList("", "&7&o{members}", "", "&eClick to join!"), Arrays.asList("", "&7&o{members}", "", "&eIntra cu Click!"));
            addDefault(l, CHOICE_NAME, "{color}{team} &f({selected}&7/&f{total})", "{color}{team} &f({selected}&7/&f{total})");
            addDefault(l, SWITCH_DISABLED, "%bw_lang_prefix%&cYou cannot change your team!", "%bw_lang_prefix%&cPoti alege echipa o singura data!");
            addDefault(l, TEAM_JOIN, "%bw_lang_prefix%&eYou joined the {color}{team} &eteam!", "%bw_lang_prefix%&eTe-ai alaturat echipei {color}{team}&e!");
            addDefault(l, TEAM_FULL, "%bw_lang_prefix%{color}{team} &c Team is full!", "%bw_lang_prefix%&cEchipa {color}{team} &c este plina!");
            addDefault(l, TEAM_NOT_BALANCED, "%bw_lang_prefix%&cTeams are not balanced! Try joining another team!", "%bw_lang_prefix%&cEchipele nu sunt echilibrate! Incearca alta!");
            addDefault(l, PARTY_DENIED, "%bw_lang_prefix%&cYou can't choose your team because you're in a party!", "%bw_lang_prefix%&cNu poti alege o echipa pentru că te afli intr-un party!");
            addDefault(l, CANT_JOIN_WHILE_STARTING, "%bw_lang_prefix%&cYou cannot join this team at this moment. The game is starting!", "%bw_lang_prefix%&cNu poti intra in aceasta echipa chiar acum. Incepe jocul!");
            addDefault(l, ALREADY_IN_TEAM, "%bw_lang_prefix%&cYou are already in this team!", "%bw_lang_prefix%&cSunteți deja în această echipă");
        }
    }

    private static void addDefault(Language l, String path, Object english, Object romanian) {
        if (!l.exists(path)) {
            l.set(path, l.getIso().equals("ro") ? romanian : english);
        }
    }
}
