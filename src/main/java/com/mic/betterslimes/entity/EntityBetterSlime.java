package com.mic.betterslimes.entity;

import com.mic.betterslimes.entity.slimes.IceSlime;
import com.mic.betterslimes.entity.slimes.JungleSlime;
import com.mic.betterslimes.entity.slimes.SandSlime;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityBetterSlime extends EntitySlime{

	public EntityBetterSlime(World worldIn) {
		
		
		
		super(worldIn);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
		
        return new EntityBetterSlime(this.world);
    }
	
	

}
