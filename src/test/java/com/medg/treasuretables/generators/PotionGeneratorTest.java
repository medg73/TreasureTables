package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PotionGeneratorTest {

    @Test
    public void testGetPotionOfAnimalControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        testGetPotionType(dice, "animal control", "potion of avian control");
    }

    @Test
    public void testGetPotionOfDragonControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        testGetPotionType(dice, "dragon control", "potion of blue dragon control");
    }

    @Test
    public void testGetPotionOfGiantControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        testGetPotionType(dice, "giant control", "potion of stone giant control");
    }

    @Test
    public void testGetPotionOfGiantStrength() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(14);
        testGetPotionType(dice, "giant strength", "potion of frost giant strength");
    }

    @Test
    public void testGetPotionOfHumanControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(9);
        testGetPotionType(dice, "human control", "potion of half-orc control");
    }

    @Test
    public void testGetPotionOfUndeadControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD10()).thenReturn(9);
        testGetPotionType(dice, "undead control", "potion of vampire control");
    }

    private void testGetPotionType(Dice dice, String typeText, String expectedText) {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,typeText));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals(expectedText, text);
    }

}
