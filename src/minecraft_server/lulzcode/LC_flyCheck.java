package lulzcode;

/**
 * This check attempts to block all forms of flying, floating, etc.
 */

public class LC_flyCheck implements LulzCheck{
	
	public void handleCheck(LulzPlayer l) {
		if((l.player.posY - l.Y > 1.4)
				|| (l.player.posY < l.maxY && l.player.motionY > 0.08)){
			handleHacking(l, 1);
		}
		double yDif = Math.abs(l.Y - l.player.posY) / 2;
		double maxDist = yDif + (l.wasSprinting ? 10 : 8);
		double xDist = Math.abs(l.X - l.player.posX);
		double zDist = Math.abs(l.Z - l.player.posZ);
		double dist = xDist > zDist ? xDist : zDist;
		if(l.checkInAir() && (dist > maxDist)) handleHacking(l, 2);
	}
	
	public void handleHacking(LulzPlayer l, int lulzint){
		System.out.println("Detected " + l.player.username + ": " + lulzint);
		l.player.setPositionAndUpdate(l.X, l.Y, l.Z);
		l.setOnGround();
		l.player.setSprinting(false);
	}

}