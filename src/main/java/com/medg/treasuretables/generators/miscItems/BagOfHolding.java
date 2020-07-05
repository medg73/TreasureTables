package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class BagOfHolding extends MiscItem {

    public BagOfHolding(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Bag of Holding";
        this.miscItemTable = MiscItemTable.BAG_OF_HOLDING_CAPACITY;
    }

    public String getItemDetails() {
        String capacity = rollOnMiscItemTable(MiscItemTable.BAG_OF_HOLDING_CAPACITY);
        return itemText + " " + capacity + " capacity";
    }

}
