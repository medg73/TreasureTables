package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.SpellCasterClass;
import com.medg.treasuretables.data.MagicTreasureDB;

import java.util.List;

public class SpellGenerator {

    private Dice dice;
    private MagicTreasureDB magicTreasureDB;

    SpellGenerator(Dice dice, MagicTreasureDB magicTreasureDB) {
        this.dice = dice;
        this.magicTreasureDB = magicTreasureDB;
    }

    String getRandomSpell(SpellCasterClass spellCasterClass, int level) {
        try {
            List<String> spells = magicTreasureDB.getSpellsByLevelAndClass(spellCasterClass, level);
            int spell = dice.rollAmount("1d" + spells.size(), 1);
            return spells.get(spell - 1);
        } catch(Exception e) {
            System.err.println("getRandomSpell called with class " + spellCasterClass.getName() + " level " + level);
            e.printStackTrace();
            throw e;
        }
    }
}
