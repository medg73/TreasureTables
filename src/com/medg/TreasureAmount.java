/**
 * 
 */
package com.medg;

/**
 * @author Matthew Grossman
 * @version Jan 24, 2013
 */
public class TreasureAmount {
	
	private double chance; // expressed as 0-1
	private String quantity; // expressed as xdx, eg 2d6, or a single integer
	private int multiplier; //usually either 1 or 1000
	private String description; // for magic, gems, jewelry
	
	/**
	 * 
	 * @param c chance, expressed as 0-1
	 * @param q expressed as xdx, eg 2d6, or a single integer
	 * @param m usually either 1 or 1000
	 * @param d for magic, gems, jewelry
	 */
	public TreasureAmount(double c, String q, int m, String d) {
		chance = c;
		quantity = q;
		multiplier = m;
		description = d;
	}
	
	public String calcResult() {
		double d1 = Math.random();
		String rv = "none";
		
		if(chance > 0.0 && d1 < chance) {
			int amount = Dice.rollAmount(quantity, multiplier);
			rv = amount + " " + description;
		}
		return rv;
	}
	
	public String getChance() {
		String rv = "";
		if(chance == 0.0) {
			rv = "none";
		}
		else {
			String pct = new Double(chance*100.0).toString() + "%";
			String qty = quantity;
			if(multiplier > 1) {
				qty = qty + "*" + multiplier;
			}
			
			rv = pct + " " + qty + " " + description;
		}
		return rv;
	}
	

	
//	private int rollD6() {
//		double d1 = Math.random();
//	
//		if(d1 <= 0.0) {
//			d1 = 0.1;
//		}
//	
//		d1 *= 6.0;
//	
//		return((int)Math.ceil(d1));
//		
//	}
//	

}
