/**
 * 
 */
package com.medg.treasuretables;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.generators.MagicItemGenerator;
import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.dice.RandomNumberGenerator;
import org.junit.Test;

/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class TreasureAmountTest {

	@Test
	public final void testCalcResult() {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Dice dice = new Dice(randomNumberGenerator);
		
		TreasureAmount ta = new TreasureAmount(dice, 1.0, "1d6", 1, "description test");
		String rv = ta.calcResult();
		assertTrue(rv.matches("[1-6] description test"));

		ta = new TreasureAmount(dice, 0.0, "1d6", 1, "description test");
		rv = ta.calcResult();
		assertTrue(rv.equals("none"));
	}

	@Test
	public void testGetMagicItems() {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Dice dice = new Dice(randomNumberGenerator);

		TreasureAmount treasureAmount = new TreasureAmount(dice, TreasureColumns.Magic, 1.0, "", 1,"POTION:3");
		MagicItemGenerator magicItemGenerator = mock(MagicItemGenerator.class);
		treasureAmount.setMagicItemGenerator(magicItemGenerator);
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION)).thenReturn("some magic potion");

		String treasureResult = treasureAmount.calcResult();
		assertEquals("some magic potion, some magic potion, some magic potion", treasureResult);
	}

	@Test
	public void testGetMagicItemsMultipleItemTypes() {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Dice dice = new Dice(randomNumberGenerator);

		MagicItemGenerator magicItemGenerator = mock(MagicItemGenerator.class);
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION)).thenReturn("some magic potion");
		when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.MISC)).thenReturn("some misc item");

		TreasureAmount treasureAmount = new TreasureAmount(dice, TreasureColumns.Magic, 1.0, "", 1,"POTION:1:MISC:1", magicItemGenerator);
		treasureAmount.setMagicItemGenerator(magicItemGenerator);

		String treasureResult = treasureAmount.calcResult();
		assertEquals("some magic potion, some misc item", treasureResult);
	}

}
