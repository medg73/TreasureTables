package com.medg.treasuretables;

import com.medg.treasuretables.data.SimpleTreasureTable;
import com.medg.treasuretables.data.SimpleTreasureType;
import com.medg.treasuretables.data.TreasureTableLoader;
import com.medg.treasuretables.generators.MagicItemGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TreasureTypeContainerTest {

    @Test
    public void testGenerateMagicItemPotion() {

        MagicItemGenerator magicItemGenerator = mock(MagicItemGenerator.class);
        Dice dice = mock(Dice.class);
        TreasureTableLoader treasureTableLoader = mock(TreasureTableLoader.class);
        SimpleTreasureTable simpleTreasureTable = mock(SimpleTreasureTable.class);
        SimpleTreasureType[] emptyTreasureTypes = {};

        when(treasureTableLoader.loadTreasureTable()).thenReturn(simpleTreasureTable);
        when(simpleTreasureTable.getTreasureTypes()).thenReturn(emptyTreasureTypes);
        when(magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION)).thenReturn("magic potion");

        TreasureTypeContainer treasureTypeContainer = new TreasureTypeContainer(magicItemGenerator, dice, treasureTableLoader);
        assertEquals("magic potion", treasureTypeContainer.generateMagicItem(MagicTreasureType.POTION));

    }

}
