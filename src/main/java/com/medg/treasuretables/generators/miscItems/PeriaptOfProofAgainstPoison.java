package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

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
