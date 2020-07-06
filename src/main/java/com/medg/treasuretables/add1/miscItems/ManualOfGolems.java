package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class ManualOfGolems extends MiscItem {

    public ManualOfGolems(Dice dice,
                          MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Manual of Golems (CM)";
        this.miscItemTable = MiscItemTable.MANUAL_OF_GOLEMS_TYPE;
    }

    @Override
    public String getItemDetails() {
        String golemType = rollOnMiscItemTable(miscItemTable);
        return itemText + ": " + golemType;

    }
}
