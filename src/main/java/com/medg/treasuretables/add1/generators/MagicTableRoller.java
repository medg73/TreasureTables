package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.data.MagicTreasureDB;

public class MagicTableRoller {

    private Dice dice;
    private MagicTreasureDB magicTreasureDB;

    public MagicTableRoller(Dice dice, MagicTreasureDB magicTreasureDB) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    public String rollOnTable(MagicTreasureType magicTreasureType) {
        int roll = dice.rollPercent();
        return magicTreasureDB.getMagicItemFromDB(roll, magicTreasureType).description;
    }
}
