package us.cownet.tutorialmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import us.cownet.tutorialmod.TutorialMod;

public class EMPProjectile extends EntityThrowable {

	private static final String NAME = "emp_projectile";
	private static final int ID = 120;

	public EMPProjectile(World world) {
		super(world);
	}

	public EMPProjectile(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public static void registerModEntity() {
		EntityRegistry.registerModEntity(
				new ResourceLocation(TutorialMod.MODID, NAME),
				EMPProjectile.class,
				NAME,
				ID,
				TutorialMod.instance,
				64,
				10,
				true);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (ticksExisted > 20) {
			explode();
		}

		for (int i = 0; i < 10; i++) {
			double x = (double) (rand.nextInt(10) - 5) / 8.0D;
			double y = (double) (rand.nextInt(10) - 5) / 8.0D;
			double z = (double) (rand.nextInt(10) - 5) / 8.0D;
			this.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, posX, posY, posZ, x, y, z);
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.005F;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		explode();
	}

	private void explode() {
		setDead();
		this.world.createExplosion(this, posX, posY, posZ, 0.75F, true);

/*		// spawn lingering cloud
		EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
		entityareaeffectcloud.setRadius(2.5F);
		entityareaeffectcloud.setRadiusOnUse(-0.5F);
		entityareaeffectcloud.setWaitTime(10);
		entityareaeffectcloud.setDuration(20*10);
		entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());

		this.world.spawnEntity(entityareaeffectcloud);
*/
	}
}