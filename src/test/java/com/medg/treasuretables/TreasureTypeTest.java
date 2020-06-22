/**
 * 
 */
package com.medg.treasuretables;

import static org.junit.Assert.*;

import java.util.Map;

import com.medg.treasuretables.TreasureAmount;
import com.medg.treasuretables.TreasureColumns;
import com.medg.treasuretables.TreasureType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Matthew Grossman
 * @version Jan 29, 2013
 */
public class TreasureTypeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link TreasureType#genTreasure()}.
	 */
	@Test
	public final void testGenTreasure() {
//		fail("Not yet implemented"); // TODO
		
		TreasureType tta = new TreasureType("Test");
		tta.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(1.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(1.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(1.0, "1d10", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d4", 100, ""));
		tta.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(1.0, "4d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(1.0, "3d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(1.0, "3", 1, "Any 3"));

		String rv = tta.genTreasure();
		System.err.println(rv);
	}

	/**
	 * Test method for {@link TreasureType#loadTreasureTypes()}
	 */
	@Test
	public final void testLoadTreasureTypes() {
//		fail("NYI");
		
		Map<String,TreasureType> treasureTypes = TreasureType.loadTreasureTypes();
		String rv = treasureTypes.get("Test").genTreasure();
		assertTrue(rv != null);
		
		System.err.println(rv);
		
		rv = treasureTypes.get("A").genTreasure();
		assertTrue(rv != null);
		System.err.println(rv);
	
		for(String s : treasureTypes.keySet()) {
			System.err.println("Treasure type " + s + ":");
			System.err.println(treasureTypes.get(s).genTreasure());
		}
		
		
	}
	
	/** test method for {@link TreasureType.getChances()}
	 * 
	 */
	@Test
	public final void testGetChances() {
	//	fail("NYI");
		
		TreasureType tta = new TreasureType("Test");
		tta.addTreasureAmount(TreasureColumns.Copper, new TreasureAmount(1.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Silver, new TreasureAmount(1.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Electrum, new TreasureAmount(0.0, "1d6", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Gold, new TreasureAmount(1.0, "1d10", 1000, ""));
		tta.addTreasureAmount(TreasureColumns.Platinum, new TreasureAmount(0.0, "1d4", 100, ""));
		tta.addTreasureAmount(TreasureColumns.Gems, new TreasureAmount(1.0, "4d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Jewelry, new TreasureAmount(1.0, "3d10", 1, ""));
		tta.addTreasureAmount(TreasureColumns.Magic, new TreasureAmount(1.0, "3", 1, "Any 3"));

		String rv = tta.getChances();
		assertTrue(rv != null);
		System.err.println(rv);
		
	}
}
