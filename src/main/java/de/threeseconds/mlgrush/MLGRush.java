package de.threeseconds.mlgrush;

import de.threeseconds.mlgrush.event.PlayerHandler;
import de.threeseconds.mlgrush.manager.ScoreboardManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MLGRush extends JavaPlugin {

    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        this.init();
    }

    private void init() {
        this.scoreboardManager = new ScoreboardManager(this);


        //*** EVENTS ***\\\
        new PlayerHandler(this);


        //*** COMMANDS ***\\\

    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
