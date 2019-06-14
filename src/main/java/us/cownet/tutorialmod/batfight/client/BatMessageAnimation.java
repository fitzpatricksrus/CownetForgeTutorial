package us.cownet.tutorialmod.batfight.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.cownet.tutorialmod.batfight.common.BatFightWords;
import us.cownet.tutorialmod.batfight.common.PeriodicBatAnimation;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class BatMessageAnimation extends PeriodicBatAnimation {
	private static int alphaValue[] = {
			0x00000000,
			0xF0000000,
			0xE0000000,
			0xD0000000,
			0xC0000000,
			0xB0000000,
			0xA0000000,
			0x90000000,
			0x80000000,
			0x70000000,
			0x60000000,
			0x50000000,
			0x40000000,
			0x30000000,
			0x20000000,
			0x10000000,
	};

	private Random rand = new Random();
	private String text = null;
	private float x = -1;
	private float y = -1;

	public BatMessageAnimation() {
		super(62);
	}

	@Override
	protected boolean doStuff(Minecraft mc, long elapsedTime, int frameIndex) {
		if (frameIndex >= alphaValue.length) {
			return true;
		} else {
			ScaledResolution scaled = new ScaledResolution(mc);
			int displayWidth = scaled.getScaledWidth();
			int displayHeight = scaled.getScaledHeight();
			FontRenderer renderer = mc.fontRenderer;

			int color = 0x00FFAA00 | alphaValue[frameIndex % alphaValue.length];

			if (text == null) {
				text = BatFightWords.getWord();
				int textWidth = renderer.getStringWidth(text);
				int xWiggleRoom = displayWidth - textWidth;
				int xWiggle = rand.nextInt(xWiggleRoom);
				x = textWidth / 2 + xWiggle;

				int yWiggleRoom = (displayHeight / 2) - (renderer.FONT_HEIGHT);
				y = rand.nextInt(yWiggleRoom);
			}

			renderer.drawStringWithShadow(text, x, y, color);

			return false;
		}
	}
}
