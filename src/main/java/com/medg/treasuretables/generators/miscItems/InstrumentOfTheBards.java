package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class InstrumentOfTheBards extends MiscItem {

    public InstrumentOfTheBards(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "instrument of the bards";
        this.miscItemTable = MiscItemTable.INSTRUMENT_OF_THE_BARDS_TYPE;
    }

    @Override
    public String getItemDetails() {
        String instrumentType = rollOnMiscItemTable(MiscItemTable.INSTRUMENT_OF_THE_BARDS_TYPE);
        return "Instrument of the Bards: " + instrumentType;
    }
}
