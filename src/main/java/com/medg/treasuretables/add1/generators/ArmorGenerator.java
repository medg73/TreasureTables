package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.MagicTreasureType;

public class ArmorGenerator extends Generator{

    private Dice dice;
    private MagicTableRoller magicTableRoller;

    public ArmorGenerator(Dice dice, MagicTableRoller magicTableRoller) {
        this.dice = dice;
        this.magicTableRoller = magicTableRoller;
    }

    public String getMagicArmor() {
        String text = magicTableRoller.rollOnTable(MagicTreasureType.ARMOR);
        if(text.toLowerCase().contains("shield")) {
            return text;
        }
        String size = getMagicArmorSize();
        return size + " " + text;
    }

    private String getMagicArmorSize() {
        int roll = dice.rollPercent();
        if(roll <= 65) {
            return "human-sized";
        } else if(roll <= 85) {
            return "elf-sized";
        } else if(roll <= 95) {
            return "dwarf-sized";
        } else return "gnome or halfling sized";
    }
}
