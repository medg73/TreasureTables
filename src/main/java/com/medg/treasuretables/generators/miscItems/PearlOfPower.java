package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class PearlOfPower extends MiscItem {

    public PearlOfPower(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
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
