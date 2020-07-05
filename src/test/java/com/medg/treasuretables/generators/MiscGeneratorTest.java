package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
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

    @Test
    public void testGetMiscItemCloakOfProtection() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.roll1D4()).thenReturn(4);
        when(dice.getAmount("1d100", 1)).thenReturn(50);
        when(magicTreasureDB.getMiscItemTableEntry(50, MiscItemTable.CLOAK_OF_PROTECTION_VALUE)).thenReturn("+2");

        assertEquals("cloak of protection +2 dwarf, gnome, or halfling size", miscGenerator.getMiscItemText("cloak of protection"));

    }

    @Test
    public void testGetMiscItemIncenseOfMeditation() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.roll1D4()).thenReturn(4).thenReturn(2);

        assertEquals("incense of meditation (C) 6 pieces", miscGenerator.getMiscItemText("incense of meditation (C)"));

    }

    @Test
    public void testGetMiscItemIounStones() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.rollD10()).thenReturn(4);
        when(dice.getAmount("1d20", 1)).thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(20);
        when(magicTreasureDB.getMiscItemTableEntry(1, MiscItemTable.IOUN_STONES_TYPE)).thenReturn("pale blue rhomboid");
        when(magicTreasureDB.getMiscItemTableEntry(2, MiscItemTable.IOUN_STONES_TYPE)).thenReturn("scarlet and blue sphere");
        when(magicTreasureDB.getMiscItemTableEntry(20, MiscItemTable.IOUN_STONES_TYPE)).thenReturn("dull gray ellipsoid");

        assertEquals("4 IOUN Stones: pale blue rhomboid, scarlet and blue sphere, dull gray ellipsoid, dull gray ellipsoid", miscGenerator.getMiscItemText("Ioun Stones"));

    }

    @Test
    public void testGetMiscItemNecklaceOfPrayerBeads() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.roll1D4()).thenReturn(1);
        when(dice.getAmount("1d20", 1)).thenReturn(1).thenReturn(6).thenReturn(1);
        when(magicTreasureDB.getMiscItemTableEntry(1, MiscItemTable.NECKLACE_OF_PRAYER_BEADS_TYPE)).thenReturn("bead 1");
        when(magicTreasureDB.getMiscItemTableEntry(6, MiscItemTable.NECKLACE_OF_PRAYER_BEADS_TYPE)).thenReturn("bead 2");

        assertEquals("Necklace of Prayer Beads (C) with beads of: bead 1, bead 2, bead 1",
                miscGenerator.getMiscItemText("necklace of prayer beads (C)"));

    }

    @Test
    public void testGetMiscItemPearlOfPower() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.rollD20()).thenReturn(1);
        when(dice.getAmount("1d100", 1)).thenReturn(100);
        when(dice.roll1D6()).thenReturn(3).thenReturn(6);
        when(magicTreasureDB.getMiscItemTableEntry(100, MiscItemTable.PEARL_OF_POWER_LEVEL)).thenReturn("2x");

        assertEquals("Pearl of Power (M) level 3 and level 6",
                miscGenerator.getMiscItemText("Pearl of Power (M)"));

    }

    @Test
    public void testGetMiscItemCrystalBall() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.getAmount("1d100", 1)).thenReturn(100);
        when(magicTreasureDB.getMiscItemTableEntry(100, MiscItemTable.CRYSTAL_BALL_TYPE)).thenReturn("crystal ball with telepathy");

        assertEquals("crystal ball with telepathy",
                miscGenerator.getMiscItemText("Crystal Ball (M)"));
    }

    @Test
    public void testGetMiscItemQuaalsFeatherToken() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.getAmount("1d20", 1)).thenReturn(1);
        when(magicTreasureDB.getMiscItemTableEntry(1, MiscItemTable.QUAALS_FEATHER_TOKEN)).thenReturn("anchor");

        assertEquals("Quaal's Feather Token - anchor", miscGenerator.getMiscItemText("quaal's feather token"));

    }

    @Test
    public void testGetMiscItemRobeOfTheArchmagi() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.getAmount("1d100", 1)).thenReturn(1);
        when(magicTreasureDB.getMiscItemTableEntry(1, MiscItemTable.ROBE_OF_THE_ARCHMAGI_COLOR)).thenReturn("white");

        assertEquals("Robe of the Archmagi (M) - white (color not apparent)", miscGenerator.getMiscItemText("robe of the archmagi (M)"));
    }

    @Test
    public void testGetMiscItemRobeOfUsefulItems() {
        PotionGenerator potionGenerator = mock(PotionGenerator.class);
        Dice dice = mock(Dice.class);
        SpellGenerator spellGenerator = mock(SpellGenerator.class);
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);

        MiscGenerator miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator);
        when(dice.roll1D4()).thenReturn(1).thenReturn(1).thenReturn(2).thenReturn(1);
        when(dice.getAmount("1d100", 1)).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(1)
                .thenReturn(2).thenReturn(2).thenReturn(1);
        when(magicTreasureDB.getMiscItemTableEntry(1, MiscItemTable.ROBE_OF_USEFUL_ITEMS_ITEMS)).thenReturn("item 1");
        when(magicTreasureDB.getMiscItemTableEntry(2, MiscItemTable.ROBE_OF_USEFUL_ITEMS_ITEMS)).thenReturn("item 2");
        when(magicTreasureDB.getMiscItemTableEntry(3, MiscItemTable.ROBE_OF_USEFUL_ITEMS_ITEMS)).thenReturn("2x");

        assertEquals("Robe of Useful Items with: item 1, item 2, item 1, item 2, item 2, item 1", miscGenerator.getMiscItemText("robe of useful items"));
    }

}
