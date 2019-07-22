package MICDeps.util.handlers;

import java.util.List;
import java.util.Random;

import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import com.mic.betterslimes.entity.slimes.*;
import com.mic.betterslimes.items.ModItems;

import MICDeps.ModBase;
import MICDeps.items.ItemBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
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
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegistryHandler {

	boolean spawning = false;

	public static void initRegistries() {

	}

	public static void preInitRegistries(FMLPreInitializationEvent event) {

		ConfigHandler.registerConfig(event);

	}

	public static void serverRegistries(FMLServerStartingEvent event) {
		// event.registerServerCommand(new LoadCommand());
		// event.registerServerCommand(new GenCommand());

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ItemBuilder.getItemList()) {
			ModBase.proxy.registerItemRenderer(item, 0, "inventory");
		}
		// for (Block block : ModBlocks.BLOCKS) {
		// if (block instanceof IHasModel) {
		// ((IHasModel) block).registerModels();
		// }
		// }
	}

	@SubscribeEvent
	public void WorldTickEvent(WorldTickEvent event) {
		if (event.world.getTotalWorldTime() > 24000) {
			int day = (int) (event.world.getWorldTime() % 12000);
			if (day == 0) {
				if (event.side.isServer()) {
					List<EntityPlayer> e = event.world.playerEntities;
					
					if (e.size() >= 1) {
						Random rand = new Random();
						EntityPlayer p = e.get(rand.nextInt(e.size()));

						int chance = rand.nextInt(101);
						if (chance <= ConfigHandler.kingChance) {
							System.out.println("Spawning King Slime...");
							KingSlime king = new KingSlime(p.getEntityWorld());
							king.setLocationAndAngles(p.posX - 150 + rand.nextInt(300), p.posY + 5,
									p.posZ - 150 + rand.nextInt(300), p.rotationYaw, p.rotationPitch);

							p.getEntityWorld().spawnEntity(king);
						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {

		if (event.getEntity() instanceof KingSlime) {
			KingSlime k = (KingSlime) event.getEntity();
			System.out.println("King Slime spawned");

			List<EntityPlayer> players = k.world.playerEntities;

			for (EntityPlayer p : players) {
				if (!k.world.isRemote)
					p.sendMessage(new TextComponentString(
							TextFormatting.GREEN + "The King Slime has been summoned near a random player."));
				p.playSound(SoundEvents.AMBIENT_CAVE, 2.5F, 1.0F);
			}

			k.setSlimeSize(9, true);
			k.setAttackModifier(1);
			k.setHealthModifier(40);

		} else if (event.getEntity() instanceof EntityBetterSlime) {

			if (checkSlime(event.getEntity())) {
				EntityBetterSlime s = (EntityBetterSlime) event.getEntity();
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY)) {
					if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY)))
						if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
							s = new IceSlime(event.getWorld());
						}
				}
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE)) {
					if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY)))
						if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
							s = new JungleSlime(event.getWorld());
						}
				}
				for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY)) {
					if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY)))
						if (event.getWorld().getBiome(event.getEntity().getPosition()).equals(b)) {
							s = new SandSlime(event.getWorld());
						}
				}
				if (!s.equals(event.getEntity())) {
					s.setLocationAndAngles(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ,
							event.getEntity().rotationYaw, event.getEntity().rotationPitch);
					s.onInitialSpawn(event.getWorld().getDifficultyForLocation(event.getEntity().getPosition()),
							(IEntityLivingData) null);
					if (!event.getWorld().isRemote) {
						event.getWorld().spawnEntity(s);
					}
					event.getEntity().setDropItemsWhenDead(false);
					event.getEntity().setDead();
				}
			}

		}
	}

	private boolean checkSlime(Entity e) {
		return (!(e instanceof ISpecialSlime));
	}

}
