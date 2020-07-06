package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class IronFlask extends MiscItem {

    public IronFlask(Dice dice,
                     MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Iron Flask";
        this.miscItemTable = MiscItemTable.IRON_FLASK_TYPE;
    }

    @Override
    public String getItemDetails() {
        return "Iron Flask containing " + rollOnMiscItemTable(MiscItemTable.IRON_FLASK_TYPE);
    }
}
