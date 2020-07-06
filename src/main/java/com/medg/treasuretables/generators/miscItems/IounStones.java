package com.medg.treasuretables.generators.miscItems;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;

import java.util.ArrayList;
import java.util.List;

public class IounStones extends MiscItem {

    public IounStones(Dice dice,
                      MiscItemTableRoller miscItemTableRoller) {
        super(dice, miscItemTableRoller);
        this.itemText = "Ioun Stones";
        this.miscItemTable = MiscItemTable.IOUN_STONES_TYPE;
    }

    public String getItemDetails() {
        int numStones = dice.rollD10();
        List<String> stones = new ArrayList<>();

        for(int i = 0; i < numStones; i++) {
            String stoneType = rollOnMiscItemTable(MiscItemTable.IOUN_STONES_TYPE);
            if(!stoneType.contains("dull gray") && stones.contains(stoneType)) {
                stoneType = "dull gray ellipsoid";
            }
            stones.add(stoneType);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(numStones);
        sb.append(" IOUN Stones: ");

        for(int i = 0; i < stones.size(); i++) {
            sb.append(stones.get(i));
            if(i < stones.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }


}
