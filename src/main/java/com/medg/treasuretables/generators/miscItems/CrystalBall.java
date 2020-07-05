package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class CrystalBall extends MiscItem {

    public CrystalBall(Dice dice, MagicTreasureDB magicTreasureDB) {
        super(dice, magicTreasureDB);
        this.itemText = "Crystal Ball (M)";
        miscItemTable = MiscItemTable.CRYSTAL_BALL_TYPE;
    }

    @Override
    public String getItemDetails() {
        return rollOnMiscItemTable(MiscItemTable.CRYSTAL_BALL_TYPE);
    }
}
