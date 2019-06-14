package us.cownet.tutorialmod.batfight.common;

import net.minecraft.client.Minecraft;

/*
An interface where a frame only changes once per a given time interval
 */
public class PeriodicBatAnimation implements BatAnimation {
	// system time in ms the last time the frame was drawn
	private long lastFrameTime = 0;
	// how frequently the frame should advance
	private long frameDelayMillis = 1000;
	// the current frame number
	private int frameIndex = -1;

	public PeriodicBatAnimation() {
	}

	public PeriodicBatAnimation(long frameDelayMillis) {
		this.frameDelayMillis = frameDelayMillis;
	}

	@Override
	public boolean doStuff(Minecraft mc) {
		long now = System.currentTimeMillis();
		long elapsedTime = now - lastFrameTime;
		if (elapsedTime > frameDelayMillis) {
			frameIndex = frameIndex + 1;
			lastFrameTime = now;
		}
		return doStuff(mc, elapsedTime, frameIndex);
	}

	protected boolean doStuff(Minecraft mc, long elapsedTime, int frameIndex) {
		return true;
	}
}
