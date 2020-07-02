package com.medg.treasuretables.generators;

import com.medg.treasuretables.Alignment;
import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;

public class MiscGenerator extends Generator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;
    private SpellGenerator spellGenerator;
    private PotionGenerator potionGenerator;

    MiscGenerator(MagicTreasureDB magicTreasureDB, Dice dice, SpellGenerator spellGenerator, PotionGenerator potionGenerator) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
        this.spellGenerator = spellGenerator;
        this.potionGenerator = potionGenerator;
    }

    public String getMiscItemText(String text) {
        String rv = text;


        if(text.equalsIgnoreCase("bag of holding")) {
            String capacity = rollOnMiscItemTable(MiscItemTable.BAG_OF_HOLDING_CAPACITY);
            rv = text + " " + capacity + " capacity";
        } else if(text.equalsIgnoreCase("bag of tricks")) {
            rv = text + " " + rollOnMiscItemTable(MiscItemTable.BAG_OF_TRICKS_TYPE);
        } else if(text.equalsIgnoreCase("beaker of plentiful potions")) {
            rv = text + ": " + getBeakerOfMiscPotionsPotions();
        } else if(text.equalsIgnoreCase("bracers of defense")) {
            rv = text + " " + rollOnMiscItemTable(MiscItemTable.BRACERS_OF_DEFENSE_VALUE);
        } else if(text.equalsIgnoreCase("bucknard's everful purse")) {
            rv = text + " containing " + rollOnMiscItemTable(MiscItemTable.BUCKNARDS_EVERFUL_PURSE_TYPE);
        } else if(text.equalsIgnoreCase("candle of invocation (C)")) {
            rv = text + " alignment " + getRandomAlignment();
        }
        // carpet of flying *
        // chime of opening (charges)
        // cloak of displacement (size) *
        // cloak of elvenkind (size) *
        // cloak of protection *
        // crystal ball *
        // deck of many things (size) *
        // efreeti bottle *
        // eyes of petrification
        // figurines of wondrous power
        // girdle of feminitiy/masculinity
        // girdle of giant strength
        // horn of valhalla
        // incense of meditation
        // incense of obsession
        // ioun stones
        // instrument of the bards
        // iron flask
        // javelin of lightning
        // javelin of piercing
        // keoghtom's ointment
        // manual of golems
        // ESP medallion
        // mirror of life trapping
        // necklace of missiles
        // necklace of prayer beads
        // pearl of power
        // pearl of wisdom
        // periapt of proof against poison
        // pipes of the sewers
        // quaal's feather token
        // robe of the archmagi
        // robe of useful items


        return rv;
    }

    private String getRandomAlignment() {
        int index = dice.getAmount("1d9", 1) - 1;
        Alignment alignment = Alignment.values()[index];
        return alignment.toString();
    }


    private String getBeakerOfMiscPotionsPotions() {
        int numPotions = dice.roll1D4() + 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numPotions; i++) {
            sb.append(potionGenerator.getItemText());
            if(i < numPotions - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    private String rollOnMiscItemTable(MiscItemTable table) {
        int roll = dice.getAmount(table.getDiceType(), 1);
        return magicTreasureDB.getMiscItemTableEntry(roll, table);
    }


}
