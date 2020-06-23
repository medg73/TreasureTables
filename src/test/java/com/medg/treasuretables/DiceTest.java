/**
 * 
 */
package com.medg.treasuretables;

import static org.junit.Assert.*;

import com.medg.treasuretables.Dice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class DiceTest {

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
	 * Test method for {@link Dice#rollAmount(java.lang.String, int)}.
	 */
	@Test
	public final void testRollAmount() {
//		fail("Not yet implemented"); // TODO
		
		assertTrue(new Dice().rollAmount("5", 0) == 5);
		assertTrue(new Dice().rollAmount("1d1", 10) == 10);
		
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			int res = new Dice().rollAmount("3d6", 1);
			assertTrue(res >= 3 && res <= 18);
			sum += res;
		}
		double av = (double)(sum / 1000.0);
		System.out.println("Average of 3d6 is: " + av);
		assertTrue(av >= 10.0 && av <= 11.0);
	}

	/**
	 * Test method for {@link Dice#rollDX(int)}.
	 */
	@Test
	public final void testRollDX() {
	//	fail("Not yet implemented"); // TODO
		
		int sum = 0;
		for(int i = 0; i < 10000; i++) {
			int res = Dice.rollDX(6, Math.random());
			assertTrue(res >= 1);
			assertTrue(res <= 6);
			sum += res;
		}
		
		
		double av = (double)sum;
		av /= 10000;
		System.out.println("Average is: " + av);
		assertTrue(av >3.0 && av < 4.0);
		
	}
	/**
	 * 
	 */
	@Test
	public final void testRollDXWithMinInput() {
		int res = Dice.rollDX(6, 0.0);
		assertEquals(res,1);
	}
	
	@Test
	public final void testRollDXWithMaxInput() {
		int res = Dice.rollDX(6, 0.99999);
		assertEquals(res,6);
	}

	@Test
	public void testGetNumInRange() {

	}
	
}
