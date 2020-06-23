package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.SpellCasterClass;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.MagicTreasureType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScrollGenerator {

    Dice dice;
    MagicTreasureDB magicTreasureDB;
    SpellGenerator spellGenerator;

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

    public ScrollGenerator(MagicTreasureDB magicTreasureDB, Dice dice, SpellGenerator spellGenerator) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
        this.spellGenerator = spellGenerator;
    }

    public String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.SCROLL);
        String text = itemEntry.description;

        if(text.equalsIgnoreCase("protection from elementals")) {
            text = protectionFromElementalsText();
        } else if(text.equalsIgnoreCase("protection from lycanthropes")) {
            text = protectionFromLycanthropesText();
        } else if(text.matches("spell \\d:\\d-\\d:\\d-\\d")) {
            text = spellScrollText(text);
        } else {
            text = "scroll of " + text;
        }

        return text;
    }

    private SpellCasterClass getScrollSpellcasterClass() {
        SpellCasterClass spellCasterClass;
        int firstRoll = dice.rollPercent();
        int secondRoll = dice.rollPercent();
        if(firstRoll <= 70) {
            if(secondRoll <= 10) {
                spellCasterClass = SpellCasterClass.ILLUSIONIST;
            } else {
                spellCasterClass = SpellCasterClass.MAGIC_USER;
            }
        } else {
            if(secondRoll <= 25) {
                spellCasterClass = SpellCasterClass.DRUID;
            } else {
                spellCasterClass = SpellCasterClass.CLERIC;
            }
        }

        return spellCasterClass;
    }

    private String spellScrollText(String scrollDescription) {
        String spellRange = scrollDescription.split(" ")[1];
        String[] spellData = spellRange.split(":");

        int numSpells = Integer.parseInt(spellData[0]);
        String muRange = spellData[1];
        String otherRange = spellData[2];

        String range = otherRange;
        SpellCasterClass spellCasterClass = getScrollSpellcasterClass();
        if(spellCasterClass == SpellCasterClass.MAGIC_USER) {
            range = muRange;
        }
        int min = Integer.parseInt(range.split("-")[0]);
        int max = Integer.parseInt(range.split("-")[1]);

        StringBuilder sb = new StringBuilder();
        sb.append(spellCasterClass.getName()).append(" scroll with spells: ");
        for(int i = 0; i < numSpells; i++) {
            int level = dice.getNumInLinearRange(min, max);
            String spell = spellGenerator.getRandomSpell(spellCasterClass, level);
            sb.append(spell).append(" (").append(level).append(")");
            if(i < numSpells - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();

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
