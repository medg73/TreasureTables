/**
 * 
 */
package com.medg;

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
		treasureAmounts = new HashMap<TreasureColumns, TreasureAmount>();
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
	
	public static Map<String,TreasureType> loadTreasureTypes() {
		Map<String,TreasureType> rv = new HashMap<String,TreasureType>();
		
		TreasureType tta = new TreasureType("A");
		tta.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.25, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.30, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.35, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.40, "1d10", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.25, "1d4", 100, ""));
		tta.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.60, "4d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.50, "3d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.30, "3", 1, "Any 3"));
		rv.put("A", tta);
		
		TreasureType ttb = new TreasureType("B");
		ttb.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.50, "1d8", 1000, ""));
		ttb.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.25, "1d6", 1000, ""));
		ttb.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.25, "1d4", 1000, ""));
		ttb.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.25, "1d3", 1000, ""));
		ttb.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttb.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.30, "1d8", 1, ""));
		ttb.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.20, "1d4", 1, ""));
		ttb.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.10, "1", 1, "Sword, armor, or misc. weapon"));
		rv.put("B", ttb);
		
		TreasureType ttc = new TreasureType("C");
		ttc.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.20, "1d12", 1000, ""));
		ttc.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.30, "1d6", 1000, ""));
		ttc.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.10, "1d4", 1000, ""));
		ttc.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "0", 1000, ""));
		ttc.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttc.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.25, "1d6", 1, ""));
		ttc.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.20, "1d3", 1, ""));
		ttc.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.10, "2", 1, "Any 2"));
		rv.put("C", ttc);
		
		TreasureType ttd = new TreasureType("D");
		ttd.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.10, "1d8", 1000, ""));
		ttd.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.15, "1d12", 1000, ""));
		ttd.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.15, "1d8", 1000, ""));
		ttd.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.50, "1d6", 1000, ""));
		ttd.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttd.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.30, "1d10", 1, ""));
		ttd.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.25, "1d6", 1, ""));
		ttd.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.15, "3", 1, "Any 3 plus 1 potion"));
		rv.put("D", ttd);
		
		TreasureType tte = new TreasureType("E");
		tte.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.05, "1d10", 1000, ""));
		tte.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.25, "1d12", 1000, ""));
		tte.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.25, "1d6", 1000, ""));
		tte.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.25, "1d8", 1000, ""));
		tte.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		tte.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.15, "1d12", 1, ""));
		tte.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry,0.10, "1d8", 1, ""));
		tte.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.25, "4", 1, "Any 3 plus 1 scroll"));
		rv.put("E", tte);
		
		TreasureType ttf = new TreasureType("F");
		ttf.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttf.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.10, "1d20", 1000, ""));
		ttf.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.15, "1d12", 1000, ""));
		ttf.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.40, "1d10", 1000, ""));
		ttf.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.35, "1d8", 100, ""));
		ttf.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.20, "3d10", 1, ""));
		ttf.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.10, "1d10", 1, ""));
		ttf.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.30, "5", 1, "Any 3 except swords or misc weapons plus 1 potion and 1 scroll"));
		rv.put("F", ttf);
		
		TreasureType ttg = new TreasureType("G");
		ttg.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttg.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttg.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttg.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.50, "10d4", 1000, ""));
		ttg.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.50, "1d20", 100, ""));
		ttg.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.30, "5d4", 1, ""));
		ttg.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.25, "1d10", 1, ""));
		ttg.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.35, "5", 1, "Any 4 plus 1 scroll"));
		rv.put("G", ttg);
		
		TreasureType tth = new TreasureType("H");
		tth.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.25, "5d6", 1000, ""));
		tth.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.40, "1d100", 1000, ""));
		tth.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.40, "10d4", 1000, ""));
		tth.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.55, "10d6", 1000, ""));
		tth.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.25, "5d10", 100, ""));
		tth.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.50, "1d100", 1, ""));
		tth.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.50, "10d4", 1, ""));
		tth.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.15, "5", 1, "Any 4 plus 1 potion and 1 scroll"));
		rv.put("H", tth);
		
		TreasureType tti = new TreasureType("I");
		tti.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		tti.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		tti.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 10000, ""));
		tti.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "0", 10000, ""));
		tti.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.30, "3d6", 100, ""));
		tti.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.55, "2d10", 1, ""));
		tti.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.50, "1d12", 1, ""));
		tti.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.15, "1", 1, "Any 1"));
		rv.put("I", tti);
		
		TreasureType ttj = new TreasureType("J");
		ttj.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(1.0, "3d8", 1, "per individual"));
		ttj.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttj.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 10000, ""));
		ttj.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "0", 10000, ""));
		ttj.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttj.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttj.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttj.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("J", ttj);
		
		TreasureType ttk = new TreasureType("K");
		ttk.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttk.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(1.0, "3d6", 1, "per individual"));
		ttk.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 10000, ""));
		ttk.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "0", 10000, ""));
		ttk.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttk.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttk.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttk.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("K", ttk);
		
		TreasureType ttl = new TreasureType("L");
		ttl.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttl.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttl.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(1.0, "2d6", 1, "per individual"));
		ttl.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "0", 10000, ""));
		ttl.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttl.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttl.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttl.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("L", ttl);
		
		TreasureType ttm = new TreasureType("M");
		ttm.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttm.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttm.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "2d6", 1, "per individual"));
		ttm.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(1.0, "2d4", 1, "per individual"));
		ttm.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "0", 100, ""));
		ttm.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttm.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttm.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("M", ttm);
		
		TreasureType ttn = new TreasureType("N");
		ttn.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttn.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1, "per individual"));
		ttn.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "2d6", 1, "per individual"));
		ttn.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1, "per individual"));
		ttn.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(1.0, "1d6", 1, "per individual"));
		ttn.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttn.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttn.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("N", ttn);
		
		TreasureType tto = new TreasureType("O");
		tto.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.25, "1d4", 1000, ""));
		tto.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.20, "1d3", 1000, ""));
		tto.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "2d6", 1, "per individual"));
		tto.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1, "per individual"));
		tto.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d6", 1, "per individual"));
		tto.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		tto.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		tto.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("O", tto);
		
		TreasureType ttp = new TreasureType("P");
		ttp.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttp.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.30, "1d6", 1000, ""));
		ttp.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.25, "1d2", 1000, ""));
		ttp.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1, "per individual"));
		ttp.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d6", 1, "per individual"));
		ttp.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "0", 1, ""));
		ttp.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttp.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("P", ttp);
		
		TreasureType ttq = new TreasureType("Q");
		ttq.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttq.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttq.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttq.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1, "per individual"));
		ttq.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d6", 1, "per individual"));
		ttq.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.50, "1d4", 1, ""));
		ttq.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "0", 1, ""));
		ttq.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("Q", ttq);
		
		TreasureType ttr = new TreasureType("R");
		ttr.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttr.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttr.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttr.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.40, "2d4", 1000, ""));
		ttr.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.50, "10d6", 100, ""));
		ttr.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.55, "4d8", 1, ""));
		ttr.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.45, "1d12", 1, ""));
		ttr.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "0", 1, "Any 1"));
		rv.put("R", ttr);
		
		TreasureType tts = new TreasureType("S");
		tts.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		tts.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		tts.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		tts.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1000, ""));
		tts.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "10d6", 100, ""));
		tts.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "4d8", 1, ""));
		tts.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "1d12", 1, ""));
		tts.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.40, "2d4", 1, "potions"));
		rv.put("S", tts);
		
		TreasureType ttt = new TreasureType("T");
		ttt.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttt.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttt.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttt.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1000, ""));
		ttt.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "10d6", 100, ""));
		ttt.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "4d8", 1, ""));
		ttt.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "1d12", 1, ""));
		ttt.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.50, "1d4", 1, "scrolls"));
		rv.put("T", ttt);
		
		TreasureType ttu = new TreasureType("U");
		ttu.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttu.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttu.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttu.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1000, ""));
		ttu.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "10d6", 100, ""));
		ttu.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.90, "10d8", 1, ""));
		ttu.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.80, "5d6", 1, ""));
		ttu.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.70, "1", 1, "1 of each magic excluding potions and scrolls"));
		rv.put("U", ttu);
		
		TreasureType ttv = new TreasureType("V");
		ttv.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttv.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttv.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttv.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "2d4", 1000, ""));
		ttv.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "10d6", 100, ""));
		ttv.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.00, "10d8", 1, ""));
		ttv.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "5d6", 1, ""));
		ttv.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.85, "2", 1, "2 of each magic excluding potions and scrolls"));
		rv.put("V", ttv);
		
		TreasureType ttw = new TreasureType("W");
		ttw.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttw.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttw.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttw.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.60, "5d6", 1000, ""));
		ttw.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.15, "1d8", 100, ""));
		ttw.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.60, "10d8", 1, ""));
		ttw.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.50, "5d8", 1, ""));
		ttw.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.55, "1", 1, "map"));
		rv.put("W", ttw);
		
		TreasureType ttx = new TreasureType("X");
		ttx.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		ttx.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		ttx.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		ttx.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.0, "5d6", 1000, ""));
		ttx.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d8", 100, ""));
		ttx.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "10d8", 1, ""));
		ttx.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "5d8", 1, ""));
		ttx.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.60, "1", 1, "misc magic"));
		rv.put("X", ttx);
		
		TreasureType tty = new TreasureType("Y");
		tty.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.0, "0", 1000, ""));
		tty.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.0, "0", 1000, ""));
		tty.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "0", 1000, ""));
		tty.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.70, "2d6", 1000, ""));
		tty.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d8", 100, ""));
		tty.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.0, "10d8", 1, ""));
		tty.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.0, "5d8", 1, ""));
		tty.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.0, "1", 1, "misc magic"));
		rv.put("Y", tty);
		
		TreasureType ttz = new TreasureType("Z");
		ttz.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(0.20, "1d3", 1000, ""));
		ttz.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(0.25, "1d4", 1000, ""));
		ttz.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.25, "1d4", 1000, ""));
		ttz.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(0.30, "1d4", 1000, ""));
		ttz.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.30, "1d6", 100, ""));
		ttz.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 0.55, "10d6", 1, ""));
		ttz.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 0.50, "5d6", 1, ""));
		ttz.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(0.50, "3", 3, "Any 3 magic"));
		rv.put("Z", ttz);
	
		TreasureType ttTest = new TreasureType("Test");
		ttTest.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(1.0, "1d6", 1000, ""));
		ttTest.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(1.0, "1d6", 1000, ""));
		ttTest.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "1d6", 1000, ""));
		ttTest.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(1.0, "1d10", 1000, ""));
		ttTest.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d4", 100, ""));
		ttTest.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(TreasureColumns.Gems, 1.0, "4d10", 1, ""));
		ttTest.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(TreasureColumns.Jewelry, 1.0, "3d10", 1, ""));
		ttTest.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(1.0, "3", 1, "Any 3"));
		rv.put("Test", ttTest);
		
		
		return rv;
	}

}
