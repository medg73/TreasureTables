package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

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
