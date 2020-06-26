/**
 * 
 */
package com.medg.treasuretables;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class DiceTest {

	@Test
	public final void testRollAmount() {
//		fail("Not yet implemented"); // TODO
		
		assertTrue(new Dice(new RandomNumberGenerator()).getAmount("5", 0) == 5);
		assertTrue(new Dice(new RandomNumberGenerator()).getAmount("1d1", 10) == 10);
		
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			int res = new Dice(new RandomNumberGenerator()).getAmount("3d6", 1);
			assertTrue(res >= 3 && res <= 18);
			sum += res;
		}
		double av = (double)(sum / 1000.0);
		System.out.println("Average of 3d6 is: " + av);
		assertTrue(av >= 10.0 && av <= 11.0);
	}

	/**
	 * 
	 */
	@Test
	public final void testDoubletoIntMinInput() {
		int res = new Dice(new RandomNumberGenerator()).doubleToInt(6, 0.0);
		assertEquals(res,1);
	}
	
	@Test
	public final void testDoubleToIntMaxInput() {
		int res = new Dice(new RandomNumberGenerator()).doubleToInt(6, 0.99999);
		assertEquals(res,6);
	}

	@Test
	public void testGetNumInRange() {

	}
	
}
