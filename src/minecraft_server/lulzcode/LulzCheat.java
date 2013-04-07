package lulzcode;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;

public class LulzCheat {

	public ArrayList<LulzCheck> checkCheats;
	
	public LulzCheat(EntityPlayer ep){
		checkCheats.add(new LC_flyCheck());
	}
	
	public void doCheck(EntityPlayer ep){
		for (int i = 0; i < checkCheats.size(); i++)
			checkCheats.get(i).handleCheck(ep);
	}
	
}
