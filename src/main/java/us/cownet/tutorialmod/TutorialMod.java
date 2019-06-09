package us.cownet.tutorialmod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import us.cownet.tutorialmod.init.ModItems;

@Mod(modid = TutorialMod.MODID, name = TutorialMod.NAME, version = TutorialMod.VERSION)
public class TutorialMod {
	public static final String MODID = "tutorialmod";
	public static final String NAME = "Cownet Tutorial Mod";
	public static final String VERSION = "1.0";

	@Mod.Instance
	public static TutorialMod instance;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		logger.info(MODID + ":preInit");
		ModItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
		logger.info(MODID + ":init");
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info(MODID + ":postInit");
	}
}
