package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MiscItemTable;

public class RobeOfTheArchmagi extends MiscItem {

    public RobeOfTheArchmagi(Dice dice,
                             MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Robe of the Archmagi (M)";
        this.miscItemTable = MiscItemTable.ROBE_OF_THE_ARCHMAGI_COLOR;
    }

    @Override
    public String getItemDetails() {
        String color = rollOnMiscItemTable(miscItemTable);
        return itemText + " - " + color + " (color not apparent)";
    }


}
