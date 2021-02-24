package de.threeseconds.mlgrush.lib;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private Material material;
    private Integer amount;
    private Short durability;
    private String displayName;
    private Color color;
    private List<String> lore;
    private Boolean glow = false;
    private Boolean unbreakable = false;

    public ItemBuilder(Material material){
        this.material = material;
        this.amount = 1;
        this.durability = (short) 0;
    }

    public ItemBuilder(Material material, Integer amount){
        this.material = material;
        this.amount = amount;
        this.durability = (short) 0;
    }

    public ItemBuilder(Material material, Integer amount, Short durability){
        this.material = material;
        this.amount = amount;
        this.durability = durability;
    }

    public ItemBuilder(Material material, Integer amount, Short durability, String displayName){
        this.material = material;
        this.amount = amount;
        this.durability = durability;
        this.displayName = displayName;
    }

    public ItemBuilder(Material material, Integer amount, Short durability, String displayName, String... lore){
        this.material = material;
        this.amount = amount;
        this.durability = durability;
        this.displayName = displayName;
        this.lore = Arrays.asList(lore);
    }

    public ItemBuilder(Material material, Color color){
        this.material = material;
        this.color = color;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, this.amount, this.durability);

        if(this.color != null) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
            leatherArmorMeta.setColor(color);

            itemStack.setItemMeta(leatherArmorMeta);
            return itemStack;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        if(this.displayName != null){
            itemMeta.setDisplayName(this.displayName);
        }
        if(this.lore != null){
            itemMeta.setLore(this.lore);
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public void addLore(String lore){
        if(this.lore == null){
            this.lore = new ArrayList<>();
        }
        this.lore.add(lore);
    }

    public void removeLore(int lore){
        if(this.lore == null){
            return;
        }
        this.lore.remove(lore);
    }

    public void removeLore(String lore){
        if(this.lore == null){
            return;
        }
        this.lore.remove(lore);
    }

    public void clearLore(){
        if(this.lore == null){
            return;
        }
        this.lore.clear();
    }

    public void setUnbreakable(Boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setDurability(Short durability) {
        this.durability = durability;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public void setGlow(Boolean glow) {
        this.glow = glow;
    }

}
