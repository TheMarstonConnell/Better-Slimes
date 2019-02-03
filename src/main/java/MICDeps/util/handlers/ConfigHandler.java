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
	
	
	public static int blueSlime = 14;
	public static int redSlime = 7;
	public static int yellowSlime = 4;
	public static int purpleSlime = 2;
	public static int blackSlime = 80;
	public static int iceSlime = 8;
	public static int jungleSlime = 20;
	public static int sandSlime = 20;
	public static int skySlime = 12;
	public static int kingChance = 5;
	public static int ironSlime = 40;
	public static int goldSlime = 20;
	public static int knightSlime = 6;
	public static int splitChance = 50;


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
		kingChance = config.getInt("King Slime Spawn Chance", category, 5, 0, 100, "0 for never and 100 for every night.");
		splitChance = config.getInt("Slime Splitting Chance", category, 50, 0, 100, "0 for never and 100 for always.");

		
		category = "Slime Spawn Chances";
		
		blueSlime = config.getInt("Blue Slime Spawn Chance", category, 14, 0, 100, "0 for never and 100 for always.");
		redSlime = config.getInt("Red Slime Spawn Chance", category, 7, 0, 100, "0 for never and 100 for always.");
		yellowSlime = config.getInt("Yellow Slime Spawn Chance", category, 4, 0, 100, "0 for never and 100 for always.");
		purpleSlime = config.getInt("Purple Slime Spawn Chance", category, 2, 0, 100, "0 for never and 100 for always.");
		blackSlime = config.getInt("Black Slime Spawn Chance", category, 80, 0, 100, "0 for never and 100 for always.");
		iceSlime = config.getInt("Ice Slime Spawn Chance", category, 8, 0, 100, "0 for never and 100 for always.");
		jungleSlime = config.getInt("Jungle Slime Spawn Chance", category, 20, 0, 100, "0 for never and 100 for always.");
		sandSlime = config.getInt("Sand Slime Spawn Chance", category, 20, 0, 100, "0 for never and 100 for always.");
		skySlime = config.getInt("Spectral Slime Spawn Chance", category, 12, 0, 100, "0 for never and 100 for always.");
		ironSlime = config.getInt("Iron Slime Spawn Chance", category, 40, 0, 100, "0 for never and 100 for always.");
		goldSlime = config.getInt("Gold Slime Spawn Chance", category, 20, 0, 100, "0 for never and 100 for always.");
		knightSlime = config.getInt("Knight Slime Spawn Chance", category, 6, 0, 100, "0 for never and 100 for always.");

		
		config.save();

	}

	public static void registerConfig(FMLPreInitializationEvent event) {
		mod.config = new File(event.getModConfigurationDirectory() + "/" + modID);
		mod.config.mkdirs();
		init(new File(mod.config.getPath(), modID + ".cfg"));
	}

}
