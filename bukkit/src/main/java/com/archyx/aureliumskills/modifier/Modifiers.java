package com.archyx.aureliumskills.modifier;

import com.archyx.aureliumskills.AureliumSkills;
import com.archyx.aureliumskills.lang.CommandMessage;
import com.archyx.aureliumskills.lang.Lang;
import com.archyx.aureliumskills.stats.Stat;
import com.archyx.aureliumskills.util.item.ItemUtils;
import com.archyx.aureliumskills.util.item.NBTAPIUser;
import com.archyx.aureliumskills.util.math.NumberUtil;
import com.archyx.aureliumskills.util.text.TextUtil;
import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Modifiers extends NBTAPIUser {

    public Modifiers(AureliumSkills plugin) {
        super(plugin);
    }

    public ItemStack addModifier(ModifierType type, ItemStack item, Stat stat, double value) {
        if (isNBTDisabled()) return item;
        NBTItem nbtItem = new NBTItem(item);
        NBTCompound compound = ItemUtils.getModifiersTypeCompound(nbtItem, type);
        compound.setDouble(getName(stat), value);
        return nbtItem.getItem();
    }

    public ItemStack convertFromLegacy(ItemStack item) {
        if (isNBTDisabled()) return item;
        NBTItem nbtItem = new NBTItem(item);
        for (ModifierType type : ModifierType.values()) {
            List<StatModifier> legacyModifiers = getLegacyModifiers(type, nbtItem);
            if (legacyModifiers.size() > 0) {
                NBTCompound compound = ItemUtils.getModifiersTypeCompound(nbtItem, type);
                for (StatModifier modifier : legacyModifiers) {
                    compound.setDouble(getName(modifier.getStat()), modifier.getValue());
                }
                for (String key : nbtItem.getKeys()) {
                    if (key.startsWith("skillsmodifier-" + type.name().toLowerCase(Locale.ROOT) + "-")) {
                        nbtItem.removeKey(key);
                    }
                }
            }
        }
        return nbtItem.getItem();
    }

    public ItemStack removeModifier(ModifierType type, ItemStack item, Stat stat) {
        if (isNBTDisabled()) return item;
        NBTItem nbtItem = new NBTItem(item);
        NBTCompound compound = ItemUtils.getModifiersTypeCompound(nbtItem, type);
        compound.removeKey(getName(stat));
        ItemUtils.removeParentCompounds(compound);
        return nbtItem.getItem();
    }

    public ItemStack removeAllModifiers(ModifierType type, ItemStack item) {
        if (isNBTDisabled()) return item;
        NBTItem nbtItem = new NBTItem(item);
        NBTCompound compound = ItemUtils.getModifiersTypeCompound(nbtItem, type);
        for (String key : compound.getKeys()) {
            compound.removeKey(key);
        }
        ItemUtils.removeParentCompounds(compound);
        return nbtItem.getItem();
    }

    public List<StatModifier> getLegacyModifiers(ModifierType type, NBTItem nbtItem) {
        if (isNBTDisabled()) return new ArrayList<>();
        List<StatModifier> modifiers = new ArrayList<>();
        for (String key : nbtItem.getKeys()) {
            if (key.contains("skillsmodifier-" + type.name().toLowerCase(Locale.ROOT) + "-")) {
                String[] keySplit = key.split("-");
                if (keySplit.length == 3) {
                    Stat stat = plugin.getStatRegistry().getStat(key.split("-")[2]);
                    if (stat != null) {
                        int value = nbtItem.getInteger(key);
                        modifiers.add(new StatModifier(key, stat, value));
                    }
                } else if (keySplit.length == 4) {
                    Stat stat = plugin.getStatRegistry().getStat(key.split("-")[3]);
                    if (stat != null) {
                        int value = nbtItem.getInteger(key);
                        modifiers.add(new StatModifier(key, stat, value));
                    }
                }
            }
        }
        return modifiers;
    }

    public List<StatModifier> getModifiers(ModifierType type, ItemStack item) {
        if (isNBTDisabled()) return new ArrayList<>();
        NBTItem nbtItem = new NBTItem(item);
        List<StatModifier> modifiers = new ArrayList<>();
        NBTCompound compound = ItemUtils.getModifiersTypeCompound(nbtItem, type);
        for (String key : compound.getKeys()) {
            Stat stat = plugin.getStatRegistry().getStat(key);
            if (stat != null) {
                double value = compound.getDouble(key);
                if (type == ModifierType.ITEM) {
                    modifiers.add(new StatModifier("AureliumSkills.Modifiers.Item." + getName(stat), stat, value));
                } else if (type == ModifierType.ARMOR) {
                    String slot = "Helmet";
                    String mat = item.getType().toString();
                    if (mat.contains("CHESTPLATE")) {
                        slot = "Chestplate";
                    } else if (mat.contains("LEGGINGS")) {
                        slot = "Leggings";
                    } else if (mat.contains("BOOTS")) {
                        slot = "Boots";
                    }
                    modifiers.add(new StatModifier("AureliumSkills.Modifiers.Armor." + slot + "." + getName(stat), stat, value));
                }
            }
        }
        return modifiers;
    }

    public void addLore(ModifierType type, ItemStack item, Stat stat, double value, Locale locale) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            List<String> lore;
            if (meta.getLore() != null) {
                if (meta.getLore().size() > 0) lore = meta.getLore();
                else lore = new LinkedList<>();
            }
            else {
                lore = new LinkedList<>();
            }
            CommandMessage message;
            if (value >= 0) {
                message = CommandMessage.valueOf(type.name() + "_MODIFIER_ADD_LORE");
            } else {
                message = CommandMessage.valueOf(type.name() + "_MODIFIER_ADD_LORE_SUBTRACT");
            }
            lore.add(0, TextUtil.replace(Lang.getMessage(message, locale),
                    "{stat}", stat.getDisplayName(locale),
                    "{value}", NumberUtil.format1(Math.abs(value)),
                    "{color}", stat.getColor(locale)));
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
    }

    public void removeLore(ItemStack item, Stat stat, Locale locale) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            List<String> lore = meta.getLore();
            if (lore != null && lore.size() > 0) lore.removeIf(line -> line.contains(stat.getDisplayName(locale)));
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
    }

    private String getName(Stat stat) {
        return TextUtil.capitalize(stat.name().toLowerCase(Locale.ROOT));
    }
    
}
