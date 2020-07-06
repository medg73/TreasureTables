package com.medg.treasuretables.add1.miscItems;

import com.medg.treasuretables.dice.Dice;

public class PearlOfWisdom extends MiscItem {

    public PearlOfWisdom(Dice dice,
                         MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        itemText = "Pearl of Wisdom (C)";
    }

    @Override
    public String getItemDetails() {
        boolean isCursed = false;
        int roll = dice.rollD20();
        if(roll == 20) {
            isCursed = true;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(itemText);
        if(isCursed) {
            sb.append(" (cursed)");
        }
        return sb.toString();
    }
}
