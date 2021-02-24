package de.threeseconds.mlgrush.event;

import de.threeseconds.mlgrush.MLGRush;
import de.threeseconds.mlgrush.lib.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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
        player.getInventory().setItem(1, new ItemBuilder(Material.DIAMOND_SWORD, 1, (short)0, "§7» §cHerausfordern §8(§7Linksklick§8)").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.WATCH, 1, (short)0, "§7» §eZuschauen §8(§7Rechtsklick§8)").build());
        player.getInventory().setItem(7, new ItemBuilder(Material.BOOK, 1, (short)0, "§7» §aEinstellungen §8(§7Rechtsklick§8)").build());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if(e.getItem() == null) return;
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §aEinstellungen §8(§7Rechtsklick§8)")) {
                e.setCancelled(true);
                player.openInventory(this.plugin.getSettingsManager().setupSettingsGUI());

                return;
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();

        if(e.getCurrentItem() == null) return;
        if(e.getClickedInventory() == null) return;

        if(e.getClickedInventory().getTitle().equalsIgnoreCase("Einstellungen")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8> §6Inventarsortierung")) {
                player.openInventory(this.plugin.getSettingsManager().setupInvSortGUI());
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8> §6Perks")) {
                player.openInventory(this.plugin.getSettingsManager().setupPerks());
                return;
            }
        }
        if(e.getClickedInventory().getTitle().equalsIgnoreCase("Inventarsortierung")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6MLGRush")) {
                player.openInventory(this.plugin.getSettingsManager().setupInvSort(1));
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cKlopper Modus")) {
                player.openInventory(this.plugin.getSettingsManager().setupInvSort(2));
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §eTheBridge")) {
                player.openInventory(this.plugin.getSettingsManager().setupInvSort(3));
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §dStickfight")) {
                player.openInventory(this.plugin.getSettingsManager().setupInvSort(4));
                return;
            }

        }


    }
}
