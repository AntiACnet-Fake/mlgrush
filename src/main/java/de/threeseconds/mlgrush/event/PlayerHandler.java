package de.threeseconds.mlgrush.event;

import de.threeseconds.mlgrush.MLGRush;
import de.threeseconds.mlgrush.lib.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerHandler implements Listener {

    private MLGRush plugin;

    public PlayerHandler(MLGRush plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.setJoinMessage(null);
        this.plugin.getScoreboardManager().setScoreboard(player);

        player.getInventory().clear();
        player.getInventory().setItem(1, new ItemBuilder(Material.DIAMOND_SWORD, 1, (short)0, "§7» §cHerausfordern §8(Linksklick§8)").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.WATCH, 1, (short)0, "§7» §eZuschauen §8(Rechtsklick§8)").build());
        player.getInventory().setItem(7, new ItemBuilder(Material.BOOK, 1, (short)0, "§7» §aEinstellungen §8(Rechtsklick§8)").build());
    }
}
