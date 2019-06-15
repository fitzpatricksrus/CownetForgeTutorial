package us.cownet.tutorialmod.batfight.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.cownet.tutorialmod.TutorialMod;
import us.cownet.tutorialmod.batfight.common.BatAnimation;
import us.cownet.tutorialmod.batfight.common.BatFight;

import java.util.HashSet;

@SideOnly(Side.CLIENT)
public class BatFightClient extends BatFight {
	private HashSet<BatAnimation> animations = new HashSet<>();

	public void doPreInit() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void attackEntityEventHandler(AttackEntityEvent event) {
		if (event.isCanceled()) return;
		Entity target = event.getTarget();
		if (target.world.isRemote) return;

		TutorialMod.logger.info(">>>>> Player attacked a " + target.getClass().getName());
		if (target instanceof EntityAnimal) {
			animations.add(new BatMessageAnimation());
		}

	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) {
		if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
		Minecraft mc = Minecraft.getMinecraft();
		HashSet<BatAnimation> deadAnimations = new HashSet<>();
		for (BatAnimation b : animations) {
			if (b.doStuff()) {
				deadAnimations.add(b);
			}
		}
		animations.removeAll(deadAnimations);
	}
}
