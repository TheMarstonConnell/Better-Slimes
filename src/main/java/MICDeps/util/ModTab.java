package MICDeps.util;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs{

	Item icon = Items.GOLD_NUGGET;
	
	public ModTab(String name, Item icon) {
		super(name);
		this.icon = icon;
	}
	
	public ModTab(String name) {
		super(name);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(icon);
	}
	
	

}
