package me.fanhua.piggies.tools.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public final class Items {

	private Items() {}

	public static ItemStack item(Material material, String name, String... lore) {
		var item = new ItemStack(material);
		var meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.stream(lore).toList());
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack item(Material material, int model, String name, String... lore) {
		var item = new ItemStack(material);
		var meta = item.getItemMeta();
		meta.setCustomModelData(model);
		meta.setDisplayName(name);
		meta.setLore(Arrays.stream(lore).toList());
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack unbreakable(ItemStack item) {
		var meta = item.getItemMeta();
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack enchant(ItemStack item) {
		var meta = item.getItemMeta();
		meta.addEnchant(Enchantment.QUICK_CHARGE, 1, true);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack hide(ItemStack item) {
		var meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.values());
		item.setItemMeta(meta);
		return item;
	}

}
