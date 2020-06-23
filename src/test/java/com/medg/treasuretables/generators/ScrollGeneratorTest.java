package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        testGetScrollType(dice, "protection from lycanthropes", "scroll of protection from wererats");
    }

    private void testGetScrollType(Dice dice, String typeText, String expectedText) {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), any(MagicTreasureType.class))).thenReturn(new ItemEntry(1,1,typeText));
        ScrollGenerator scrollGenerator = new ScrollGenerator(magicTreasureDB, dice);
        String text = scrollGenerator.getItemText();
        assertEquals(expectedText, text);
    }
}
