package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public abstract class MiscItem {

    protected String itemText;
    protected MiscItemTable miscItemTable;
    protected Dice dice;
    protected MiscItemTableRoller miscItemTableRoller;

    public MiscItem(Dice dice, MiscItemTableRoller miscItemTableRoller) {
        this.dice = dice;
        this.miscItemTableRoller = miscItemTableRoller;
    }

    public abstract String getItemDetails();

    protected String rollOnMiscItemTable(MiscItemTable table) {
        return miscItemTableRoller.rollOnMiscItemTable(table);
    }

    public String getItemText() {
        return itemText;
    }

}
