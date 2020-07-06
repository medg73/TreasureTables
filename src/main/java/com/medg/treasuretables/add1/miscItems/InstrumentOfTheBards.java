package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class InstrumentOfTheBards extends MiscItem {

    public InstrumentOfTheBards(Dice dice,
                                MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "instrument of the bards";
        this.miscItemTable = MiscItemTable.INSTRUMENT_OF_THE_BARDS_TYPE;
    }

    @Override
    public String getItemDetails() {
        String instrumentType = rollOnMiscItemTable(MiscItemTable.INSTRUMENT_OF_THE_BARDS_TYPE);
        return "Instrument of the Bards: " + instrumentType;
    }
}
