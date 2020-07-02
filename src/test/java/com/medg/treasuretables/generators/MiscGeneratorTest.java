package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.data.MagicTreasureDB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MiscGeneratorTest {

    @Test
    public void testGetMiscItemTextBagOfHolding() {

        List<String> bagTypes = Arrays.asList("250#", "500#", "1000#", "1500#");
        List<Integer> bagTypeRolls = Arrays.asList(30, 31, 71, 91);

        for(int i = 0; i < bagTypes.size(); i++) {
            int roll = bagTypeRolls.get(i);
            Dice dice = mock(Dice.class);
            MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
            when(magicTreasureDB.getBagOfHoldingCapacity(roll)).thenReturn(bagTypes.get(i));
            SpellGenerator spellGenerator = mock(SpellGenerator.class);
            when(dice.rollPercent()).thenReturn(roll);
            String expectedText = "Bag of Holding " + bagTypes.get(i) + " capacity";
            MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator);
            assertEquals(expectedText, miscGenerator.getMiscItemText("Bag of Holding"));
        }
    }

    @Test
    public void testGetMiscItemTextBagOfTricks() {
        List<String> bagTypes = Arrays.asList("type 1", "type 2", "type 3");
        List<Integer> bagTypeRolls = Arrays.asList(5, 8, 9);

        for(int i = 0; i < bagTypes.size(); i++) {
            int roll = bagTypeRolls.get(i);
            Dice dice = mock(Dice.class);
            MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
            when(magicTreasureDB.getBagOfTricksType(roll)).thenReturn(bagTypes.get(i));
            SpellGenerator spellGenerator = mock(SpellGenerator.class);
            when(dice.rollD10()).thenReturn(roll);
            String expectedText = "Bag of Tricks " + bagTypes.get(i);
            MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator);
            assertEquals(expectedText, miscGenerator.getMiscItemText("Bag of Tricks"));
        }
    }

}
