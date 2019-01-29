package com.mic.betterslimes.entity;

import com.mic.betterslimes.entity.slimes.IceSlime;
import com.mic.betterslimes.entity.slimes.JungleSlime;
import com.mic.betterslimes.entity.slimes.SandSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityBetterSlime extends EntitySlime{

	public double attackMod = 1;
	public double healthMod = 1;
	public double speedMod = 1;
	
	public EntityBetterSlime(World worldIn) {
		
		
		
		super(worldIn);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
		
        return new EntityBetterSlime(this.world);
    }
	
	public void setAttackModifier(double mod) {
		this.attackMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}
	
	public void setHealthModifier(double mod) {
		this.healthMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}
	
	public void setSpeedModifier(double mod) {
		this.speedMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}
	
	@Override
	public void setSlimeSize(int size, boolean resetHealth) {
		super.setSlimeSize(size, resetHealth);
		
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size * attackMod));
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)size * speedMod));

        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }
        
	}
	
	@Override
	protected boolean canDamagePlayer()
    {
        return true;
    }
	
	

}
