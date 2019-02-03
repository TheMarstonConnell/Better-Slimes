package com.mic.betterslimes.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.slimes.IceSlime;
import com.mic.betterslimes.entity.slimes.JungleSlime;
import com.mic.betterslimes.entity.slimes.SandSlime;

import MICDeps.util.handlers.ConfigHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityBetterSlime extends EntitySlime {

	public double attackMod = 1;
	public double healthMod = 1;
	public double speedMod = 1;
	private int tick = 0;
	boolean valentinesDay = false;

	public EntityBetterSlime(World worldIn) {

		super(worldIn);
		Calendar c = Calendar.getInstance();
		valentinesDay = (c.get(Calendar.MONTH) == 1 && c.get(Calendar.DAY_OF_MONTH) == 14);
	}

	@Override
	protected EntityBetterSlime createInstance() {

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
	public void onUpdate() {
		super.onUpdate();
		if(rand.nextInt(6) < this.getSlimeSize() * 2)
		if (valentinesDay) {
			int dis = 6;
			BetterSlimes.proxy.spawnParticle(getEntityWorld(), EnumParticleTypes.HEART,
					this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height - 0.25D,
					this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);

		}

	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();

		if (tick > 200) {
			if (rand.nextInt(ConfigHandler.splitChance) > rand.nextInt(100)) {
				split();
			}
			tick = 0;
		}
		tick++;

	}

	public void split() {
		EntityBetterSlime s = this;
		if (s.getSlimeSize() > 1) {
			EntityBetterSlime p = s.createInstance();
			p.setSlimeSize(1, true);
			p.setLocationAndAngles(this.posX, this.posY + 0.5D, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
			this.world.spawnEntity(p);
		}

	}

	@Override
	public void setSlimeSize(int size, boolean resetHealth) {
		super.setSlimeSize(size, resetHealth);

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) (size * size * attackMod));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue((double) (0.2F + 0.1F * (float) size * speedMod));

		if (resetHealth) {
			this.setHealth(this.getMaxHealth());
		}

	}

	@Override
	protected boolean canDamagePlayer() {
		return true;
	}

}
