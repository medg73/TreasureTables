package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class ManualOfGolems extends MiscItem {

    public ManualOfGolems(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Manual of Golems (CM)";
        this.miscItemTable = MiscItemTable.MANUAL_OF_GOLEMS_TYPE;
    }

    @Override
    public String getItemDetails() {
        String golemType = rollOnMiscItemTable(miscItemTable);
        return itemText + ": " + golemType;

    }
}
