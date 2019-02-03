package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class SpectralSlime extends EntityBetterSlime implements ISpecialSlime{

	public SpectralSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(4);
		this.setHealthModifier(5.5);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new SpectralSlime(this.world);
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
	
	@Override
	protected EnumParticleTypes getParticleType() {
		
		return EnumParticleTypes.DRAGON_BREATH;
	}

	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.ITEM_ELYTRA_FLYING;
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
	protected ResourceLocation getLootTable() {
		return this.getSlimeSize() == 1 ? BetterSlimes.skySlimeLT : LootTableList.EMPTY;
	}

}
