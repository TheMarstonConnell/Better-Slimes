package com.mic.betterslimes.entity;

import com.mic.betterslimes.entity.slimes.*;

import MICDeps.ModBase;
import MICDeps.util.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EntityInit {
	static ModBase mod;
	static String modID;

	public EntityInit(ModBase mod, String modId) {
		this.mod = mod;
		this.modID = modId;
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int ID, int range, int colorOne,
			int colorTwo) {
		EntityRegistry.registerModEntity(new ResourceLocation(modID + ":" + name), entity, name, ID, mod.instance,
				range, 1, true, colorOne, colorTwo);
	}

	public static void registerEntity() {
		int view = 60;

		registerEntity("blue_slime", BlueSlime.class, 111, view, 1186255, 255);
		registerEntity("red_slime", RedSlime.class, 112, view, 12072506, 16711680);
		registerEntity("yellow_slime", YellowSlime.class, 113, view, 13417984, 16776960);
		registerEntity("black_slime", BlackSlime.class, 114, view, 3552565, 000000);
		registerEntity("purple_slime", PurpleSlime.class, 115, view, 10106269, 9765015);
		registerEntity("ice_slime", IceSlime.class, 116, view, 4293887, 4306175);
		registerEntity("jungle_slime", JungleSlime.class, 117, view, 30464, 55808);
		registerEntity("sand_slime", SandSlime.class, 118, view, 13024949, 14802613);
		registerEntity("spectral_slime", SpectralSlime.class, 119, view, 10106269, 000000);
		registerEntity("king_slime", KingSlime.class, 120, view, 1186255, 16776960);
		registerEntity("iron_slime", IronSlime.class, 121, view, 7172208, 11382677);
		registerEntity("gold_slime", GoldSlime.class, 122, view, 14404608, 16776960);
		registerEntity("knight_slime", KnightSlime.class, 123, view, 7172208, 255);
		registerEntity("haunted_slime", HauntedSlime.class, 124, view, 12072506, 000000);

		addToBiomes();
	}

	public static void addToBiomes() {
		System.out.println("Adding spawns to biomes");
		EntityRegistry.addSpawn(JungleSlime.class, ConfigHandler.jungleSlime, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE);
		EntityRegistry.addSpawn(JungleSlime.class, ConfigHandler.jungleSlime, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE_EDGE);
		EntityRegistry.addSpawn(JungleSlime.class, ConfigHandler.jungleSlime, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE_HILLS);
		EntityRegistry.addSpawn(JungleSlime.class, ConfigHandler.jungleSlime, 1, 6, EnumCreatureType.MONSTER, Biomes.MUTATED_JUNGLE);
		EntityRegistry.addSpawn(JungleSlime.class, ConfigHandler.jungleSlime, 1, 6, EnumCreatureType.MONSTER, Biomes.MUTATED_JUNGLE_EDGE);
		
		EntityRegistry.addSpawn(HauntedSlime.class, ConfigHandler.skySlime, 1, 1, EnumCreatureType.MONSTER, Biomes.HELL);	
		
		EntityRegistry.addSpawn(SpectralSlime.class, ConfigHandler.skySlime, 1, 1, EnumCreatureType.MONSTER, Biomes.SKY);
		
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY)) {
			// System.out.println(b.getBiomeName());
			if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY)))
				EntityRegistry.addSpawn(IceSlime.class, ConfigHandler.iceSlime, 1, 3, EnumCreatureType.MONSTER, b);
		}
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY)) {
			// System.out.println(b.getBiomeName());
			if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY)))
				EntityRegistry.addSpawn(SandSlime.class, ConfigHandler.sandSlime, 1, 6, EnumCreatureType.MONSTER, b);
		}
		for (Biome b : ForgeRegistries.BIOMES.getValuesCollection()) {
			if (!(b.equals(Biomes.HELL) || b.equals(Biomes.SKY))) {
				EntityRegistry.addSpawn(BlueSlime.class, ConfigHandler.blueSlime, 1, 6, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(RedSlime.class, ConfigHandler.redSlime, 1, 5, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(YellowSlime.class, ConfigHandler.yellowSlime, 1, 4, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(PurpleSlime.class, ConfigHandler.purpleSlime, 1, 4, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(BlackSlime.class, ConfigHandler.blackSlime, 1, 6, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(IronSlime.class, ConfigHandler.ironSlime, 1, 2, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(GoldSlime.class, ConfigHandler.goldSlime, 1, 3, EnumCreatureType.MONSTER, b);
				EntityRegistry.addSpawn(KnightSlime.class, ConfigHandler.knightSlime, 1, 7, EnumCreatureType.MONSTER, b);

			}
		}
	}
}
