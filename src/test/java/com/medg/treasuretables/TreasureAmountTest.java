/**
 * 
 */
package com.medg.treasuretables;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.medg.treasuretables.generators.MagicItemGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class TreasureAmountTest {

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
	 * Test method for {@link TreasureAmount#rollAmount()}.
	 */
	@Test
	public final void testCalcResult() {
//		fail("Not yet implemented"); // TODO
		
		TreasureAmount ta = new TreasureAmount(1.0, "1d6", 1, "description test");
		String rv = ta.calcResult();
		assertTrue(rv.matches("[1-6] description test"));
//		System.err.println(rv);
		
		ta = new TreasureAmount(0.0, "1d6", 1, "description test");
		rv = ta.calcResult();
		assertTrue(rv.equals("none"));
//		System.err.println(rv);
		
	}

	@Test
	public void testGetMagicItems() {
		TreasureAmount treasureAmount = new TreasureAmount(TreasureColumns.Magic, 1.0, "", 1,"POTION:3");
		MagicItemGenerator magicItemGenerator = mock(MagicItemGenerator.class);
		treasureAmount.setMagicItemGenerator(magicItemGenerator);
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION)).thenReturn("some magic potion");

		String treasureResult = treasureAmount.calcResult();
		assertEquals("some magic potion, some magic potion, some magic potion", treasureResult);
	}

	@Test
	public void testGetMagicItemsMultipleItemTypes() {
		MagicItemGenerator magicItemGenerator = mock(MagicItemGenerator.class);
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION)).thenReturn("some magic potion");
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.MISC)).thenReturn("some misc item");

		TreasureAmount treasureAmount = new TreasureAmount(TreasureColumns.Magic, 1.0, "", 1,"POTION:1:MISC:1", magicItemGenerator);
		treasureAmount.setMagicItemGenerator(magicItemGenerator);

		String treasureResult = treasureAmount.calcResult();
		assertEquals("some magic potion, some misc item", treasureResult);
	}

}
