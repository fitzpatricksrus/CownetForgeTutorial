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
public class GenericItem extends Item {
	private String itemName;

	public GenericItem(String name) {
		this(name, CreativeTabs.MISC, 32);
	}
	public GenericItem(String name, CreativeTabs tab) {
		this(name, tab, 32);
	}
	public GenericItem(String name, int maxStackSize) {
		this(name, CreativeTabs.MISC, maxStackSize);
	}
	public GenericItem(String name, CreativeTabs tab, int maxStackSize) {
		TutorialMod.logger.info(">>" + name+".init");
		itemName = name;
		setUnlocalizedName(itemName);
		setRegistryName(itemName);
		setCreativeTab(tab);
		setMaxStackSize(maxStackSize);
		TutorialMod.logger.info("<<" + itemName+".init");
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(this);
		TutorialMod.logger.info(itemName+".registerItems");
	}

	@SubscribeEvent
	public void registerRenders(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(this,
				0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
		TutorialMod.logger.info(itemName+".registerItems");
	}
}
