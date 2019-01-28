package com.mic.betterslimes.entity;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderSlime extends RenderLiving<EntityBetterSlime> {
	
	String modID;
	String name;
	
	
	
	public final String TEXTURES = ":textures/entity/slime/";

	public RenderSlime(String modId, String name, RenderManager manager) 
	{
		
		super(manager, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerSlimeGel(this));
		this.modID = modId;	
		this.name = name;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBetterSlime entity) {
		return new ResourceLocation(modID + TEXTURES + name + ".png");
	}

	@Override
	protected void applyRotations(EntityBetterSlime entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	public void doRender(EntityBetterSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * (float)entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityBetterSlime entitylivingbaseIn, float partialTickTime)
    {
        float f = 0.999F;
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
	
}
	
