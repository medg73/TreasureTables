package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.enums.SpellCasterClass;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RingGeneratorTest {

    @Test
    public void testGetItemTextRingOfContrariness() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);

        List<String> contrarinessEffects = Arrays.asList("Flying", "Invisibility", "Levitation", "Shocking Grasp",
            "Spell Turning", "Strength 18/00");
        List<Integer> rolls = Arrays.asList(1, 21, 60, 61, 71, 100);
        for(int i = 0; i < contrarinessEffects.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(roll);
            when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Contrariness");
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of contrariness (" + contrarinessEffects.get(i) + ")";
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfElementalCommand() {
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Elemental Command");
        SpellGenerator spellGenerator = mock(SpellGenerator.class);

        List<String> elementalTypes = Arrays.asList("Air", "Earth", "Fire", "Water");
        List<Integer> rolls = Arrays.asList(1, 2, 3, 4);
        for(int i = 0; i < elementalTypes.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.roll1D4()).thenReturn(roll);
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of elemental command (" + elementalTypes.get(i) + ")";
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfProtection() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("protection");

        List<String> protectionTypes = Arrays.asList("+1", "+2", "+2, 5' radius", "+3", "+3, 5' radius",
                "+4 AC, +2 saving throws", "+6 AC, +1 saving throws");
        List<Integer> rolls = Arrays.asList(70, 82, 83, 84, 91, 92, 98);
        for(int i = 0; i < protectionTypes.size(); i++) {
            int roll = rolls.get(i);
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(roll);
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of protection " + protectionTypes.get(i);
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfWishes() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Multiple Wishes++");

        Dice dice = mock(Dice.class);
        when(dice.roll1D4()).thenReturn(1).thenReturn(3);
        RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
        String expectedText = "ring of 4 wishes";
        assertEquals(expectedText, ringGenerator.getItemText());

    }

    @Test
    public void testGetItemTextRingOfSpellStoring() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Spell Storing");

        Dice dice = mock(Dice.class);
        when(dice.roll1D4()).thenReturn(1).thenReturn(2);
        when(dice.roll1D6()).thenReturn(1).thenReturn(6);
        when(spellGenerator.getSpellcasterClass()).thenReturn(SpellCasterClass.DRUID);
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 1)).thenReturn("Detect Magic");
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 2)).thenReturn("Barkskin");

        RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
        String expectedText = "ring of spell storing with Druid spells: Detect Magic (1), Barkskin (2)";
        assertEquals(expectedText, ringGenerator.getItemText());
    }

    @Test
    public void testGetItemTextRingOfSpellStoringMUSpells() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Spell Storing");

        Dice dice = mock(Dice.class);
        when(dice.roll1D4()).thenReturn(1);
        when(dice.roll1D8()).thenReturn(1).thenReturn(8);
        when(dice.roll1D6()).thenReturn(3);
        when(spellGenerator.getSpellcasterClass()).thenReturn(SpellCasterClass.MAGIC_USER);
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 1)).thenReturn("Detect Magic");
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 3)).thenReturn("Fireball");

        RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
        String expectedText = "ring of spell storing with Magic-User spells: Detect Magic (1), Fireball (3)";
        assertEquals(expectedText, ringGenerator.getItemText());

    }

    @Test
    public void testGetItemTextRingOfTelekinesis() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Telekinesis++");

        List<String> telekinesisTypes = Arrays.asList("20#", "50#", "100#", "200#", "400#");
        List<Integer> rolls = Arrays.asList(25, 26, 51, 90, 100);

        for(int i = 0; i < telekinesisTypes.size(); i++) {
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(rolls.get(i));
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of telekinesis " + telekinesisTypes.get(i);
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfThreeWishes() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Three Wishes++");

        List<String> ringTypes = Arrays.asList("Limited Wishes", "Wishes");
        List<Integer> rolls = Arrays.asList(25, 26);

        for(int i = 0; i < ringTypes.size(); i++) {
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(rolls.get(i));
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of three " + ringTypes.get(i);
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

    @Test
    public void testGetItemTextRingOfWizardry() {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("Wizardry++ (M)");

        List<String> ringTypes = Arrays.asList("1st level spells", "2nd level spells", "3rd level spells",
                "1st and 2nd level spells", "4th level spells", "5th level spells",
                "1st through 3rd level spells", "4th and 5th level spells");
        List<Integer> rolls = Arrays.asList(50, 75, 82, 88, 92, 95, 99, 100);

        for(int i = 0; i < ringTypes.size(); i++) {
            Dice dice = mock(Dice.class);
            when(dice.rollPercent()).thenReturn(rolls.get(i));
            RingGenerator ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
            String expectedText = "ring of wizardry (M): doubles " + ringTypes.get(i);
            assertEquals(expectedText, ringGenerator.getItemText());
        }
    }

}
