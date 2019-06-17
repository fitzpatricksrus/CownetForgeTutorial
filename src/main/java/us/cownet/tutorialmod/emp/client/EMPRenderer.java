package us.cownet.tutorialmod.emp.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import us.cownet.tutorialmod.TutorialMod;
import us.cownet.tutorialmod.emp.common.EMPProjectile;

import javax.annotation.Nullable;

public class EMPRenderer extends Render<EMPProjectile> {
	private static final ResourceLocation texture = new ResourceLocation(TutorialMod.MODID, "textures/entity/emp.png");
	private ModelBase model;

	public EMPRenderer(RenderManager manager) {
		super(manager);
		model = new EMPProjectileModel();
	}

	@Override
	public void doRender(EMPProjectile entity, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		bindTexture(texture);
		GL11.glTranslated(x, y - 1.25D, z);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EMPProjectile entity) {
		return texture;
	}
}