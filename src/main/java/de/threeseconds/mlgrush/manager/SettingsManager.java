package de.threeseconds.mlgrush.manager;

import de.threeseconds.mlgrush.MLGRush;
import de.threeseconds.mlgrush.lib.ItemBuilder;
import de.threeseconds.mlgrush.lib.Settings;
import de.threeseconds.mlgrush.lib.SkullBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;

public class SettingsManager {

    private MLGRush plugin;

    public SettingsManager(MLGRush plugin) {
        this.plugin = plugin;
    }


    public Inventory setupSettingsGUI() {
        Inventory inventory = Bukkit.createInventory(null, 9*4, "Einstellungen");

        for(int i = 0; i < 9*4; i++) inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15, "").build());

        int x = 9;
        int x1 = 18;

        for(Settings settings : Settings.values()) {
            inventory.setItem(x, settings.getItem().build());

            inventory.setItem(x1, new ItemBuilder(Material.INK_SACK, 1, settings.isEnabled() ? (short)10 : (short)8, settings.isEnabled() ? "§aAktiviert" : "§cDeaktiviert").build());
            x += 1;
            x1 += 1;
        }

        String monitor = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM1ZjcyYWUzNGMwNWJiNTliNGUwMmNiY2UxNmNhMzViZTNlN2EwMmUxMDcwODgwODIyNzFlNmI0YTlmMDcyZiJ9fX0=";

        inventory.setItem(29, new ItemBuilder(Material.ARMOR_STAND, 1, (short)0, "§8> §6Inventarsortierung", " ", "§7Sortiere dein Inventar und passe es so", "§7an deinen eigenen Spielstil an.").build());
        inventory.setItem(31, new SkullBuilder(1, "§8> §4Top-Spieler", monitor, " ", "§7Hier kannst du die Top-Spieler sehen!").build());
        inventory.setItem(33, new ItemBuilder(Material.DIAMOND, 1, (short)0, "§8> §6Perks", " ", "§7Hier findest du Block-Skins, Chatfarben", "§7und Stick-Skins.").build());

        return inventory;
    }

    public Inventory setupInvSortGUI() {
        Inventory inventory = Bukkit.createInventory(null, 9*5, "Inventarsortierung");

        for(int i = 0; i < 9; i++) inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15, "§1").build());
        for(int i = 0; i < 9; i++) inventory.setItem(i + 36, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15, "§1").build());

        inventory.setItem(19, new ItemBuilder(Material.ARMOR_STAND, 1, (short)0, "§7» §6MLGRush").build());
        inventory.setItem(21, new ItemBuilder(Material.ARMOR_STAND, 1, (short)0, "§7» §cKlopper Modus").build());
        inventory.setItem(23, new ItemBuilder(Material.ARMOR_STAND, 1, (short)0, "§7» §eTheBridge").build());
        inventory.setItem(25, new ItemBuilder(Material.ARMOR_STAND, 1, (short)0, "§7» §dStickfight").build());

        return inventory;
    }

    public Inventory setupInvSort(int state) {
        //--- 1: MLGRush
        //--- 2: Klopper Modus
        //--- 3: TheBridge
        //--- 4: Stickfight

        Inventory inventory = null;

        if(state == 1) {
            inventory = Bukkit.createInventory(null, 9, "MLGRush");

            inventory.setItem(0, new ItemBuilder(Material.STICK, 1, (short)0, null, Enchantment.KNOCKBACK, 1).build());
            inventory.setItem(1, new ItemBuilder(Material.WOOD_PICKAXE, 1, (short)0, null, Enchantment.DIG_SPEED, 2).build());

            inventory.setItem(8, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
        } else if(state == 2) {
            inventory = Bukkit.createInventory(null, 9, "Kloppermodus");

            inventory.setItem(0, new ItemBuilder(Material.WOOD_SWORD, 1, (short)0, null).build());
            inventory.setItem(1, new ItemBuilder(Material.FISHING_ROD, 1, (short)0, null).build());
            inventory.setItem(2, new ItemBuilder(Material.WOOD_PICKAXE, 1, (short)0, null, Enchantment.DIG_SPEED, 2).build());

            inventory.setItem(7, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
            inventory.setItem(8, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
        } else if(state == 3) {
            inventory = Bukkit.createInventory(null, 9, "TheBridge");

            inventory.setItem(0, new ItemBuilder(Material.IRON_SWORD, 1, (short)0, null).build());
            inventory.setItem(1, new ItemBuilder(Material.BOW, 1, (short)0, null).build());
            inventory.setItem(2, new ItemBuilder(Material.DIAMOND_PICKAXE, 1, (short)0, null, Enchantment.DIG_SPEED, 1).build());
            inventory.setItem(3, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
            inventory.setItem(4, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
            inventory.setItem(5, new ItemBuilder(Material.GOLDEN_APPLE, 8, (short)0, null).build());

            inventory.setItem(8, new ItemBuilder(Material.ARROW, 1, (short)0, null).build());
        } else if(state == 4) {
            inventory = Bukkit.createInventory(null, 9, "Stickfight");

            inventory.setItem(0, new ItemBuilder(Material.STICK, 1, (short)0, null, Enchantment.KNOCKBACK, 1).build());

            inventory.setItem(8, new ItemBuilder(Material.RED_SANDSTONE, 64, (short)0, null).build());
        }

        return inventory;
    }

    public Inventory setupPerks() {
        Inventory inventory = Bukkit.createInventory(null, 9*5, "Perks");

        for(int i = 0; i < 9; i++) inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15, "§1").build());
        for(int i = 0; i < 9; i++) inventory.setItem(i + 36, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15, "§1").build());

        inventory.setItem(20, new ItemBuilder(Material.SANDSTONE, 1, (short)0, "§6Blöcke").build());
        inventory.setItem(22, new ItemBuilder(Material.PAPER, 1, (short)0, "§cChatfarben").build());
        inventory.setItem(24, new ItemBuilder(Material.STICK, 1, (short)0, "§3Sticks").build());

        return inventory;
    }


}
