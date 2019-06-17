package us.cownet.tutorialmod.emp.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import us.cownet.tutorialmod.items.GenericItem;
import us.cownet.tutorialmod.utilities.InventoryUtils;

//@Mod.EventBusSubscriber(modid = TutorialMod.MODID)
public class EMPGun extends GenericItem {
	@SidedProxy(clientSide = "us.cownet.tutorialmod.emp.client.EMPGunClient",
			serverSide = "us.cownet.tutorialmod.emp.server.EMPGunServer")
	public static EMPGun proxy;

	private static String name = "emp_gun";
	private static String EMPSoundName = "fire_emp";
	private SoundEvent empBlastSound;

	public EMPGun() {
		super(name, CreativeTabs.COMBAT, 1);
		setMaxDamage(0);
	}

	public void doPreInit() {
		empBlastSound = createSoundEvent(EMPSoundName);
		EMPProjectile.registerModEntity();
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		ItemStack itemstack = player.getHeldItem(handIn);
		ItemStack ammo = InventoryUtils.findInInventory(player, ItemArrow.class);
		boolean hasAmmo = !ammo.isEmpty();
		boolean inCreativeMode = player.capabilities.isCreativeMode;

		if (!inCreativeMode && hasAmmo) {
			player.setActiveHand(handIn);
			ammo.grow(-1);
			player.swingArm(handIn);
			world.playSound(player, player.getPosition(), empBlastSound, SoundCategory.PLAYERS, 1.0f, 1.0f);
			if (!world.isRemote) {
				EMPProjectile projectile = new EMPProjectile(world, player);
				Vec3d vec = player.getLookVec();
				projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.6f, 0f);
				world.spawnEntity(projectile);
			}
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		} else if (inCreativeMode) {
			// in creative mode we don't shoot, we just pass the event along
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		} else {
			// out of ammo.  FAIL.
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
	}

	private ItemStack findAmmo(EntityPlayer player) {
		if (this.isEMPRound(player.getHeldItem(EnumHand.OFF_HAND))) {
			return player.getHeldItem(EnumHand.OFF_HAND);
		} else if (this.isEMPRound(player.getHeldItem(EnumHand.MAIN_HAND))) {
			return player.getHeldItem(EnumHand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isEMPRound(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	private boolean isEMPRound(ItemStack stack) {
		return stack.getItem() instanceof ItemArrow;
	}
}
