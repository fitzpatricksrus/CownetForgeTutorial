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
import us.cownet.tutorialmod.items.GenericItem;
import us.cownet.tutorialmod.items.ItemBasic;

@Mod(modid = TutorialMod.MODID, name = TutorialMod.NAME, version = TutorialMod.VERSION)
public class TutorialMod {
	public static final String MODID = "tutorialmod";
	public static final String NAME = "Cownet Tutorial Mod";
	public static final String VERSION = "1.0";

	@Mod.Instance
	public static TutorialMod instance;

	public static Logger logger;
	public static GenericItem redDiamond;
	public static GenericBlock purpleOre;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		logger.info(">>" + MODID + ":doPreInit");
		ItemBasic.init();
		redDiamond = new GenericItem("red_diamond");
		purpleOre = new GenericBlock("purple_ore", Material.ROCK);
		BlockBasic.init();
		BatFightClient.proxy.doPreInit();
		logger.info("<<" + MODID + ":doPreInit");
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.info(MODID + ":init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info(MODID + ":postInit");
	}
}
