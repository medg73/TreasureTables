package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class CrystalBall extends MiscItem {

    public CrystalBall(Dice dice, MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Crystal Ball (M)";
        miscItemTable = MiscItemTable.CRYSTAL_BALL_TYPE;
    }

    @Override
    public String getItemDetails() {
        return rollOnMiscItemTable(MiscItemTable.CRYSTAL_BALL_TYPE);
    }
}
