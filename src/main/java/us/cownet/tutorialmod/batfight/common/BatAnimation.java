package us.cownet.tutorialmod.batfight.common;

import net.minecraft.client.Minecraft;

/*
An interface for frame based animation.
 */
public interface BatAnimation {
	//This method should be called repeatedly until the method returns true;
	public boolean doStuff(Minecraft mc);
}
