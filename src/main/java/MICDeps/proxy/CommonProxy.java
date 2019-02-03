package MICDeps.proxy;

import com.mic.betterslimes.RenderHandler;

import MICDeps.util.handlers.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {

	}

	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
	}

	public void init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}
	
	public void registerRenders() {

	}
	
	
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event) {
		RegistryHandler.serverRegistries(event);
	}

	public void spawnParticle(World worldIn, EnumParticleTypes types, double posX, double posY, double posZ, double d1,
			double d2, double d3) {
		// TODO Auto-generated method stub
		
	}

}
