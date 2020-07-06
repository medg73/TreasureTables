package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.add1.enums.SpellCasterClass;
import com.medg.treasuretables.add1.data.MagicTreasureDB;

import java.util.List;

public class SpellGenerator {

    private Dice dice;
    private MagicTreasureDB magicTreasureDB;

    SpellGenerator(MagicTreasureDB magicTreasureDB, Dice dice) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    SpellCasterClass getSpellcasterClass() {
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

    String getRandomSpell(SpellCasterClass spellCasterClass, int level) {
        try {
            List<String> spells = magicTreasureDB.getSpellsByLevelAndClass(spellCasterClass, level);
            int spell = dice.getAmount("1d" + spells.size(), 1);
            return spells.get(spell - 1);
        } catch(Exception e) {
            System.err.println("getRandomSpell called with class " + spellCasterClass.getName() + " level " + level);
            e.printStackTrace();
            throw e;
        }
    }
}
