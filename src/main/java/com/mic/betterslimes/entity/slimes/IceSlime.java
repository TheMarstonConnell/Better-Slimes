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
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class IceSlime extends EntityBetterSlime implements ISpecialSlime{

	public IceSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2);
		this.setHealthModifier(2);
		this.setSpeedModifier(2.5);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
        return new IceSlime(this.world);
    }
	
	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.BLOCK_SNOW_BREAK;
	}
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}
	
	@Override
	protected EnumParticleTypes getParticleType() {
		
		return EnumParticleTypes.SNOWBALL;
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}
	
	@Nullable
    protected ResourceLocation getLootTable()
    {
        return this.getSlimeSize() == 1 ? BetterSlimes.iceSlimeLT : LootTableList.EMPTY;
    }

}
