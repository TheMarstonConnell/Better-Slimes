package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.loot.LootTableList;

public class JungleSlime extends EntityBetterSlime{

	public JungleSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2.5);
		this.setHealthModifier(2.5);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
        return new JungleSlime(this.world);
    }
	
	public boolean getCanSpawnHere()
    {
        BlockPos blockpos = new BlockPos(MathHelper.floor(this.posX), 0, MathHelper.floor(this.posZ));
        Chunk chunk = this.world.getChunkFromBlockCoords(blockpos);

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
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}
	
	@Nullable
    protected ResourceLocation getLootTable()
    {
        return this.getSlimeSize() == 1 ? LootTableList.ENTITIES_SLIME : LootTableList.EMPTY;
    }

}
