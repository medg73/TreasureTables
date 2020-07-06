package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.data.MagicTreasureDB;

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
