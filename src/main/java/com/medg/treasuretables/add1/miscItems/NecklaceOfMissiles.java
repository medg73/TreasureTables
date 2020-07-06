package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

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
