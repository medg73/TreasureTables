/**
 * 
 */
package com.medg;

/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class Dice {
	
	/**
	 * 
	 * @param quantity either "xdx" or "x"
	 * @param multiplier
	 * @return
	 */
	public static int rollAmount(String quantity, int multiplier) {
		int numRolls;
		int diceType;
		int rv = 0;
	
		
		String[] str = quantity.split("d");
		if(str.length == 2) {
			numRolls = Integer.parseInt(str[0]);
			diceType = Integer.parseInt(str[1]);
		
			for(int i = 0; i < numRolls; i++) {
				rv += (rollDX(diceType, Math.random()) * multiplier);
			}
		}
		else {
			rv = Integer.parseInt(quantity);
		}
		
		return rv;
	}
	
	/**
	 * 
	 * @param x num sides of "dice" to "roll"
	 * @param d1 random # from 0 to 1
	 * @return
	 */
	public static int rollDX(int x, double d1) {
//		double d1 = Math.random();
		if(d1 <= 0.0) {
			d1 = 0.001;
		}
		d1 *= x;
		return((int)Math.ceil(d1));
	}

}