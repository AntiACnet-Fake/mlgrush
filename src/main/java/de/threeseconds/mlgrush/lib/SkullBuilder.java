package de.threeseconds.mlgrush.lib;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SkullBuilder {

    private Integer amount;
    private String displayName;
    private List<String> lore;
    private String data;
    private String owner;
    private Boolean glowing = Boolean.valueOf(false);

    public SkullBuilder() {}

    public SkullBuilder(Integer amount) {
        this.amount = amount;
    }

    public SkullBuilder(Integer amount, String displayName) {
        this.amount = amount;
        this.displayName = displayName;
    }

    public SkullBuilder(Integer amount, String displayName, String data) {
        this.amount = amount;
        this.displayName = displayName;
        this.data = data;
    }

    public SkullBuilder(Integer amount, String displayName, String data, String... lore) {
        this.amount = amount;
        this.displayName = displayName;
        this.data = data;
        this.lore = Arrays.asList(lore);
    }

    public org.bukkit.inventory.ItemStack build() {
        org.bukkit.inventory.ItemStack itemStack = new org.bukkit.inventory.ItemStack(Material.SKULL_ITEM, this.amount.intValue(), (short)3);
        SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
        if (this.displayName != null) {
            skullMeta.setDisplayName(this.displayName);
        }
        if (this.lore != null) {
            skullMeta.setLore(this.lore);
        }
        if ((this.data == null) || (this.data.equals(""))) {
            if ((this.owner != null) && (this.owner.equals(""))) {
                skullMeta.setOwner(this.owner);
            }
        } else {
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", this.data));
            Field profileField = null;
            try {
                profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
            } catch (IllegalArgumentException|IllegalAccessException|NoSuchFieldException|SecurityException e) {
                e.printStackTrace();
            }
        }
        itemStack.setItemMeta(skullMeta);

        net.minecraft.server.v1_8_R3.ItemStack itemStack0 = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound nbt = itemStack0.getTag() == null ? new NBTTagCompound() : itemStack0.getTag();
        NBTTagList ench = new NBTTagList();
        if (this.glowing.booleanValue()) {
            nbt.set("ench", ench);
        }
        itemStack0.setTag(nbt);

        return CraftItemStack.asBukkitCopy(itemStack0);
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addLoreString(String lore) {
        if (this.lore == null) {
            this.lore = new ArrayList<>();
        }
        this.lore.add(lore);
    }

    public void removeLoreString(int lore) {
        if (this.lore == null) {
            return;
        }
        this.lore.remove(lore);
    }

    public void removeLoreString(String lore) {
        if (this.lore == null) {
            return;
        }
        this.lore.remove(lore);
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public void setGlowing(Boolean glowing) {
        this.glowing = glowing;
    }

}
