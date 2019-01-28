package MICDeps.items;

import MICDeps.util.ModTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item{
	
	/**
	 * Creates Item with name
	 * @param itemBuilder
	 * @param name
	 * @param tab
	 */
	private void init(ItemBuilder itemBuilder, String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(tab);
		
		itemBuilder.addItem(this);
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(itemBuilder.modID + ":" + name, "inventory"));
	}
	
	/**
	 * Creates Item with name, assigns to misc. item tab.
	 * @param itemBuilder
	 * @param name
	 */
	public ItemBase(ItemBuilder itemBuilder, String name) {
		init(itemBuilder, name, CreativeTabs.MISC);
	}
	
	/**
	 * Creates Item with name & assigns a creative tab.
	 * @param itemBuilder
	 * @param name
	 * @param tab
	 */
	public ItemBase(ItemBuilder itemBuilder, String name, ModTab tab) {
		init(itemBuilder, name, tab);
	}
}
