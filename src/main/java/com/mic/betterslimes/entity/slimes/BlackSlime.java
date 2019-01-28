package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.entity.EntityBetterSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;

public class BlackSlime extends EntityBetterSlime {

	public BlackSlime(World worldIn) {
		super(worldIn);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		
		return new BlackSlime(this.world);
	}

	@Override
	public boolean getCanSpawnHere() {

		if (this.world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(rand, world)) {
			return false;
		} else {
			if (this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {

				if (this.posY < 30) {
					return true;
				}

			}

			return false;
		}
	}

	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * 3);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}

}
