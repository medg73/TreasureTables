package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.MiscItemTable;
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

        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        List<String> bagTypes = Arrays.asList("250#", "500#", "1000#", "1500#");
        List<Integer> bagTypeRolls = Arrays.asList(30, 31, 71, 91);

        for(int i = 0; i < bagTypes.size(); i++) {
            int roll = bagTypeRolls.get(i);
            Dice dice = mock(Dice.class);
            MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
            when(magicTreasureDB.getMiscItemTableEntry(roll, MiscItemTable.BAG_OF_HOLDING_CAPACITY)).thenReturn(bagTypes.get(i));
            SpellGenerator spellGenerator = mock(SpellGenerator.class);
            when(dice.getAmount("1d100", 1)).thenReturn(roll);
            String expectedText = "Bag of Holding " + bagTypes.get(i) + " capacity";
            MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
            assertEquals(expectedText, miscGenerator.getMiscItemText("Bag of Holding"));
        }
    }

    @Test
    public void testGetMiscItemTextBagOfTricks() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        List<String> bagTypes = Arrays.asList("type 1", "type 2", "type 3");
        List<Integer> bagTypeRolls = Arrays.asList(5, 8, 9);

        for(int i = 0; i < bagTypes.size(); i++) {
            int roll = bagTypeRolls.get(i);
            Dice dice = mock(Dice.class);
            MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
            when(magicTreasureDB.getMiscItemTableEntry(roll, MiscItemTable.BAG_OF_TRICKS_TYPE)).thenReturn(bagTypes.get(i));
            SpellGenerator spellGenerator = mock(SpellGenerator.class);
            when(dice.getAmount("1d10", 1)).thenReturn(roll);
            String expectedText = "Bag of Tricks " + bagTypes.get(i);
            MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
            assertEquals(expectedText, miscGenerator.getMiscItemText("Bag of Tricks"));
        }
    }

    @Test
    public void testGetMiscItemBeakerOfPlentifulPotions() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        when(dice.roll1D4()).thenReturn(1);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(potionGenerator.getItemText()).thenReturn("potion 1").thenReturn("potion 2");
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        assertEquals("beaker of plentiful potions: potion 1, potion 2", miscGenerator.getMiscItemText("beaker of plentiful potions"));
    }

    @Test
    public void testGetMiscItemCandleOfInvocation() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.getAmount("1d9", 1)).thenReturn(3);

        assertEquals("candle of invocation (C) alignment CE", miscGenerator.getMiscItemText("candle of invocation (C)"));
    }

}
