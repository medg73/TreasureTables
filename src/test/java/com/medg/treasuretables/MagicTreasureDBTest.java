package com.medg.treasuretables;

import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MagicTreasureDBTest {

    MagicTreasureDB magicTreasureDB;

    @Before
    public void before() {
        magicTreasureDB = new MagicTreasureDB();
        magicTreasureDB.initialize();
    }

    @Test
    public void testGetPotion() {

        ItemEntry potion = magicTreasureDB.getMagicItemFromDB(57, MagicTreasureType.POTION);
        assertEquals(55, potion.minRange);
        assertEquals(57, potion.maxRange);
        assertEquals("Invulnerability (F)", potion.description);
    }

    @Test
    public void testGetMagicItemFromDBException() {
        try {
            magicTreasureDB.getMagicItemFromDB(101, MagicTreasureType.POTION);
            fail();
        } catch(RuntimeException re) {
            assertEquals("getMagicItemFromDB: Can't find magic item of type POTION roll: 101", re.getMessage());
        }


    }
}
