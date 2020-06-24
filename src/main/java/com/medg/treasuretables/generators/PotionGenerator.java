package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;

import java.util.Arrays;
import java.util.List;

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

    private List<ItemEntry> animalControlTypes = Arrays.asList(
            new ItemEntry(1, 4, "mammal/marsupial"),
            new ItemEntry(5, 8, "avian"),
            new ItemEntry(9, 12, "reptile/amphibian"),
            new ItemEntry(13,15, "fish"),
            new ItemEntry(16, 17, "mammal/marsupial/avian"),
            new ItemEntry(18,19,"reptile/amphibian/fish control"),
            new ItemEntry(20,20,"all animal"));

    private List<ItemEntry> dragonControlTypes = Arrays.asList(
            new ItemEntry(1,2,"white"),
            new ItemEntry(3,4,"black"),
            new ItemEntry(5,7,"green"),
            new ItemEntry(8,9,"blue"),
            new ItemEntry(10,10,"red"),
            new ItemEntry(11,12,"brass"),
            new ItemEntry(13,14,"copper"),
            new ItemEntry(15,15,"bronze"),
            new ItemEntry(16,16,"silver"),
            new ItemEntry(17,17,"gold"),
            new ItemEntry(18,19,"evil"),
            new ItemEntry(20,20,"good"));

    PotionGenerator(MagicTreasureDB magicTreasureDB, Dice dice) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
    }

    String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.POTION);

        String text = itemEntry.description;
        if(text.equals("Animal Control*")) {
            text = animalControlText();
        } else if(text.equals("Dragon Control*")) {
            text = dragonControlText();
        } else if(text.equals("Giant Control*")) {
            text = giantControlText();
        } else if(text.equals("Giant Strength*(F)")) {
            text = giantStrengthText();
        } else if(text.equals("Human Control*")) {
            text = humanControlText();
        } else if(text.equals("Undead Control*")) {
            text = undeadControlText();
        }

        return "potion of " + text;
    }

    private String getSubtypeText(int roll, List<ItemEntry> types) {
        String subtype = "error";
        for(ItemEntry itemEntry : types) {
            if(roll <= itemEntry.maxRange) {
                subtype = itemEntry.description;
                break;
            }
        }
        return subtype;
    }

    private String undeadControlText() {
        String text;
        String undeadType = "error";
        int typeRoll = dice.rollD10();
        undeadType = getSubtypeText(typeRoll, undeadControlTypes);
        text = String.format("%s control", undeadType);
        return text;
    }

    private String humanControlText() {
        String text;
        String humanType = "error";
        int typeRoll = dice.rollD20();
        humanType = getSubtypeText(typeRoll, humanControlTypes);
        text = String.format("%s control", humanType);
        return text;
    }

    private String giantStrengthText() {
        String text;
        String giantType = "error";
        int typeRoll = dice.rollD20();
        giantType = getSubtypeText(typeRoll, giantStrengthTypes);
        text = String.format("%s giant strength (F)", giantType);
        return text;
    }

    private String giantControlText() {
        String text;
        String giantType = "error";
        int typeRoll = dice.rollD20();
        giantType = getSubtypeText(typeRoll, giantControlTypes);
        text = String.format("%s giant control", giantType);
        return text;
    }

    private String animalControlText() {
        int typeRoll = dice.rollD20();
        String subtype = getSubtypeText(typeRoll, animalControlTypes);
        String text = String.format("%s control", subtype);
        return text;
    }

    private String dragonControlText() {
        String text;
        String dragonType = "";
        int typeRoll = dice.rollD20();
        dragonType = getSubtypeText(typeRoll, dragonControlTypes);
        text = String.format("%s dragon control", dragonType);
        return  text;
    }

}
