package MICDeps.util.handlers;

import java.io.File;

import MICDeps.ModBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	public static Configuration config;
	public static boolean startupMessage = true;
	private static ModBase mod;
	private static String modID;

	public ConfigHandler(ModBase mod, String modID) {
		this.mod = mod;
		this.modID = modID;
	}

	public static void init(File file) {

		config = new Configuration(file);
		String category;

		// Drop chances
		category = "Better Slimes Config";

		startupMessage = config.getBoolean("Start-Up Message?", category, true, "Give a start-up thank you?");

		config.save();

	}

	public static void registerConfig(FMLPreInitializationEvent event) {
		mod.config = new File(event.getModConfigurationDirectory() + "/" + modID);
		mod.config.mkdirs();
		init(new File(mod.config.getPath(), modID + ".cfg"));
	}

}
