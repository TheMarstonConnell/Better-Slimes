package com.mic.betterslimes.items;

import MICDeps.items.ItemBase;
import MICDeps.items.ItemBuilder;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {

	Item blue_slime;
	Item red_slime;
	Item yellow_slime;
	Item purple_slime;
	Item black_slime;
	
	public ModItems(ItemBuilder i) {
		Item null_item = new ItemBase(i, "null_item", null);
		red_slime = new ItemBase(i, "red_slime");
		purple_slime = new ItemBase(i, "purple_slime");
		yellow_slime = new ItemBase(i, "yellow_slime");
		black_slime = new ItemBase(i, "black_slime");
		blue_slime = new ItemBase(i, "blue_slime");
	}
	
	public void oreDict() {
		OreDictionary.registerOre("slimeball", blue_slime);
		OreDictionary.registerOre("slimeball", black_slime);
		OreDictionary.registerOre("slimeball", yellow_slime);
		OreDictionary.registerOre("slimeball", red_slime);
		OreDictionary.registerOre("slimeball", purple_slime);
	}
}
