package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

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
