package lulzcode;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;

public class LulzCheat {

	private static ArrayList<LulzCheck> checkCheats = new ArrayList<LulzCheck>();
	private EntityPlayer entityplayer;
	public LulzPlayer player;
	
	public LulzCheat(EntityPlayer ep){
		entityplayer = ep;
		player = new LulzPlayer(entityplayer);
		player.update(false);
		/**
		 * Add all new checks here.
		 * All checks MUST implement LulzCheck.
		 */
		checkCheats.add(new LC_flyCheck());
	}
	
	public void doCheck(){
		/** This loop goes through all of the checks and passes them the EntityPlayer object, then updates player variables */
		if(!entityplayer.wasInCreative)
			for (int i = 0; i < checkCheats.size(); i++)
				checkCheats.get(i).handleCheck(player);
		player.update(false);
	}
	
}
