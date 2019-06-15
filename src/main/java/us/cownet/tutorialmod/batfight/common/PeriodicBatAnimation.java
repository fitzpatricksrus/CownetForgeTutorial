package us.cownet.tutorialmod.batfight.common;

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
	public boolean doStuff() {
		long now = System.currentTimeMillis();
		long elapsedTime = now - lastFrameTime;
		if (elapsedTime > frameDelayMillis) {
			frameIndex = frameIndex + 1;
			lastFrameTime = now;
		}
		return doStuff(elapsedTime, frameIndex);
	}

	protected boolean doStuff(long elapsedTime, int frameIndex) {
		return true;
	}
}
