package de.threeseconds.mlgrush;

import de.threeseconds.mlgrush.event.PlayerHandler;
import de.threeseconds.mlgrush.manager.ScoreboardManager;
import de.threeseconds.mlgrush.manager.SettingsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MLGRush extends JavaPlugin {

    private ScoreboardManager scoreboardManager;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        this.init();
    }

    private void init() {
        this.scoreboardManager = new ScoreboardManager(this);
        this.settingsManager = new SettingsManager(this);

        //*** EVENTS ***\\\
        new PlayerHandler(this);


        //*** COMMANDS ***\\\

    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }
}
