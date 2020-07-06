package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.data.MagicTreasureDB;

public class ArmorTableRoller {

    private Dice dice;
    private MagicTreasureDB magicTreasureDB;

    public ArmorTableRoller(Dice dice, MagicTreasureDB magicTreasureDB) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    public String rollOnArmorTable() {
        int roll = dice.rollPercent();
        return magicTreasureDB.getMagicItemFromDB(roll, MagicTreasureType.ARMOR).description;
    }
}
