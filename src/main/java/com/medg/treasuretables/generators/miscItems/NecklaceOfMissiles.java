package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

public class NecklaceOfMissiles extends MiscItem {

    public NecklaceOfMissiles(Dice dice,
                              MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Necklace of Missiles";
        this.miscItemTable = MiscItemTable.NECKLACE_OF_MISSILES_TYPE;
    }

    @Override
    public String getItemDetails() {
        String necklaceType = rollOnMiscItemTable(miscItemTable);
        return itemText + " with " + necklaceType;
    }
}
