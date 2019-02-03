package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class SandSlime extends EntityBetterSlime implements ISpecialSlime{

	public SandSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(3);
		this.setHealthModifier(1.8);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
        return new SandSlime(this.world);
    }
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}
	
	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.BLOCK_SAND_PLACE;
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
	}
	
	@Nullable
    protected ResourceLocation getLootTable()
    {
        return this.getSlimeSize() == 1 ? BetterSlimes.sandSlimeLT : LootTableList.EMPTY;
    }

}
