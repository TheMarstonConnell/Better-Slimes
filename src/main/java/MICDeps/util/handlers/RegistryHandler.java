package MICDeps.util.handlers;

import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.slimes.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.util.Random;

public class RegistryHandler {

	public static void initRegistries() {

	}

	public static void preInitRegistries(FMLPreInitializationEvent event) {
		
		ConfigHandler.registerConfig(event);

	}

	public static void serverRegistries(FMLServerStartingEvent event) {
		// event.registerServerCommand(new LoadCommand());
		// event.registerServerCommand(new GenCommand());

	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {

		if (event.getEntity() instanceof EntityBetterSlime) {

			if (!(event.getEntity() instanceof JungleSlime || event.getEntity() instanceof IceSlime
					|| event.getEntity() instanceof SandSlime)) {
				EntityBetterSlime s = (EntityBetterSlime) event.getEntity();
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY)) {
					if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
						s = new IceSlime(event.getWorld());
					}
				}
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE)) {
					if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
						s = new JungleSlime(event.getWorld());
					}
				}
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY)) {
					if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
						s = new SandSlime(event.getWorld());
					}
				}
				if (!s.equals(event.getEntity())) {
					s.setLocationAndAngles(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ,
							event.getEntity().rotationYaw, event.getEntity().rotationPitch);
					s.onInitialSpawn(event.getWorld().getDifficultyForLocation(event.getEntity().getPosition()), (IEntityLivingData) null);
					if (!event.getWorld().isRemote) {
						event.getWorld().spawnEntity(s);
					}
					event.getEntity().setDropItemsWhenDead(false);
					event.getEntity().setDead();
				}
			}

		}
	}

}
