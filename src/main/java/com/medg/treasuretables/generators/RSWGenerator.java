package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.data.MagicTreasureDB;

public class RSWGenerator extends Generator {

    private Dice dice;
    private MagicTreasureDB magicTreasureDB;
    private SpellGenerator spellGenerator;

    public RSWGenerator(MagicTreasureDB magicTreasureDB, Dice dice,
                        SpellGenerator spellGenerator) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
        this.spellGenerator = spellGenerator;
    }

    public String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.RSW);
        String text = itemEntry.description;

        if(text.equalsIgnoreCase("Rod of Absorption (CM)")) {
            int charges = getRodCharges();
            text = text + " with " + charges + " remaining levels";
        } else if(text.contains("Rod")) {
            int charges = getRodCharges();
            text = text + " with " + charges + " charges";
        } else if(text.equalsIgnoreCase("Staff of the Serpent (C)")) {
            String variety = getStaffOfTheSerpentVariety();
            text = text + " - " + variety;
        } else if(text.contains("Staff")) {
            int charges = getStaffCharges();
            text = text + " with " + charges + " charges";
        } else if(text.contains("Wand")) {
            int charges = getWandCharges();
            boolean trapped = isWandTrapped();
            text = text + " with " + charges + " charges";
            if(trapped) {
                text = text + " trapped to backfire";
            }
        }

        return text;
    }

    private boolean isWandTrapped() {
        int roll = dice.rollPercent();
        if(roll == 1) {
            return true;
        }
        return false;
    }

    private int getWandCharges() {
        int roll = dice.rollD20();
        return 100 - (roll - 1);
    }

    private String getStaffOfTheSerpentVariety() {
        int roll = dice.rollPercent();
        if(roll <= 60) {
            return "Python";
        }
        return "Adder";
    }

    private int getRodCharges() {
        return 50 - (dice.rollD10() - 1);
    }

    private int getStaffCharges() {
        return 25 - (dice.roll1D6() - 1);
    }

}
