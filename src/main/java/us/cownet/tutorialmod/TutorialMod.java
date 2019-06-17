package us.cownet.tutorialmod;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import us.cownet.tutorialmod.batfight.client.BatFightClient;
import us.cownet.tutorialmod.blocks.BlockBasic;
import us.cownet.tutorialmod.blocks.GenericBlock;
import us.cownet.tutorialmod.emp.common.EMPGun;
import us.cownet.tutorialmod.items.GenericItem;
import us.cownet.tutorialmod.items.ItemBasic;

@Mod(modid = TutorialMod.MODID, name = TutorialMod.NAME, version = TutorialMod.VERSION)
public class TutorialMod {
	public static final String MODID = "tutorialmod";
	public static final String NAME = "Cownet Tutorial Mod";
	public static final String VERSION = "1.0";

	@Mod.Instance
	public static TutorialMod instance;

	private static Logger logger;
	public static GenericItem redDiamond;
	public static GenericBlock purpleOre;

	public static void logInfo(String info) {
		if (logger != null) logger.info(info);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		logInfo(">>" + MODID + ":doPreInit");
		ItemBasic.init();
		redDiamond = new GenericItem("red_diamond");
		purpleOre = new GenericBlock("purple_ore", Material.ROCK);
		BlockBasic.init();
		BatFightClient.proxy.doPreInit();
		EMPGun.proxy.doPreInit();
		logInfo("<<" + MODID + ":doPreInit");
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logInfo(MODID + ":init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logInfo(MODID + ":postInit");
	}
}
