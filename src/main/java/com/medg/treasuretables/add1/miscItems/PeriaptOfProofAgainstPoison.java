package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class PeriaptOfProofAgainstPoison extends MiscItem {

    public PeriaptOfProofAgainstPoison(Dice dice,
                                       MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        itemText = "Periapt of Proof Against Poison";
        miscItemTable = MiscItemTable.PERIAPT_OF_PROOF_AGAINST_POISON;
    }

    @Override
    public String getItemDetails() {
        String plus = rollOnMiscItemTable(miscItemTable);
        return itemText + " " + plus;
    }
}
