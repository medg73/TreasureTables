package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

public class RobeOfUsefulItems extends MiscItem {

    public RobeOfUsefulItems(Dice dice,
                             MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Robe of Useful Items";
        this.miscItemTable = MiscItemTable.ROBE_OF_USEFUL_ITEMS_ITEMS;
    }

    @Override
    public String getItemDetails() {
        int numItems = dice.roll1D4() + dice.roll1D4() + dice.roll1D4() + dice.roll1D4();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < numItems) {
            String item = rollOnMiscItemTable(miscItemTable);
            if(!item.equals("2x")) {
                sb.append(item);
                if(i < numItems - 1) {
                    sb.append(", ");
                }
                i++;
            } else {
                numItems++;
            }
        }

        return itemText + " with: " + sb.toString();
    }
}
