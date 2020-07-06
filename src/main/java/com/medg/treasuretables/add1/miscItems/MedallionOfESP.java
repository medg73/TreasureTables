package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class MedallionOfESP extends MiscItem {

    public MedallionOfESP(Dice dice,
                          MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Medallion of ESP";
        this.miscItemTable = MiscItemTable.MEDALLION_OF_ESP_TYPE;
    }

    @Override
    public String getItemDetails() {
        String type = rollOnMiscItemTable(miscItemTable);
        return itemText + " " + type;
    }
}
