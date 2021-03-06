package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class PearlOfPower extends MiscItem {

    public PearlOfPower(Dice dice,
                        MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Pearl of Power (M)";
        this.miscItemTable = MiscItemTable.PEARL_OF_POWER_LEVEL;
    }

    @Override
    public String getItemDetails() {
        boolean isCursed = false;
        if(dice.rollD20() == 20) {
            isCursed = true;
        }
        String level = rollOnMiscItemTable(miscItemTable);
        if(level.equals("2x")) {
            int level1 = dice.roll1D6();
            int level2 = dice.roll1D6();
            level = level1 + " and level " + level2;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(itemText);
        if(isCursed) {
            sb.append(" (cursed)");
        }
        sb.append(" level ");
        sb.append(level);

        return sb.toString();
    }
}
