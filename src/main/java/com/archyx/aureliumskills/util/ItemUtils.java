package com.archyx.aureliumskills.util;

import com.archyx.aureliumskills.modifier.ModifierType;
import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ItemUtils {

	public static boolean isArmor(Material material) {
		String materialName = material.name().toLowerCase();
		return materialName.contains("helmet") || materialName.contains("chestplate") || materialName.contains("leggings") || materialName.contains("boots") || materialName.equals("elytra");
	}

	public static boolean isWeapon(Material material) {
		String materialName = material.name().toLowerCase();
		return materialName.contains("sword") || materialName.equals("bow") || materialName.equals("trident") || materialName.equals("crossbow");
	}

	public static boolean isTool(Material material) {
		String materialName = material.name().toLowerCase();
		return materialName.contains("pickaxe") || materialName.contains("axe") || materialName.contains("hoe") || materialName.contains("shovel") || materialName.contains("spade")
				|| materialName.equals("shears") || materialName.equals("fishing_rod") || materialName.equals("flint_and_steel") || materialName.equals("shield")
				|| materialName.contains("on_a_stick");
	}

	public static boolean isAxe(Material material) {
		String materialName = material.name().toLowerCase();
		return materialName.contains("_axe");
	}

	public static boolean isPickaxe(Material material) {
		return material.name().toLowerCase().contains("pickaxe");
	}

	public static boolean isDurable(Material material) {
		return isArmor(material) || isWeapon(material) || isTool(material);
	}

	public static List<String> formatLore(List<String> input) {
		List<String> lore = new ArrayList<>();
		for (String entry : input) {
			lore.addAll(Arrays.asList(entry.split("(\\u005C\\u006E)|(\\n)")));
		}
		return lore;
	}

	public static NBTCompound getCompound(NBTCompound root, String name) {
		NBTCompound compound = root.getCompound(name);
		if (compound == null) {
			compound = root.addCompound(name);
		}
		return compound;
	}

	public static NBTCompound getRootCompound(NBTItem item) {
		NBTCompound compound = item.getCompound("AureliumSkills");
		if (compound == null) {
			compound = item.addCompound("AureliumSkills");
		}
		return compound;
	}

	public static NBTCompound getModifiersCompound(NBTItem item) {
		return getCompound(getRootCompound(item), "Modifiers");
	}

	public static NBTCompound getModifiersTypeCompound(NBTItem item, ModifierType type) {
		return getCompound(getModifiersCompound(item), StringUtils.capitalize(type.name().toLowerCase(Locale.ENGLISH)));
	}

	public static NBTCompound getRequirementsCompound(NBTItem item) {
		return getCompound(getRootCompound(item), "Requirements");
	}

	public static NBTCompound getRequirementsTypeCompound(NBTItem item, ModifierType type) {
		return getCompound(getRequirementsCompound(item), StringUtils.capitalize(type.name().toLowerCase(Locale.ENGLISH)));
	}

	public static void removeParentCompounds(NBTCompound compound) {
		if (compound.getKeys().size() == 0) {
			NBTCompound parent = compound.getParent();
			parent.removeKey(compound.getName());
			if (parent.getKeys().size() == 0) {
				parent.getParent().removeKey(parent.getName());
				if (parent.getParent().getKeys().size() == 0) {
					parent.getParent().getParent().removeKey(parent.getParent().getName());
				}
			}
		}
	}

} 
