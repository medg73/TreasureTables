/**
 * 
 */
package com.medg;

import static org.junit.Assert.*;

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
	 * Test method for {@link com.medg.TreasureAmount#rollAmount()}.
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

}
