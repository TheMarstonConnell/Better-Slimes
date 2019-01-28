package MICDeps.armor;

import MICDeps.items.ItemBuilder;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorBase extends ItemArmor {
	
	CreativeTabs tab = CreativeTabs.COMBAT;
	
	public void init(ItemBuilder itemBuilder, String name, CreativeTabs tab) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		itemBuilder.addItem(this);
		
	}
	
	public ArmorBase(ItemBuilder itemBuilder, String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, CreativeTabs tab) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		init(itemBuilder, name, tab);
	}
	
	public ArmorBase(ItemBuilder itemBuilder, String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		init(itemBuilder, name, CreativeTabs.COMBAT);
	}

}
