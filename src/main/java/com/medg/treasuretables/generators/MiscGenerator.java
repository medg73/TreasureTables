package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.data.MagicTreasureDB;

import java.util.Arrays;
import java.util.List;

public class MiscGenerator extends Generator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;
    private SpellGenerator spellGenerator;

    private List<ItemEntry> bagOfHoldingCapacity = Arrays.asList(
            new ItemEntry(1,30,"250#"),
            new ItemEntry(31, 70, "500#"),
            new ItemEntry(71, 90, "1000#"),
            new ItemEntry(91, 100, "1500#"));

    private List<ItemEntry> bagOfTricksTypes = Arrays.asList(
            new ItemEntry(1,5,"type 1"),
            new ItemEntry(6, 8, "type 2"),
            new ItemEntry(9, 10, "type 3"));

    MiscGenerator(MagicTreasureDB magicTreasureDB, Dice dice, SpellGenerator spellGenerator) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
        this.spellGenerator = spellGenerator;
    }

    public String getMiscItemText(String text) {
        String rv = text;


        if(text.equalsIgnoreCase("bag of holding")) {
            String capacity = getBagOfHoldingCapacity();
            rv = text + " " + capacity + " capacity";
        } else if(text.equalsIgnoreCase("bag of tricks")) {
            rv = text + " " + getBagOfTricksType();
        }

        return rv;
    }

    private String getBagOfTricksType() {
        return getSubtypeText(dice.rollD10(), bagOfTricksTypes);
    }

    private String getBagOfHoldingCapacity() {
        return getSubtypeText(dice.rollPercent(), bagOfHoldingCapacity);
    }


}
