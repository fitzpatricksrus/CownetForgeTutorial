package us.cownet.tutorialmod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.cownet.tutorialmod.TutorialMod;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID)
public class ItemBasic extends Item {
	private static Item tutorialItem;

	public static void init() {
		tutorialItem = new ItemBasic("itembasic").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(32);
		TutorialMod.logger.info("ItemBasic.init");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialItem);
		TutorialMod.logger.info("ItemBasic.registerItems");
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(tutorialItem,
				0, new ModelResourceLocation(tutorialItem.getRegistryName(), "inventory"));
		TutorialMod.logger.info("ItemBasic.registerItems");
	}

	public ItemBasic(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
