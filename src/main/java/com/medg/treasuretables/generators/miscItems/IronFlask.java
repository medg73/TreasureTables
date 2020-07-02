package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class IronFlask extends MiscItem {

    public IronFlask(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Iron Flask";
        this.miscItemTable = MiscItemTable.IRON_FLASK_TYPE;
    }

    @Override
    public String getItemDetails() {
        return "Iron Flask containing " + rollOnMiscItemTable(MiscItemTable.IRON_FLASK_TYPE);
    }
}
