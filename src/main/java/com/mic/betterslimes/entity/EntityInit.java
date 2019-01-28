package com.mic.betterslimes.entity;

import com.mic.betterslimes.entity.slimes.*;

import MICDeps.ModBase;
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
		int view = 45;
		
		registerEntity("blue_slime", BlueSlime.class, 111, view, 1186255, 255);
		registerEntity("red_slime", RedSlime.class, 112, view, 12072506, 16711680);
		registerEntity("yellow_slime", YellowSlime.class, 113, view, 13417984, 16776960);
		registerEntity("black_slime", BlackSlime.class, 114, view, 3552565, 000000);
		registerEntity("purple_slime", PurpleSlime.class, 115, view, 10106269, 9765015);
		registerEntity("ice_slime", IceSlime.class, 116, view, 4293887, 4306175);
		registerEntity("jungle_slime", JungleSlime.class, 117, view, 30464, 55808);
		registerEntity("sand_slime", SandSlime.class, 118, view, 13024949, 14802613);
		addToBiomes();
	}

	public static void addToBiomes() {
		EntityRegistry.addSpawn(JungleSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE);
		EntityRegistry.addSpawn(JungleSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE_EDGE);
		EntityRegistry.addSpawn(JungleSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, Biomes.JUNGLE_HILLS);
		EntityRegistry.addSpawn(JungleSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, Biomes.MUTATED_JUNGLE);
		EntityRegistry.addSpawn(JungleSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, Biomes.MUTATED_JUNGLE_EDGE);

		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY)) {
			System.out.println(b.getBiomeName());
			EntityRegistry.addSpawn(IceSlime.class, 8, 1, 3, EnumCreatureType.MONSTER, b);
		}
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY)) {
			System.out.println(b.getBiomeName());
			EntityRegistry.addSpawn(SandSlime.class, 20, 1, 6, EnumCreatureType.MONSTER, b);
		}
		for (Biome b : ForgeRegistries.BIOMES.getValuesCollection()) {
			EntityRegistry.addSpawn(BlueSlime.class, 14, 1, 6, EnumCreatureType.MONSTER, b);
			EntityRegistry.addSpawn(RedSlime.class, 8, 1, 5, EnumCreatureType.MONSTER, b);
			EntityRegistry.addSpawn(YellowSlime.class, 6, 1, 4, EnumCreatureType.MONSTER, b);
			EntityRegistry.addSpawn(PurpleSlime.class, 4, 1, 4, EnumCreatureType.MONSTER, b);
			EntityRegistry.addSpawn(BlackSlime.class, 10, 1, 6, EnumCreatureType.MONSTER, b);
		}
	}
}
