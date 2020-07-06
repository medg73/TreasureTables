package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.enums.SpellCasterClass;
import com.medg.treasuretables.add1.data.MagicTreasureDB;

import java.util.Arrays;
import java.util.List;

public class RingGenerator extends Generator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;
    private SpellGenerator spellGenerator;

    private List<ItemEntry> contrarinessTypes = Arrays.asList(
            new ItemEntry(1, 20, "Flying"),
            new ItemEntry(21, 40, "Invisibility"),
            new ItemEntry(41, 60, "Levitation"),
            new ItemEntry(61, 70, "Shocking Grasp"),
            new ItemEntry(71, 80, "Spell Turning"),
            new ItemEntry(81, 100, "Strength 18/00"));

    private List<ItemEntry> protectionTypes = Arrays.asList(
            new ItemEntry(1, 70, "+1"),
            new ItemEntry(71, 82, "+2"),
            new ItemEntry(83, 83, "+2, 5' radius"),
            new ItemEntry(84, 90, "+3"),
            new ItemEntry(91, 91, "+3, 5' radius"),
            new ItemEntry(92, 97, "+4 AC, +2 saving throws"),
            new ItemEntry(98,100, "+6 AC, +1 saving throws"));

    private List<ItemEntry> telekinesisTypes = Arrays.asList(
            new ItemEntry(1, 25, "20#"),
            new ItemEntry(26, 50, "50#"),
            new ItemEntry(51, 89, "100#"),
            new ItemEntry(90, 99, "200#"),
            new ItemEntry(100, 100, "400#"));

    private List<ItemEntry> wizardryTypes = Arrays.asList(
            new ItemEntry(1,50, "1st level spells"),
            new ItemEntry(51, 75, "2nd level spells"),
            new ItemEntry(76, 82, "3rd level spells"),
            new ItemEntry(83, 88, "1st and 2nd level spells"),
            new ItemEntry(89, 92, "4th level spells"),
            new ItemEntry(93, 95, "5th level spells"),
            new ItemEntry(96, 99, "1st through 3rd level spells"),
            new ItemEntry(100, 100, "4th and 5th level spells"));

    public RingGenerator(MagicTreasureDB magicTreasureDB, Dice dice, SpellGenerator spellGenerator) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
        this.spellGenerator = spellGenerator;
    }

    String getItemText() {
        ItemEntry itemEntry = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.RING);

        String text = itemEntry.description;

        if(text.equalsIgnoreCase("contrariness")) {
            text = contrarinessText();
        } else if(text.equalsIgnoreCase("elemental command")) {
            text = elementalCommandText();
        } else if(text.equalsIgnoreCase("protection")) {
            text = protectionText();
        } else if(text.equalsIgnoreCase("multiple wishes++")) {
            text = multipleWishesText();
        } else if(text.equalsIgnoreCase("spell storing")) {
            text = spellStoringText();
        } else if(text.equalsIgnoreCase("telekinesis++")) {
            text = telekinesisText();
        } else if(text.equalsIgnoreCase("three wishes++")) {
            text = threeWishesText();
        } else if(text.equalsIgnoreCase("wizardry++ (m)")) {
            text = wizardryText();
        }

        return "ring of " + text;
    }

    private String wizardryText() {
        String subtype = getSubtypeText(dice.rollPercent(), wizardryTypes);
        return "wizardry (M): doubles " + subtype;
    }

    private String threeWishesText() {
        int roll = dice.rollPercent();
        if(roll <= 25) {
            return "three Limited Wishes";
        } else {
            return "three Wishes";
        }
    }

    private String telekinesisText() {
        String subtype = getSubtypeText(dice.rollPercent(), telekinesisTypes);
        return "telekinesis " + subtype;
    }

    private String spellStoringText() {
        int numSpells = dice.roll1D4() + 1;
        SpellCasterClass spellCasterClass = spellGenerator.getSpellcasterClass();
        StringBuilder sb = new StringBuilder();
        sb.append("spell storing with ").append(spellCasterClass.getName()).append(" spells: ");

        for(int i = 0; i < numSpells; i++) {
            int spellLevel;
            if(spellCasterClass == SpellCasterClass.CLERIC ||
                spellCasterClass == SpellCasterClass.DRUID ||
                spellCasterClass == SpellCasterClass.ILLUSIONIST) {
                spellLevel = dice.roll1D6();
                if(spellLevel == 6) {
                    spellLevel = dice.roll1D4();
                }
            } else {
                spellLevel = dice.roll1D8();
                if(spellLevel == 8) {
                    spellLevel = dice.roll1D6();
                }
            }
            String spellText = spellGenerator.getRandomSpell(spellCasterClass, spellLevel);
            sb.append(spellText).append(" (").append(spellLevel).append(")");
            if(i < numSpells - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    private String multipleWishesText() {
        int numWishes = dice.roll1D4() + dice.roll1D4();
        return numWishes + " wishes";
    }

    private String protectionText() {
        String subtype = getSubtypeText(dice.rollPercent(), protectionTypes);
        return "protection " + subtype;
    }

    private String elementalCommandText() {
        List<String> elementalTypes = Arrays.asList("Air", "Earth", "Fire", "Water");
        int i = dice.roll1D4() - 1;
        String elemetalType = elementalTypes.get(i);
        return "elemental command (" + elemetalType + ")";
    }

    private String contrarinessText() {
        String subtype = getSubtypeText(dice.rollPercent(), contrarinessTypes);
        return "contrariness (" + subtype + ")";
    }
}
