package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.dice.Dice;

public class MiscWeaponGenerator extends Generator {

    private Dice dice;
    private MagicTableRoller magicTableRoller;

    public MiscWeaponGenerator(Dice dice, MagicTableRoller magicTableRoller) {
        this.dice = dice;
        this.magicTableRoller = magicTableRoller;
    }

    public String getMiscWeapon() {
        String text = magicTableRoller.rollOnTable(MagicTreasureType.MISC_WEAPON);
        if(text.equalsIgnoreCase("arrow +1 2-24 in number")) {
            int numArrows = dice.roll1D12() + dice.roll1D12();
            text = "Arrow +1, " + numArrows + " in number";
        } else if(text.equalsIgnoreCase("arrow +2 2-16 in number")) {
            int numArrows = dice.roll1D8() + dice.roll1D8();
            text = "Arrow +2, " + numArrows + " in number";
        } else if(text.equalsIgnoreCase("arrow +3 2-12 in number")) {
            int numArrows = dice.roll1D6() + dice.roll1D6();
            text = "Arrow +3, " + numArrows + " in number";
        } else if(text.equalsIgnoreCase("bolt +2 2-20 in number")) {
            int numBolts = dice.rollD10() + dice.rollD10();
            text = "Bolt +2, " + numBolts + " in number";
        }
        return text;
    }

}
