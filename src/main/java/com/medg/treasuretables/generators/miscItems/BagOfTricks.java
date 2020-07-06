package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

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
