package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PotionGeneratorTest {

    @Test
    public void testGetPotionOfAnimalControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"animal control"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of avian control", text);

    }

    @Test
    public void testGetPotionOfDragonControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"dragon control"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of blue dragon control", text);
    }

    @Test
    public void testGetPotionOfGiantControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(8);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"giant control"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of stone giant control", text);
    }

    @Test
    public void testGetPotionOfGiantStrength() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(14);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"giant strength"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of frost giant strength", text);
    }

    @Test
    public void testGetPotionOfHumanControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD20()).thenReturn(9);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"human control"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of half-orc control", text);
    }

    @Test
    public void testGetPotionOfUndeadControl() {
        Dice dice = mock(Dice.class);
        when(dice.rollD10()).thenReturn(9);
        when(dice.rollPercent()).thenReturn(50);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(50, MagicTreasureType.POTION)).thenReturn(new ItemEntry(1,1,"undead control"));
        PotionGenerator potionGenerator = new PotionGenerator(magicTreasureDB, dice);
        String text = potionGenerator.getItemText();
        assertEquals("potion of vampire control", text);
    }

}
