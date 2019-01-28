package MICDeps;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;

import com.mic.betterslimes.items.ModItems;

import MICDeps.items.ItemBuilder;
import MICDeps.proxy.CommonProxy;
import MICDeps.util.handlers.RegistryHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBase {

	public static final String CLIENT_PROXY_CLASS = "MICDeps.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "MICDeps.proxy.CommonProxy";

	public static ItemBuilder itemBuilder;
	public static ModItems items;
	
	private static Logger logger;

	public static File config;
	static RegistryHandler eventHandler;

	@Mod.Instance()
	public static ModBase instance;

	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
		logger = event.getModLog();
		eventHandler = new RegistryHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		eventHandler.preInitRegistries(event);
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		eventHandler.initRegistries();
		proxy.init(event);
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
		RegistryHandler.serverRegistries(event);
	}
	
	
}
