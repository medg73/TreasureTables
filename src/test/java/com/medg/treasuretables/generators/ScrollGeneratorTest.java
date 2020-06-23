package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.SpellCasterClass;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ScrollGeneratorTest {

    @Test
    public void testGetScrollOfProtectionFromElementals() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(15);
        testGetScrollType(dice, "protection from elementals", "scroll of protection from air elementals");
    }

    @Test
    public void testGetScrollOfProtectionFromLycanthropes() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(15);
        testGetScrollType(dice, "Protection from Lycanthropes", "scroll of protection from wererats");
    }

    @Test
    public void testGetMagicUserSpellScroll() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(15);
        when(dice.getNumInLinearRange(2,9)).thenReturn(2).thenReturn(3).thenReturn(4);
        String scrollText = "spell 3:2-9:2-7";
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 2)).thenReturn("Invisibility");
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 3)).thenReturn("Fireball");
        when(spellGenerator.getRandomSpell(SpellCasterClass.MAGIC_USER, 4)).thenReturn("Ice Storm");

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,scrollText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        assertEquals("Magic-User scroll with spells: Invisibility (2), Fireball (3), Ice Storm (4)", scrollGenerator.getItemText());
    }

    @Test
    public void testGetClericSpellScroll() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(75);
        when(dice.getNumInLinearRange(2,7)).thenReturn(2).thenReturn(3).thenReturn(7);
        String scrollText = "spell 3:2-9:2-7";
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        when(spellGenerator.getRandomSpell(SpellCasterClass.CLERIC, 2)).thenReturn("Augury");
        when(spellGenerator.getRandomSpell(SpellCasterClass.CLERIC, 3)).thenReturn("Cure Disease");
        when(spellGenerator.getRandomSpell(SpellCasterClass.CLERIC, 7)).thenReturn("Gate");

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,scrollText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        assertEquals("Cleric scroll with spells: Augury (2), Cure Disease (3), Gate (7)", scrollGenerator.getItemText());
    }

    @Test
    public void testGetIllusionistSpellScroll() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(5);
        when(dice.getNumInLinearRange(1,4)).thenReturn(2);
        String scrollText = "spell 1:1-4:1-4";
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        when(spellGenerator.getRandomSpell(SpellCasterClass.ILLUSIONIST, 2)).thenReturn("Blindness");

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,scrollText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        assertEquals("Illusionist scroll with spells: Blindness (2)", scrollGenerator.getItemText());
    }

    @Test
    public void testGetDruidSpellScroll() {
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(75).thenReturn(75).thenReturn(5);
        when(dice.getNumInLinearRange(2,7)).thenReturn(2).thenReturn(3).thenReturn(7);
        String scrollText = "spell 3:2-9:2-7";
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 2)).thenReturn("Barkskin");
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 3)).thenReturn("Call Lightning");
        when(spellGenerator.getRandomSpell(SpellCasterClass.DRUID, 7)).thenReturn("Animate Rock");

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,scrollText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        assertEquals("Druid scroll with spells: Barkskin (2), Call Lightning (3), Animate Rock (7)", scrollGenerator.getItemText());
    }
    private void testGetScrollType(Dice dice, String typeText, String expectedText) {
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,typeText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        String text = scrollGenerator.getItemText();
        assertEquals(expectedText, text);
    }
}
