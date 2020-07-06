package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class BagOfTricks extends MiscItem {

    public BagOfTricks(Dice dice, MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Bag of Tricks";
        this.miscItemTable = MiscItemTable.BAG_OF_TRICKS_TYPE;
    }

    @Override
    public String getItemDetails() {
        return itemText + " " + rollOnMiscItemTable(miscItemTable);
    }
}
