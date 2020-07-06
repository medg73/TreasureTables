package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

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
