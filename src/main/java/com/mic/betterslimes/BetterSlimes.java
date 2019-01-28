package com.mic.betterslimes;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.mic.betterslimes.entity.EntityInit;
import com.mic.betterslimes.items.ModItems;

import MICDeps.ModBase;
import MICDeps.items.ItemBuilder;

@Mod(modid = BetterSlimes.MODID, name = BetterSlimes.NAME, version = BetterSlimes.VERSION)
public class BetterSlimes extends ModBase {
	public static final String MODID = "betterslimes";
	public static final String NAME = "Better Slimes";
	public static final String VERSION = "1.0";	
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		itemBuilder = new ItemBuilder(MODID);
		items = new ModItems(itemBuilder);
		EntityInit.registerEntity();
		RenderHandler.registerEntityRenders(MODID);
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

	}
}
