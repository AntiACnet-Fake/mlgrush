package de.threeseconds.mlgrush.lib;

import org.bukkit.Art;
import org.bukkit.Color;
import org.bukkit.Material;

public enum Settings {

    CHAT(true, new ItemBuilder(Material.PAPER, 1, (short)0, "§8> §6Chat", "§7Soll der Chat angezeigt werden?")),
    ANFRAGEN(true, new ItemBuilder(Material.IRON_SWORD, 1, (short)0, "§8> §6Anfragen", "§7Wenn dieses Feature aktiviert ist, bekommt man", "§7keine Anfragen mehr.")),
    FALLSCHADEN(false, new ItemBuilder(Material.DIAMOND_BOOTS, 1, (short)0, "§8> §6Fallschaden", "§7Wenn dieses Feature aktiviert ist, bekommt man", "§7in der Runde Fallschaden.")),
    KLOPPER_MODUS(false, new ItemBuilder(Material.GOLDEN_APPLE, 1, (short)0, "§8> §6Klopper Modus", "§7Eine andere Art von MLGRush.", " ", "§7Man bekommt eine Ausrüstung,", "§7womit man dann den Gegner kaputt kloppen", "§7kann.", " ", "§8(§7Dieser Modus war so in der Art", "§7mal auf Badlion!§8)")),
    SCOREBOARD_ANIMATION(true, new ItemBuilder(Material.BEACON, 1, (short)0, "§8> §6Scoreboard-Animation", "§cErfordert in manchen Fällen einen Rejoin!")),
    NOHITDELAY(false, new ItemBuilder(Material.POTION, 1, (short) 8268, "§8> §6NoHitDelay", "")),
    SPAWNEN_AM_SPAWN(false, new ItemBuilder(Material.ENDER_PEARL, 1, (short)0, "§8> §6Spawnen am Spawn", "§7Wenn dieses Feature aktiviert ist, spawnt man", "§7nach der Runde wieder am Spawn.", " ", "§cWird aktuell nicht mehr unterstützt!")),
    ACTIONBAR_ANIMATION(true, new ItemBuilder(Material.DAYLIGHT_DETECTOR, 1, (short)0, "§8> §6Actionbar-Animation", "")),
    KNOCKBACK(false, new ItemBuilder(Material.LEATHER_BOOTS, Color.RED, "§8> §4Nur Knockback nach oben", " ", "§7Jeder in der Runde bekommt nur noch", "§7Knockback nach oben!", "§7Sehr gut geeignet für Clips!"));


    public boolean enabled;
    private ItemBuilder item;

    Settings(boolean enabled, ItemBuilder item) {
        this.enabled = enabled;
        this.item = item;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public ItemBuilder getItem() {
        return item;
    }
}