package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Biomes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;

public class KnightSlime extends EntityBetterSlime implements ISpecialSlime{

	public KnightSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2);
		this.setHealthModifier(2);
	}
	
	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		// TODO Auto-generated method stub
		super.knockBack(entityIn, 0, xRatio, zRatio);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new KnightSlime(this.world);
	}

	@Override
	public boolean getCanSpawnHere() {

		if (this.world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(rand, world)) {
			return false;
		} else {
			if (this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
				return true;

			}

			return false;
		}
	}

	
//	@Override
//	protected EnumParticleTypes getParticleType() {
//		
//		return EnumParticleTypes.BLOCK_CRACK;
//	}
	
	
	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}

	@Nullable
    protected ResourceLocation getLootTable()
    {
        return this.getSlimeSize() == 1 ? BetterSlimes.knightSlimeLT : LootTableList.EMPTY;
    }
}
