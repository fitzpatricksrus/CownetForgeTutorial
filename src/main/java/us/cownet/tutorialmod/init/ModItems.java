package us.cownet.tutorialmod.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.cownet.tutorialmod.TutorialMod;
import us.cownet.tutorialmod.items.ItemBasic;

@Mod.EventBusSubscriber(modid=TutorialMod.MODID)
public class ModItems {
	private static Item tutorialItem;

	public static void init() {
		tutorialItem = new ItemBasic("tutorial_item");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialItem);
	}
}
