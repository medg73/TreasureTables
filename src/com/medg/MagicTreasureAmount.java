/**
 * 
 */
package com.medg;

/**
 * @author Matthew Grossman
 * @version Sep 3, 2019
 */
public class MagicTreasureAmount extends TreasureAmount {
	
	private double chance; // expressed as 0-1
	private String quantity; // expressed as xdx, eg 2d6, or a single integer
	private String description; // for magic, gems, jewelry
	private MagicTreasure includedTreasure;
	private MagicTreasure excludedTreasure;
	private TreasureColumns treasureColumn;
	
	/**
	 * @param col
	 * @param c
	 * @param q
	 * @param m
	 * @param d
	 */
	public MagicTreasureAmount(TreasureColumns col, double c, String q, int m, String d) {
		super(col, c, q, m, d);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
