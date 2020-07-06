package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

public class NecklaceOfPrayerBeads extends MiscItem {

    public NecklaceOfPrayerBeads(Dice dice,
                                 MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Necklace of Prayer Beads (C)";
        this.miscItemTable = MiscItemTable.NECKLACE_OF_PRAYER_BEADS_TYPE;
    }

    @Override
    public String getItemDetails() {
        int numBeads = dice.roll1D4() + 2;
        StringBuilder sb = new StringBuilder();
        sb.append(itemText);
        sb.append(" with beads of: " );

        for(int i = 0; i < numBeads; i++) {
            sb.append(rollOnMiscItemTable(miscItemTable));
            if(i < numBeads - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
