package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
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
        testGetPotionType(dice, "Animal Control*", "potion of avian control (cloudy blue)");
    }

    @Test
    public void testGetPotionOfDragonControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        testGetPotionType(dice, "Dragon Control*", "potion of blue dragon control (cloudy blue)");
    }

    @Test
    public void testGetPotionOfGiantControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        testGetPotionType(dice, "Giant Control*", "potion of stone giant control (cloudy blue)");
    }

    @Test
    public void testGetPotionOfGiantStrength() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(14);
        testGetPotionType(dice, "Giant Strength*(F)", "potion of frost giant strength (F) (cloudy blue)");
    }

    @Test
    public void testGetPotionOfHumanControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(9);
        testGetPotionType(dice, "Human Control*", "potion of half-orc control (cloudy blue)");
    }

    @Test
    public void testGetPotionOfUndeadControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD10()).thenReturn(9);
        testGetPotionType(dice, "Undead Control*", "potion of vampire control (cloudy blue)");
    }

    private void testGetPotionType(Dice dice, String typeText, String expectedText) {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,typeText));
        PotionColorGenerator potionColorGenerator = mock(PotionColorGenerator.class);
        when(potionColorGenerator.getPotionColor()).thenReturn("cloudy blue");
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice, potionColorGenerator);
        String text = potionGenerator.getItemText();
        assertEquals(expectedText, text);
    }

}
