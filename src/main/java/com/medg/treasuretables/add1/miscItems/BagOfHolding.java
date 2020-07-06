package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

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
