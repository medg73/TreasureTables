package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class NecklaceOfMissiles extends MiscItem {

    public NecklaceOfMissiles(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Necklace of Missiles";
        this.miscItemTable = MiscItemTable.NECKLACE_OF_MISSILES_TYPE;
    }

    @Override
    public String getItemDetails() {
        String necklaceType = rollOnMiscItemTable(miscItemTable);
        return itemText + " with " + necklaceType;
    }
}
