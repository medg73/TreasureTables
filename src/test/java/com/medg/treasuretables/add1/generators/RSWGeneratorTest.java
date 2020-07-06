package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RSWGeneratorTest {

    @Test
    public void testGetItemTextRodOfAbsorption() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5);
        when(dice.rollD10()).thenReturn(5);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"Rod of Absorption (CM)"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "Rod of Absorption (CM) with 46 remaining levels";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemTextAnyOtherRod() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5);
        when(dice.rollD10()).thenReturn(10);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"any other Rod"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "any other Rod with 41 charges";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemTextStaffOfTheSerpentPython() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5).thenReturn(59);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"Staff of the Serpent (C)"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "Staff of the Serpent (C) - Python";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemTextStaffOfTheSerpentAdder() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5).thenReturn(61);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"Staff of the Serpent (C)"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "Staff of the Serpent (C) - Adder";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemAnyOtherStaff() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5);
        when(dice.roll1D6()).thenReturn(4);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"any other Staff"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "any other Staff with 22 charges";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemTextAnyWand() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5);
        when(dice.rollD20()).thenReturn(20);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"any Wand"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "any Wand with 81 charges";
        assertEquals(expectedText, rswGenerator.getItemText());
    }

    @Test
    public void testGetItemTextAnyWandTrappedToBackfire() {
        Dice dice = mock(Dice.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        when(dice.rollPercent()).thenReturn(5).thenReturn(1);
        when(dice.rollD20()).thenReturn(20);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RSW)).thenReturn(new ItemEntry(1, 1,"any Wand"));

        RSWGenerator rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "any Wand with 81 charges trapped to backfire";
        assertEquals(expectedText, rswGenerator.getItemText());
    }



}
