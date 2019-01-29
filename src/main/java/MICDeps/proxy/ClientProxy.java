package MICDeps.proxy;

import com.mic.betterslimes.RenderHandler;

import MICDeps.util.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {

		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(
						"betterslimes" + ":" + item.getRegistryName().toString().replace("betterslimes" + ":", ""),
						"inventory"));
	}

	@SubscribeEvent
	public void onPlayerJoin(TickEvent.PlayerTickEvent event) {

		if (event.player.world.isRemote && event.player == FMLClientHandler.instance().getClientPlayerEntity()) {
			MinecraftForge.EVENT_BUS.unregister(this);
			if (ConfigHandler.startupMessage) {
				event.player.sendMessage(new TextComponentString(TextFormatting.GREEN
						+ "Thank you for installing Better Slimes by milomaz1, follow me on twitter @MarstonConnell for updates!"));
				event.player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.5F, 1.0F);
			}
		}

	}

	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public void registerRenders() {
		RenderHandler.registerEntityRenders("betterslimes");

	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		System.out.println("PreInit Success");
		// ModItems.registerModels();

	}
}
