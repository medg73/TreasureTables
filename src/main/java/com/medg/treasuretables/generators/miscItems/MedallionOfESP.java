package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class MedallionOfESP extends MiscItem {

    public MedallionOfESP(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Medallion of ESP";
        this.miscItemTable = MiscItemTable.MEDALLION_OF_ESP_TYPE;
    }

    @Override
    public String getItemDetails() {
        String type = rollOnMiscItemTable(miscItemTable);
        return itemText + " " + type;
    }
}
