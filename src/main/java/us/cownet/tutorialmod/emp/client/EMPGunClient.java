package us.cownet.tutorialmod.emp.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.cownet.tutorialmod.emp.common.EMPGun;
import us.cownet.tutorialmod.emp.common.EMPProjectile;

@SideOnly(Side.CLIENT)
public class EMPGunClient extends EMPGun implements IRenderFactory<EMPProjectile> {
	@Override
	public void doPreInit() {
		super.doPreInit();
		RenderingRegistry.registerEntityRenderingHandler(EMPProjectile.class, this);
	}

	@Override
	public Render<? super EMPProjectile> createRenderFor(RenderManager manager) {
		return new EMPRenderer(manager);
	}
}
