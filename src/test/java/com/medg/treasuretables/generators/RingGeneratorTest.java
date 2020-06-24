package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.SpellCasterClass;
import com.medg.treasuretables.data.MagicTreasureDB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RingGeneratorTest {

    @Test
    public void testGetItemTextRingOfContrariness() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        List<String> contrarinessEffects = Arrays.asList("Flying", "Invisibility", "Levitation", "Shocking Grasp",
            "Spell Turning", "Strength 18/00");
        List<Integer> rolls = Arrays.asList(1, 21, 60, 61, 71, 100);
        for(int i = 0; i < contrarinessEffects.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(roll);
            when(magicTreasureDB.getMagicItemFromDB(roll, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Contrariness"));
            RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
            String expectedText = "ring of contrariness (" + contrarinessEffects.get(i) + ")";
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfElementalCommand() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Elemental Command"));
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        List<String> elementalTypes = Arrays.asList("Air", "Earth", "Fire", "Water");
        List<Integer> rolls = Arrays.asList(1, 2, 3, 4);
        for(int i = 0; i < elementalTypes.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(5);
            when(dice.roll1D4()).thenReturn(roll);
            RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
            String expectedText = "ring of elemental command (" + elementalTypes.get(i) + ")";
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfProtection() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Protection"));
        List<String> protectionTypes = Arrays.asList("+1", "+2", "+2, 5' radius", "+3", "+3, 5' radius",
                "+4 AC, +2 saving throws", "+6 AC, +1 saving throws");
        List<Integer> rolls = Arrays.asList(70, 82, 83, 84, 91, 92, 98);
        for(int i = 0; i < protectionTypes.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(5).thenReturn(roll);
            RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
            String expectedText = "ring of protection " + protectionTypes.get(i);
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfWishes() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Multiple Wishes++"));

        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(5);
        when(dice.roll1D4()).thenReturn(1).thenReturn(3);
        RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "ring of 4 wishes";
        assertEquals(expectedText, ringGenerator.getItemText());

    }

    @Test
    public void testGetItemTextRingOfSpellStoring() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Spell Storing"));

        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(5);
        when(dice.roll1D4()).thenReturn(1).thenReturn(2);
        when(dice.roll1D6()).thenReturn(1).thenReturn(6);
        when(spellGenerator.getSpellcasterClass()).thenReturn(SpellCasterClass.DRUID);
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 1)).thenReturn("Detect Magic");
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 2)).thenReturn("Barkskin");

        RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "ring of spell storing with Druid spells: Detect Magic (1), Barkskin (2)";
        assertEquals(expectedText, ringGenerator.getItemText());
    }

    @Test
    public void testGetItemTextRingOfSpellStoringMUSpells() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(5, MagicTreasureType.RING)).thenReturn(new ItemEntry(1, 1, "Spell Storing"));

        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(5);
        when(dice.roll1D4()).thenReturn(1);
        when(dice.roll1D8()).thenReturn(1).thenReturn(8);
        when(dice.roll1D6()).thenReturn(3);
        when(spellGenerator.getSpellcasterClass()).thenReturn(SpellCasterClass.MAGIC_USER);
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 1)).thenReturn("Detect Magic");
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 3)).thenReturn("Fireball");

        RingGenerator ringGenerator = new RingGenerator(magicTreasureDB, dice, spellGenerator);
        String expectedText = "ring of spell storing with Magic-User spells: Detect Magic (1), Fireball (3)";
        assertEquals(expectedText, ringGenerator.getItemText());

    }
}
