package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class QuaalsFeatherToken extends MiscItem {

    public QuaalsFeatherToken(Dice dice,
                              MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Quaal's Feather Token";
        this.miscItemTable = MiscItemTable.QUAALS_FEATHER_TOKEN;
    }

    @Override
    public String getItemDetails() {
        String tokenType = rollOnMiscItemTable(miscItemTable);
        return itemText + " - " + tokenType;
    }
}
