package com.mic.betterslimes.entity.slimes;

import javax.annotation.Nullable;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;

public class KingSlime extends EntityBetterSlime implements ISpecialSlime{

	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS));
	private static final DataParameter<Integer> SPAWN_TIME = EntityDataManager.<Integer>createKey(KingSlime.class,
			DataSerializers.VARINT);

	public KingSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(1);
		this.setHealthModifier(26);
		this.setSlimeSize(7, true);
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(SPAWN_TIME, Integer.valueOf(0));
		super.entityInit();
	}

	public int getSpawnTime() {
		return ((Integer) this.dataManager.get(SPAWN_TIME)).intValue();
	}

	public void setSpawnTime(int time) {
		this.dataManager.set(SPAWN_TIME, Integer.valueOf(time));
	}

	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Spawn", this.getSpawnTime());
    }
	
	@Override
	protected void updateAITasks() {
		if (this.getSpawnTime() > 0) {
			int j1 = this.getSpawnTime() - 1;

			if (j1 <= 0) {
	            this.playSound(this.getSquishSound(), (float) (this.getSoundVolume() * 1.2), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
				for(int x = 0; x < 10; x ++)
	            world.spawnParticle(EnumParticleTypes.SLIME, this.posX, this.getEntityBoundingBox().minY, this.posY, 0.0D, 0.0D, 0.0D);
//				this.world.spawnParticle(EnumParticleTypes.SLIME, this.posX, this.posY, this.posZ, 0, 0, 0);
				KnightSlime b;
				for (int x = 0; x < 4; x++) {
					b = new KnightSlime(this.world);
					b.setSlimeSize(2, true);
					b.setLocationAndAngles(this.posX + rand.nextInt(10) - 5, this.posY + rand.nextInt(1) + 1,
							this.posZ + rand.nextInt(10) - 5, this.rotationYaw, this.rotationPitch);
					this.world.spawnEntity(b);
				}
			}

			this.setSpawnTime(j1);
		}else {
			this.setSpawnTime(240);
		}
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);

	}

	public void setCustomNameTag(String name) {
		super.setCustomNameTag(name);
		this.bossInfo.setName(this.getDisplayName());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setSpawnTime(compound.getInteger("Spawn"));
		if (this.hasCustomName()) {
			this.bossInfo.setName(this.getDisplayName());
		}
	}

	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new BlueSlime(this.world);
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
		return BetterSlimes.kingSlimeLT;
	}
}
