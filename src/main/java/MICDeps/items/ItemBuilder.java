package MICDeps.items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mic.betterslimes.RenderHandler;

import MICDeps.ModBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber()
public class ItemBuilder {

	public static ArrayList<Item> ModItems;
	public String modID;
	
	public ItemBuilder(String modID) {
		ModItems = new ArrayList<Item>();
		this.modID = modID;
		
		System.out.println("Initialzing Item Builder for " + modID);
	}
	
	public void addItem(Item itemToAdd) {
		ModItems.add(itemToAdd);
	}
	
	public static List<Item> getItemList(){
		return ModItems;
	}
	
	@SubscribeEvent
	public static void newRegistry(final RegistryEvent.NewRegistry event)
	{
		
	}
	@SubscribeEvent
	public void register(final RegistryEvent.Register<Item> event)
	{
		System.out.println("registering");
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		for (Item item : getItemList())
		{
			registry.register(item);
			ModBase.proxy.registerItemRenderer(item, 0, "inventory");
			
//			registerModel(item);
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	private void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(modID + ":" + item.getRegistryName().toString().replace(modID + ":", ""), "inventory"));
	}
	
}
