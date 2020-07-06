package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

public class BagOfHolding extends MiscItem {

    public BagOfHolding(Dice dice,
                        MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Bag of Holding";
        this.miscItemTable = MiscItemTable.BAG_OF_HOLDING_CAPACITY;
    }

    public String getItemDetails() {
        String capacity = rollOnMiscItemTable(MiscItemTable.BAG_OF_HOLDING_CAPACITY);
        return itemText + " " + capacity + " capacity";
    }

}
