package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;

public class ArmorGenerator extends Generator{

    private Dice dice;
    private ArmorTableRoller armorTableRoller;

    public ArmorGenerator(Dice dice, ArmorTableRoller armorTableRoller) {
        this.dice = dice;
        this.armorTableRoller = armorTableRoller;
    }

    public String getMagicArmor() {
        String text = armorTableRoller.rollOnArmorTable();
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
