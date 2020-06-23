package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;

import java.util.Arrays;
import java.util.List;

public class ScrollGenerator {

    Dice dice;
    MagicTreasureDB magicTreasureDB;

    private List<ItemEntry> protectionFromElementalsTypes = Arrays.asList(
            new ItemEntry(1, 15, "air"),
            new ItemEntry(16,30,"earth"),
            new ItemEntry(31,45,"fire"),
            new ItemEntry(46,60,"water"),
            new ItemEntry(61,100,"all"));

    private List<ItemEntry> protectionFromLycanthropesTypes = Arrays.asList(
            new ItemEntry(1,5,"werebears"),
            new ItemEntry(6,10,"wereboars"),
            new ItemEntry(11,20,"wererats"),
            new ItemEntry(21,25,"weretigers"),
            new ItemEntry(26,40,"werewolves"),
            new ItemEntry(41,98,"all lycanthropes"),
            new ItemEntry(99,100,"all shape changers"));

    public ScrollGenerator(MagicTreasureDB magicTreasureDB, Dice dice) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    public String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.SCROLL);
        String text = itemEntry.description;

        if(text.equals("protection from elementals")) {
            text = protectionFromElementalsText();
        } else if(text.equals("protection from lycanthropes")) {
            text = protectionFromLycanthropesText();
        }

        return text;
    }

    private String protectionFromLycanthropesText() {
        int roll = dice.rollPercent();
        String subtype = getSubtypeText(roll, protectionFromLycanthropesTypes);
        String text = String.format("scroll of protection from %s", subtype);
        return text;
    }

    private String protectionFromElementalsText() {
        int roll = dice.rollPercent();
        String subtype = getSubtypeText(roll, protectionFromElementalsTypes);
        String text = String.format("scroll of protection from %s elementals", subtype);
        return text;
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
}
