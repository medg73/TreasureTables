/**
 * 
 */
package com.medg.treasuretables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Grossman
 * @version Jan 24, 2013
 */
public class TreasureType {
	
	private String treasureType;
	
	private Map<TreasureColumns, TreasureAmount> treasureAmounts;
	
	public TreasureType(String type) {
		treasureType = type;
		treasureAmounts = new HashMap<>();
	}
	
	public void addTreasureAmount(TreasureColumns tc, TreasureAmount ta) {
		treasureAmounts.put(tc, ta);
	}
	
	public String genTreasure() {
		String rv = "";
		
		for(TreasureColumns c : TreasureColumns.values()) {
			rv += c.toString() + ": " + treasureAmounts.get(c).calcResult() + "\n";
		}
		
		return rv;
	}
	
	public String getChances() {
		String rv = "";
		for (TreasureColumns c : TreasureColumns.values()) {
			rv += c.toString() + ": " + treasureAmounts.get(c).getChance() + "\t";
		}
		return rv;
	}
	
	public String getTreasureType() {
		return treasureType;
	}

}
