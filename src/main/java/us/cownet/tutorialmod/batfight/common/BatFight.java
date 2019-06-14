package us.cownet.tutorialmod.batfight.common;

import net.minecraftforge.fml.common.SidedProxy;

/*
Generic BatFight interface used by the main mod.  Just used to initialize the
fight.
 */
public class BatFight {
	@SidedProxy(clientSide = "us.cownet.tutorialmod.batfight.client.BatFightClient",
			serverSide = "us.cownet.tutorialmod.batfight.server.BatFightServer")
	public static BatFight proxy;

	public void doPreInit() {
	}
}
