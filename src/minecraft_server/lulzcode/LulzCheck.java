package lulzcode;

interface LulzCheck {
	
	/** This is required for all checks, this ensures that each check gets run during player update */
	public abstract void handleCheck(LulzPlayer l);
	
}
