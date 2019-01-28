package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class IceSlime extends EntityBetterSlime{

	public IceSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2.5);
		this.setHealthModifier(2);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)getSlimeSize() * 2));
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
        return new IceSlime(this.world);
    }
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * 2.5);
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
        return this.getSlimeSize() == 1 ? BetterSlimes.blueSlimeLT : LootTableList.EMPTY;
    }

}
