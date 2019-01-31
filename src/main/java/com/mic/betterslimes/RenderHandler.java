package com.mic.betterslimes;

import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.RenderSlime;
import com.mic.betterslimes.entity.slimes.*;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHandler {
	
	
	public static void registerEntityRenders(String modID) {
		
		
			RenderingRegistry.registerEntityRenderingHandler(BlueSlime.class, new IRenderFactory<BlueSlime>() {
				@Override
				public Render<? super BlueSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "blue_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(RedSlime.class, new IRenderFactory<RedSlime>() {
				@Override
				public Render<? super RedSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "red_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(YellowSlime.class, new IRenderFactory<YellowSlime>() {
				@Override
				public Render<? super YellowSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "yellow_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(BlackSlime.class, new IRenderFactory<BlackSlime>() {
				@Override
				public Render<? super BlackSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "black_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(PurpleSlime.class, new IRenderFactory<PurpleSlime>() {
				@Override
				public Render<? super PurpleSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "purple_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(SandSlime.class, new IRenderFactory<SandSlime>() {
				@Override
				public Render<? super SandSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "sand_slime", manager);
				}
			});
			RenderingRegistry.registerEntityRenderingHandler(JungleSlime.class, new IRenderFactory<JungleSlime>() {
				@Override
				public Render<? super JungleSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "jungle_slime", manager);
				}
			});
			RenderingRegistry.registerEntityRenderingHandler(IceSlime.class, new IRenderFactory<IceSlime>() {
				@Override
				public Render<? super IceSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "ice_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(SpectralSlime.class, new IRenderFactory<SpectralSlime>() {
				@Override
				public Render<? super SpectralSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "spectral_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(KingSlime.class, new IRenderFactory<KingSlime>() {
				@Override
				public Render<? super KingSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "king_slime", manager);
				}
			});
			
			RenderingRegistry.registerEntityRenderingHandler(IronSlime.class, new IRenderFactory<IronSlime>() {
				@Override
				public Render<? super IronSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "iron_slime", manager);
				}
			});
			RenderingRegistry.registerEntityRenderingHandler(GoldSlime.class, new IRenderFactory<GoldSlime>() {
				@Override
				public Render<? super GoldSlime> createRenderFor(RenderManager manager) {
					return new RenderSlime(modID, "gold_slime", manager);
				}
			});
		
		
		
		
	}
}
