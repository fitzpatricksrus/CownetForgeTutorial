package us.cownet.tutorialmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.cownet.tutorialmod.TutorialMod;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID)
public class BlockBasic extends Block {
	static Block tutorialBlock;

	public BlockBasic(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public static void init() {
		tutorialBlock = new BlockBasic("blockbasic", Material.ROCK);
		TutorialMod.logger.info("BlockBasic.init");
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(tutorialBlock);
		TutorialMod.logger.info("BlockBasic.registerBlocks");
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(tutorialBlock).setRegistryName(tutorialBlock.getRegistryName()));
		TutorialMod.logger.info("BlockBasic.registerItemBlocks");
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		Item item = Item.getItemFromBlock(tutorialBlock);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		TutorialMod.logger.info("BlockBasic.registerRenders");
	}
}
