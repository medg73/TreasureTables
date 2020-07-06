package com.medg.treasuretables;

import com.medg.treasuretables.add1.data.SimpleTreasureTable;
import com.medg.treasuretables.add1.data.SimpleTreasureType;
import com.medg.treasuretables.add1.data.TreasureTableLoader;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.generators.MagicItemGenerator;
import com.medg.treasuretables.dice.Dice;
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
