package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

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
