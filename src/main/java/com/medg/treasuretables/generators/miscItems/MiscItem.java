package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public abstract class MiscItem {

    protected String itemText;
    protected MiscItemTable miscItemTable;
    protected Dice dice;
    protected MagicTreasureDB magicTreasureDB;

    public MiscItem(Dice dice, MagicTreasureDB magicTreasureDB) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    public abstract String getItemDetails();

    protected String rollOnMiscItemTable(MiscItemTable table) {
        int roll = dice.getAmount(table.getDiceType(), 1);
        return magicTreasureDB.getMiscItemTableEntry(roll, table);
    }

    public String getItemText() {
        return itemText;
    }

}
