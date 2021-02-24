package de.threeseconds.mlgrush.lib;

import org.bukkit.Color;
import org.bukkit.Material;

public enum Settings {

    CHAT(true, "Chat", new ItemBuilder(Material.PAPER), new String[] { "§7Soll der Chat angezeigt werden?" }),
    ANFRAGEN(true, "Anfragen", new ItemBuilder(Material.IRON_SWORD), new String[] { "§7Wenn dieses Feature aktiviert ist, bekommt man keine Anfragen mehr." }),
    FALLSCHADEN(false, "Fallschaden", new ItemBuilder(Material.DIAMOND_BOOTS), new String[] { "§7Wenn dieses Feature aktiviert ist, bekommt man in der Runde Fallschaden." }),
    KLOPPER_MODUS(false, "Klopper Modus", new ItemBuilder(Material.GOLDEN_APPLE), new String[] { "§7Eine asndere Art von MLGRush.", " ", "§7Man bekommt eine Ausrüstung, womit man dann den Gegner kaputt kloppen kann.", " ", "§8(§7Dieser Modus war so in der Art mal auf Badlion!§8)" }),
    SCOREBOARD_ANIMATION(true, "Scoreboard-Animation", new ItemBuilder(Material.BEACON), new String[] { "§cErfordert in manchen Fällen einen Rejoin!" }),
    NOHITDELAY(false, "NoHitDelay", new ItemBuilder(Material.POTION, 1, (short)8268), new String[] { "" }),
    SPAWNEN_AM_SPAWN(false, "Spawnen am Spawn", new ItemBuilder(Material.ENDER_PEARL), new String[] { "§7Wenn dieses Feature aktiviert ist, spawnt man nach der Runde wieder am Spawn.", " ", "§cWird aktuell nicht mehr unterstützt!" }),
    ACTIONBAR_ANIMATION(true, "Actionbar-Animation", new ItemBuilder(Material.DAYLIGHT_DETECTOR), new String[] { "" }),
    KNOCKBACK(false, "Nur Knockback nach oben", new ItemBuilder(Material.LEATHER_BOOTS, Color.RED), new String[] { " ", "§7Jeder in der Runde bekommt nur noch Knockback nach oben!", "§7Sehr gut geeignet für Clips!" });

