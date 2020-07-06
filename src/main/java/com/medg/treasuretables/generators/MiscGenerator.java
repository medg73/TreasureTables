package com.medg.treasuretables.generators;

import com.medg.treasuretables.Alignment;
import com.medg.treasuretables.Dice;
import com.medg.treasuretables.MiscItemTable;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.generators.miscItems.*;

public class MiscGenerator extends Generator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;
    private SpellGenerator spellGenerator;
    private PotionGenerator potionGenerator;
    private MiscItemTableRoller miscItemTableRoller;
    private MiscItemFactory miscItemFactory;


    MiscGenerator(MagicTreasureDB magicTreasureDB, Dice dice, SpellGenerator spellGenerator,
                  PotionGenerator potionGenerator, MiscItemTableRoller miscItemTableRoller) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
        this.spellGenerator = spellGenerator;
        this.potionGenerator = potionGenerator;
        this.miscItemTableRoller = miscItemTableRoller;
        miscItemFactory = new MiscItemFactory(dice, miscItemTableRoller);

    }

    public String getMiscItemText(String text) {
        String rv = text;

        MiscItem miscItem = miscItemFactory.getMiscItemByItemText(text);
        if(miscItem != null) {
            return miscItem.getItemDetails();
        }

        if(text.equalsIgnoreCase("beaker of plentiful potions")) {
            rv = text + ": " + getBeakerOfMiscPotionsPotions();
        } else if(text.equalsIgnoreCase("bracers of defense")) {
            rv = text + " " + rollOnMiscItemTable(MiscItemTable.BRACERS_OF_DEFENSE_VALUE);
        } else if(text.equalsIgnoreCase("bucknard's everful purse")) {
            rv = text + " containing " + rollOnMiscItemTable(MiscItemTable.BUCKNARDS_EVERFUL_PURSE_TYPE);
        } else if(text.equalsIgnoreCase("candle of invocation (C)")) {
            rv = text + " alignment " + getRandomAlignment();
        } else if(text.equalsIgnoreCase("carpet of flying")) {
            rv = text + " " + rollOnMiscItemTable(MiscItemTable.CARPET_OF_FLYING_SIZE);
        } else if(text.equalsIgnoreCase("chime of opening")) {
            int charges = 20 + dice.roll1D6() * 10;
            rv = text + " " + charges + " charges";
        } else if(text.equalsIgnoreCase("cloak of displacement")) {
            String sizeStr = getCloakSize();
            rv = text + " " + sizeStr;
        } else if(text.equalsIgnoreCase("cloak of elvenkind")) {
            int sizing = dice.rollD10();
            String sizeStr = "human or elvenkind size";
            if(sizing == 9) {
                sizeStr = "dwarf, gnome, or halfling size";
            }
            rv = text + " " + sizeStr;
        } else if(text.equalsIgnoreCase("cloak of poisonousness")) {
            String sizeStr = getCloakSize();
            rv = text + " " + sizeStr;
        }
        else if(text.equalsIgnoreCase("cloak of protection")) {
            String sizeStr = getCloakSize();
            String protectionValue = rollOnMiscItemTable(MiscItemTable.CLOAK_OF_PROTECTION_VALUE);
            rv = text + " " + protectionValue + " " + sizeStr;
        } else if(text.equalsIgnoreCase("deck of many things")) {
            String sizeStr = "13 cards";
            int sizing = dice.roll1D4();
            if(sizing == 4) {
                sizeStr = "22 cards";
            }
            rv = text + " " + sizeStr;
        } else if(text.equalsIgnoreCase("figurine of wondrous power")) {
            String figurineType = rollOnMiscItemTable(MiscItemTable.FIGURINE_OF_WONDROUS_POWER_TYPE);
            if(figurineType.equalsIgnoreCase("marble elephant")) {
                String elephantType = rollOnMiscItemTable(MiscItemTable.MARBLE_ELEPHANT_TYPE);
                figurineType = figurineType + " " + elephantType;
            }
            rv = text + ": " + figurineType;
        } else if(text.equalsIgnoreCase("girdle of giant strength (CFT)")) {
            rv = "girdle of " + rollOnMiscItemTable(MiscItemTable.GIRDLE_OF_GIANT_STRENGTH_TYPE) + " giant strength";
        } else if(text.equalsIgnoreCase("horn of valhalla")) {
            rv = text + ": " + rollOnMiscItemTable(MiscItemTable.HORN_OF_VALHALLA_TYPE);
        } else if(text.equalsIgnoreCase("incense of meditation (C)") ||
                  text.equalsIgnoreCase("incense of obsession (C)")) {
            int numPieces = dice.roll1D4() + dice.roll1D4();
            rv = text + " " + numPieces + " pieces";
        } else if(text.equalsIgnoreCase("javelin of lightning (F)")) {
            int numJavelins = dice.roll1D4() + 1;
            rv = numJavelins + " javelins of lightning";
        } else if(text.equalsIgnoreCase("javelin of piercing (F)")) {
            int numJavelins = dice.roll1D4() + dice.roll1D4();
            rv = numJavelins + " javelins of piercing";
        } else if(text.equalsIgnoreCase("keoghtom's ointment")) {
            int numJars = dice.getAmount("1d3", 1);
            rv = text + " " + numJars + " jars";
        } else if(text.equalsIgnoreCase("mirror of life trapping")) {
            int numCompartments = dice.roll1D6() + 12;
            rv = text + " " + numCompartments + " compartments";
        } else if(text.equalsIgnoreCase("nolzur's marvelous pigments")) {
            int numPigments = dice.roll1D4();
            rv = text + " " + numPigments + " pots";
        } else if(text.equalsIgnoreCase("pipes of the sewers")) {
            String rats = "giant rats";
            int roll = dice.rollPercent();
            if(roll <= 20) {
                rats = "normal rats";
            }
            rv = text + " - " + rats;
        }


        return rv;
    }

    private String getCloakSize() {
        int sizing = dice.roll1D4();
        String sizeStr = "human or elvenkind size";
        if(sizing == 4) {
            sizeStr = "dwarf, gnome, or halfling size";
        }
        return sizeStr;
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
