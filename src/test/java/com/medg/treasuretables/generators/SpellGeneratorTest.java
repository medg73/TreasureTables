package com.medg.treasuretables.generators;

import com.medg.treasuretables.Dice;
import com.medg.treasuretables.SpellCasterClass;
import com.medg.treasuretables.data.MagicTreasureDB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpellGeneratorTest {

    @Test
    public void testGetRandomSpell() {
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        List<String> spellList = Arrays.asList("Cure Light Wounds", "Dispel Evil", "Protection From Evil");
        Dice dice = mock(Dice.class);
        when(dice.rollAmount(eq("1d3"),eq(1))).thenReturn(2);
        int level = 1;
        SpellCasterClass spellCasterClass = SpellCasterClass.CLERIC;
        when(magicTreasureDB.getSpellsByLevelAndClass(spellCasterClass, level)).thenReturn(spellList);

        SpellGenerator spellGenerator = new SpellGenerator(dice, magicTreasureDB);
        String spell = spellGenerator.getRandomSpell(spellCasterClass, level);
        assertEquals("Dispel Evil", spell);
    }
}
