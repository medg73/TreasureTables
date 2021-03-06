package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import com.medg.treasuretables.add1.miscItems.MiscItemTableRoller;

public class MagicItemGenerator {

    private MagicTreasureDB magicTreasureDB;
    private Dice dice;
    private PotionGenerator potionGenerator;
    private ScrollGenerator scrollGenerator;
    private SpellGenerator spellGenerator;
    private RingGenerator ringGenerator;
    private RSWGenerator rswGenerator;
    private MiscGenerator miscGenerator;
    private PotionColorGenerator potionColorGenerator;
    private SwordGenerator swordGenerator;
    private ArmorGenerator armorGenerator;
    private MiscWeaponGenerator miscWeaponGenerator;


    public MagicItemGenerator(MagicTreasureDB magicTreasureDB, Dice dice, MiscItemTableRoller miscItemTableRoller,
                              MagicTableRoller magicTableRoller) {
        this.magicTreasureDB = magicTreasureDB;
        this.dice = dice;
        potionColorGenerator = new PotionColorGenerator(dice);
        potionGenerator = new PotionGenerator(magicTreasureDB, dice, potionColorGenerator);
        spellGenerator = new SpellGenerator(magicTreasureDB, dice);
        scrollGenerator = new ScrollGenerator(magicTreasureDB, dice, spellGenerator);
        ringGenerator = new RingGenerator(dice, magicTableRoller, spellGenerator);
        rswGenerator = new RSWGenerator(magicTreasureDB, dice, spellGenerator);
        miscGenerator = new MiscGenerator(magicTreasureDB, dice, spellGenerator, potionGenerator, miscItemTableRoller);
        swordGenerator = new SwordGenerator(magicTreasureDB, dice);
        armorGenerator = new ArmorGenerator(dice, magicTableRoller);
        miscWeaponGenerator = new MiscWeaponGenerator(dice, magicTableRoller);

    }

    public String getMagicItemOfType(MagicTreasureType magicTreasureType) {
        String prefix = "";
        String rv = "";
        ItemEntry magicSubTable;
        MagicTreasureType itemType;

        switch(magicTreasureType) {
            case POTION:
                rv = potionGenerator.getItemText();
                break;
            case SCROLL:
                rv = scrollGenerator.getItemText();
                break;
            case RING:
                rv = ringGenerator.getItemText();
                break;
            case ARMOR:
                rv = armorGenerator.getMagicArmor();
                break;
            case SWORD:
                rv = swordGenerator.getMagicSword();
                break;

            case RSW:
                rv = rswGenerator.getItemText();
                break;
            case MISC1:
            case MISC2:
            case MISC3:
            case MISC4:
            case MISC5:
                String text = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), magicTreasureType).description;
                rv = miscGenerator.getMiscItemText(text);
                break;
            case MISC_WEAPON:
                rv = miscWeaponGenerator.getMiscWeapon();
                break;
            case MAP:
                rv = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), magicTreasureType).description;
                break;

            case MISC:
                do {
                    magicSubTable = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.ANY);
                } while(!(magicSubTable.description.equals("MISC1") ||
                          magicSubTable.description.equals("MISC2") ||
                          magicSubTable.description.equals("MISC3") ||
                          magicSubTable.description.equals("MISC4") ||
                          magicSubTable.description.equals("MISC5")));
                itemType = MagicTreasureType.valueOf(magicSubTable.description);
                rv = this.getMagicItemOfType(itemType);
                break;

            case SWORD_ARMOR_OR_MISC_WEAPON:
                do {
                    magicSubTable = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.ANY);
                } while(!(magicSubTable.description.equals("SWORD") ||
                          magicSubTable.description.equals("ARMOR") ||
                          magicSubTable.description.equals("MISC_WEAPON")));
                itemType = MagicTreasureType.valueOf(magicSubTable.description);
                rv = this.getMagicItemOfType(itemType);
                break;

            case ANY_NO_WEAPONS:
                do {
                    magicSubTable = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), MagicTreasureType.ANY);
                } while(magicSubTable.description.equals("SWORD") || magicSubTable.description.equals("MISC_WEAPON"));
                itemType = MagicTreasureType.valueOf(magicSubTable.description);
                rv = this.getMagicItemOfType(itemType);
                break;

            case ANY:
                ItemEntry magicItemType = magicTreasureDB.getMagicItemFromDB(dice.rollPercent(), magicTreasureType);
                itemType = MagicTreasureType.valueOf(magicItemType.description);
                rv = this.getMagicItemOfType(itemType);
                break;

            default:
                throw new RuntimeException("unknown magic item type " + magicTreasureType);
        }
        return rv;
    }

    public PotionGenerator getPotionGenerator() {
        return potionGenerator;
    }

}
