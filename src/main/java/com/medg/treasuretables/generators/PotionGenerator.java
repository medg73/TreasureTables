package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;

import java.util.Arrays;
import java.util.List;

// TODO - refactor

public class PotionGenerator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;

    private List<ItemEntry> giantStrengthTypes = Arrays.asList(
            new ItemEntry(1,6,"hill"),
            new ItemEntry(7,10,"stone"),
            new ItemEntry(11,14,"frost"),
            new ItemEntry(15,17,"fire"),
            new ItemEntry(18,19,"cloud"),
            new ItemEntry(20,20,"storm"));

    private List<ItemEntry> giantControlTypes = Arrays.asList(
            new ItemEntry(1, 5, "hill"),
            new ItemEntry(6, 9, "stone"),
            new ItemEntry(10,13, "frost"),
            new ItemEntry(14,17,"fire"),
            new ItemEntry(18,19,"cloud"),
            new ItemEntry(20,20,"storm"));

    private List<ItemEntry> humanControlTypes = Arrays.asList(
            new ItemEntry(1,2,"dwarf"),
            new ItemEntry(3,4,"elf/half-elf"),
            new ItemEntry(5,6,"gnome"),
            new ItemEntry(7,8,"halfling"),
            new ItemEntry(9,10,"half-orc"),
            new ItemEntry(11,16,"human"),
            new ItemEntry(17,19,"humanoid"),
            new ItemEntry(20,20,"elf, half-elf, and human"));

    private List<ItemEntry> undeadControlTypes = Arrays.asList(
            new ItemEntry(1,1,"ghast"),
            new ItemEntry(2,2,"ghost"),
            new ItemEntry(3,3,"ghoul"),
            new ItemEntry(4,4,"shadow"),
            new ItemEntry(5,5,"skeleton"),
            new ItemEntry(6,6,"spectre"),
            new ItemEntry(7,7,"wight"),
            new ItemEntry(8,8,"wraith"),
            new ItemEntry(9,9,"vampire"),
            new ItemEntry(10,10,"zombie"));

    public PotionGenerator(MagicTreasureDB magicTreasureDB, Dice dice) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
    }

    public String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.POTION);

        String text = itemEntry.description;
        if(text.equals("animal control")) {
            text = animalControlText();
        } else if(text.equals("dragon control")) {
            text = dragonControlText();
        } else if(text.equals("giant control")) {
            text = giantControlText();
        } else if(text.equals("giant strength")) {
            text = giantStrengthText();
        } else if(text.equals("human control")) {
            text = humanControlText();
        } else if(text.equals("undead control")) {
            text = undeadControlText();
        }

        return "potion of " + text;
    }

    private String undeadControlText() {
        String text;
        String undeadType = "error";
        int typeRoll = dice.rollD10();
        for(ItemEntry itemEntry : undeadControlTypes) {
            if(typeRoll <= itemEntry.maxRange) {
                undeadType = itemEntry.description;
                break;
            }
        }
        text = String.format("%s control", undeadType);
        return text;
    }


    private String humanControlText() {
        String text;
        String humanType = "error";
        int typeRoll = dice.rollD20();
        for(ItemEntry itemEntry : humanControlTypes) {
            if(typeRoll <= itemEntry.maxRange) {
                humanType = itemEntry.description;
                break;
            }
        }
        text = String.format("%s control", humanType);
        return text;
    }

    private String giantStrengthText() {
        String text;
        String giantType = "error";
        int typeRoll = dice.rollD20();
        for(ItemEntry itemEntry : giantStrengthTypes) {
            if(typeRoll <= itemEntry.maxRange) {
                giantType = itemEntry.description;
                break;
            }
        }
        text = String.format("%s giant strength", giantType);
        return text;
    }


    private String giantControlText() {
        String text;
        String giantType = "error";
        int typeRoll = dice.rollD20();
        for(ItemEntry itemEntry : giantControlTypes) {
            if(typeRoll <= itemEntry.maxRange) {
                giantType = itemEntry.description;
                break;
            }
        }
        text = String.format("%s giant control", giantType);
        return text;
    }


    private String animalControlText() {
        String text;
        int typeRoll = dice.rollD20();
        if(typeRoll <= 4) {
            text = "mammal/marsupial control";
        } else if(typeRoll <= 8) {
            text = "avian control";
        } else if(typeRoll <= 12) {
            text = "reptile/amphibian control";
        } else if(typeRoll <= 15) {
            text = "fish control";
        } else if(typeRoll <= 17) {
            text = "mammal/marsupial/avian control";
        } else if(typeRoll <= 19) {
            text = "reptile/amphibian/fish control";
        } else {
            text = "all animal control";
        }
        return text;
    }

    private String dragonControlText() {
        String text;
        String dragonType = "";
        int typeRoll = dice.rollD20();
        switch(typeRoll) {
            case 1:
            case 2:
                dragonType = "white";
                break;
            case 3:
            case 4:
                dragonType = "black";
                break;
            case 5:
            case 6:
            case 7:
                dragonType = "green";
                break;
            case 8:
            case 9:
                dragonType = "blue";
                break;
            case 10:
                dragonType = "red";
                break;
            case 11:
            case 12:
                dragonType = "brass";
                break;
            case 13:
            case 14:
                dragonType = "copper";
                break;
            case 15:
                dragonType = "bronze";
                break;
            case 16:
                dragonType = "silver";
                break;
            case 17:
                dragonType = "gold";
                break;
            case 18:
            case 19:
                dragonType = "evil";
                break;
            case 20:
                dragonType = "good";
                break;
        }
        text = String.format("%s dragon control", dragonType);
        return  text;
    }

}
