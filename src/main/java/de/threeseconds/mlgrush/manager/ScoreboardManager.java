package de.threeseconds.mlgrush.manager;

import de.threeseconds.mlgrush.MLGRush;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;

public class ScoreboardManager {

    private MLGRush plugin;

    public ScoreboardManager(MLGRush plugin) {
        this.plugin = plugin;
    }

    public void setScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getObjective("objective") != null)
            scoreboard.getObjective("objective").unregister();

        Objective objective = scoreboard.registerNewObjective("objective", "bbb");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§d§lTRAINING");

        ArrayList<String> scores = new ArrayList<>();
        scores.add("§8§m----------------§r");
        scores.add("§e§lSpielmodus:");
        scores.add("§6MLGRush");
        scores.add(" ");
        scores.add("§e§lStats §8§l✖ §b§lTäglich");
        scores.add("§aPlatz: §f#1");
        scores.add("§aLiga: §cBronze III");
        scores.add("§aK/D: §f0.00");
        scores.add("§aWinrate: §2100%");
        scores.add("§8§m----------------");
        scores.add("§6DeineIP.net");

        int count = scores.size() - 1;
        for (String score : scores) {
            objective.getScore(score).setScore(count);
            count--;
        }
        player.setScoreboard(scoreboard);
    }

}
