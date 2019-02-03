package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;

public class PurpleSlime extends EntityBetterSlime{

	public PurpleSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2.5);
		this.setHealthModifier(2);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY)) {
			if (this.world.getBiome(this.getPosition()).equals(b)) {
				return new IceSlime(this.world);
			}
		}
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE)) {
			if (this.world.getBiome(this.getPosition()).equals(b)) {
				return new JungleSlime(this.world);
			}
		}
		for (Biome b : BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY)) {
			if (this.world.getBiome(this.getPosition()).equals(b)) {
				return new SandSlime(this.world);
			}
		}
        return new PurpleSlime(this.world);
    }
	
	@Override
	public boolean getCanSpawnHere()
    {
        if (this.world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(rand, world))
        {
            return false;
        }
        else
        {
            if (this.world.getDifficulty() != EnumDifficulty.PEACEFUL)
            {
            	
            		return true;
            	

            }

            return false;
        }
    }
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}
	
	@Nullable
    protected ResourceLocation getLootTable()
    {
        return this.getSlimeSize() == 1 ? BetterSlimes.purpleSlimeLT : LootTableList.EMPTY;
    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}

}
