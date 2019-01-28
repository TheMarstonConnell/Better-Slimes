package MICDeps.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;

public class SwordItem extends ItemSword {

	public SwordItem(ItemBuilder itemBuilder, String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(CreativeTabs.COMBAT);

		
		
		itemBuilder.addItem(this);
	}

}
