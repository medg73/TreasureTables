package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SwordGeneratorTest {

    @Test
    public void testGetMagicSword() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("none:none:none");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 (NSA)", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithPrimaryAbilities() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("13:2:empathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("primary 2");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 13 alignment: CG communication: empathy primary abilities: primary 1, primary 2", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithPrimaryAbilitiesRollTwice() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("13:2:empathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("roll twice").thenReturn("primary 2").thenReturn("roll twice").thenReturn("primary 3");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 13 alignment: CG communication: empathy primary abilities: primary 1, primary 2, primary 3", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithExtraordinaryAbilities() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("13:2:empathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("roll twice").thenReturn("primary 2").thenReturn("extraordinary");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        when(magicTreasureDB.getSwordExtraordinary(65)).thenReturn("extraordinary");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 13 alignment: CG communication: empathy primary abilities: primary 1, primary 2, extraordinary", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithExtraordinaryAbilitiesRollTwice() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("13:2:empathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("roll twice").thenReturn("primary 2").thenReturn("extraordinary");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        when(magicTreasureDB.getSwordExtraordinary(65)).thenReturn("roll twice").thenReturn("extraordinary1").thenReturn("roll twice").thenReturn("extraordinary2");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 13 alignment: CG communication: empathy primary abilities: primary 1, primary 2, extraordinary1, extraordinary2", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithRLM() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("17:3R+:speech and telepathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("primary 2").thenReturn("extraordinary");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        when(magicTreasureDB.getSwordExtraordinary(65)).thenReturn("extraordinary1").thenReturn("extraordinary2");
        when(magicTreasureDB.getSwordLanguages(65)).thenReturn("2");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 17 alignment: CG communication: speech and telepathy languages: 2 primary abilities: read languages and magic, primary 1, primary 2, extraordinary1, extraordinary2", swordGenerator.getMagicSword());
    }

    @Test
    public void testGetMagicSwordWithSpecialPurpose() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(65);
        when(magicTreasureDB.getMagicItemFromDB(65, MagicTreasureType.SWORD)).thenReturn(new ItemEntry(1,1,"+1"));
        when(magicTreasureDB.getSwordIntelligence(65)).thenReturn("17:3R+:speech and telepathy");
        when(magicTreasureDB.getSwordPrimary(65)).thenReturn("primary 1").thenReturn("primary 2").thenReturn("extraordinary");
        when(magicTreasureDB.getSwordAlignment(65)).thenReturn("CG");
        when(magicTreasureDB.getSwordExtraordinary(65)).thenReturn("1+special").thenReturn("extraordinary1").thenReturn("extraordinary2");
        when(magicTreasureDB.getSwordSpecialPurpose(65)).thenReturn("special purpose");
        when(magicTreasureDB.getSwordSpecialPurposePower(65)).thenReturn("special purpose power");
        when(magicTreasureDB.getSwordLanguages(65)).thenReturn("2");
        SwordGenerator swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        assertEquals("longsword +1 INT 17 alignment: CG communication: speech and telepathy languages: 2 primary abilities: read languages and magic, primary 1, primary 2, extraordinary1, special purpose: special purpose, special purpose power: special purpose power, extraordinary2", swordGenerator.getMagicSword());
    }



}
