package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.add1.data.MagicTreasureDB;
import com.medg.treasuretables.add1.enums.MagicTreasureType;
import com.medg.treasuretables.add1.generators.MagicItemGenerator;
import com.medg.treasuretables.add1.generators.MagicTableRoller;
import com.medg.treasuretables.add1.generators.PotionColorGenerator;
import com.medg.treasuretables.add1.miscItems.MiscItemTableRoller;
import com.medg.treasuretables.dice.Dice;
import com.medg.treasuretables.dice.RandomNumberGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MagicItemGeneratorTest {

    @Test
    public void testGetMagicItemOfTypePotion() {
        ItemEntry itemEntry = new ItemEntry(1,100,"healing");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), eq(MagicTreasureType.POTION))).thenReturn(itemEntry);
        Dice dice = new Dice(new RandomNumberGenerator());
        PotionColorGenerator potionColorGenerator = mock(PotionColorGenerator.class);
        when(potionColorGenerator.getPotionColor()).thenReturn("cloudy yellow");
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        magicItemGenerator.getPotionGenerator().setPotionColorGenerator(potionColorGenerator);
        assertEquals("potion of healing (cloudy yellow)", magicItemGenerator.getMagicItemOfType(MagicTreasureType.POTION));
    }

    @Test
    public void testGetMagicItemOfTypeScroll() {
        ItemEntry itemEntry = new ItemEntry(1,100,"protection from evil");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), eq(MagicTreasureType.SCROLL))).thenReturn(itemEntry);
        Dice dice = new Dice(new RandomNumberGenerator());
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);

        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("scroll of protection from evil", magicItemGenerator.getMagicItemOfType(MagicTreasureType.SCROLL));
    }

    @Test
    public void testGetMagicItemOfTypeRing() {
        ItemEntry itemEntry = new ItemEntry(1,100,"invisibility");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), eq(MagicTreasureType.RING))).thenReturn(itemEntry);
        Dice dice = new Dice(new RandomNumberGenerator());
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.RING)).thenReturn("invisibility");


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("ring of invisibility", magicItemGenerator.getMagicItemOfType(MagicTreasureType.RING));
    }

    @Test
    public void testGetMagicItemOfTypeSword() {
        ItemEntry itemEntry = new ItemEntry(1,100,"+1");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(anyInt(), eq(MagicTreasureType.SWORD))).thenReturn(itemEntry);
        when(magicTreasureDB.getSwordIntelligence(anyInt())).thenReturn("none:none:none");
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(50).thenReturn(99);
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("longsword +1 (NSA)", magicItemGenerator.getMagicItemOfType(MagicTreasureType.SWORD));
    }

    @Test
    public void testGetMagicItemOfTypeArmor() {
        ItemEntry itemEntry = new ItemEntry(1,100,"chain mail +1");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(50).thenReturn(99);
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.ARMOR)).thenReturn(itemEntry.description);

        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("human-sized chain mail +1", magicItemGenerator.getMagicItemOfType(MagicTreasureType.ARMOR));
    }

    @Test
    public void testGetMagicItemOfTypeArmorShield() {
        ItemEntry itemEntry = new ItemEntry(1,100,"Shield +1");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(50).thenReturn(99);
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);
        when(magicTableRoller.rollOnTable(MagicTreasureType.ARMOR)).thenReturn(itemEntry.description);

        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("Shield +1", magicItemGenerator.getMagicItemOfType(MagicTreasureType.ARMOR));
    }

    @Test
    public void testGetMagicItemOfTypeAny() {
        int firstRoll = 40;
        int secondRoll = 30;
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(firstRoll).thenReturn(secondRoll);

        ItemEntry anyEntry = new ItemEntry(1,100,"POTION");
        ItemEntry potionEntry = new ItemEntry(1,100,"healing");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(firstRoll, MagicTreasureType.ANY)).thenReturn(anyEntry);
        when(magicTreasureDB.getMagicItemFromDB(secondRoll, MagicTreasureType.POTION)).thenReturn(potionEntry);
        PotionColorGenerator potionColorGenerator = mock(PotionColorGenerator.class);
        when(potionColorGenerator.getPotionColor()).thenReturn("cloudy yellow");
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        magicItemGenerator.getPotionGenerator().setPotionColorGenerator(potionColorGenerator);
        assertEquals("potion of healing (cloudy yellow)", magicItemGenerator.getMagicItemOfType(MagicTreasureType.ANY));
    }

    @Test
    public void testGetMagicItemOfTypeMisc() {
        int firstRoll = 40;
        int secondRoll = 30;
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(firstRoll).thenReturn(secondRoll);

        ItemEntry anyEntry = new ItemEntry(1,100,"MISC2");
        ItemEntry miscEntry = new ItemEntry(1,100,"misc item");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(firstRoll, MagicTreasureType.ANY)).thenReturn(anyEntry);
        when(magicTreasureDB.getMagicItemFromDB(secondRoll, MagicTreasureType.MISC2)).thenReturn(miscEntry);
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("misc item", magicItemGenerator.getMagicItemOfType(MagicTreasureType.MISC));
    }

    @Test
    public void testGetMagicItemOfTypeSwordArmorMiscWeapon() {
        int firstRoll = 60;
        int secondRoll = 40;
        int thirdRoll = 99;
        int fourthRoll = 99;
        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(firstRoll).thenReturn(secondRoll).thenReturn(thirdRoll).thenReturn(fourthRoll);

        ItemEntry miscEntry = new ItemEntry(1, 1, "MISC");
        ItemEntry swordEntry = new ItemEntry(1,50,"SWORD");
        ItemEntry swordTableEntry = new ItemEntry(1,100,"+1");
        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(firstRoll, MagicTreasureType.ANY)).thenReturn(miscEntry);
        when(magicTreasureDB.getMagicItemFromDB(secondRoll, MagicTreasureType.ANY)).thenReturn(swordEntry);
        when(magicTreasureDB.getMagicItemFromDB(thirdRoll, MagicTreasureType.SWORD)).thenReturn(swordTableEntry);
        when(magicTreasureDB.getSwordIntelligence(anyInt())).thenReturn("none:none:none");
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        assertEquals("bastard sword +1 (NSA)", magicItemGenerator.getMagicItemOfType(MagicTreasureType.SWORD_ARMOR_OR_MISC_WEAPON));
    }

    @Test
    public void testGetMagicItemOfTypeAnyNoWeapons() {
        int firstRoll = 60;
        int secondRoll = 40;
        int thirdRoll = 99;

        Dice dice = mock(Dice.class);
        when(dice.rollPercent()).thenReturn(firstRoll).thenReturn(secondRoll).thenReturn(thirdRoll);
        ItemEntry potionEntry = new ItemEntry(1, 1, "POTION");
        ItemEntry swordEntry = new ItemEntry(1,50,"SWORD");
        ItemEntry potionSubTableEntry = new ItemEntry(1, 1, "healing");

        MagicTreasureDB magicTreasureDB = mock(MagicTreasureDB.class);
        when(magicTreasureDB.getMagicItemFromDB(firstRoll, MagicTreasureType.ANY)).thenReturn(swordEntry);
        when(magicTreasureDB.getMagicItemFromDB(secondRoll, MagicTreasureType.ANY)).thenReturn(potionEntry);
        when(magicTreasureDB.getMagicItemFromDB(thirdRoll, MagicTreasureType.POTION)).thenReturn(potionSubTableEntry);
        PotionColorGenerator potionColorGenerator = mock(PotionColorGenerator.class);
        when(potionColorGenerator.getPotionColor()).thenReturn("cloudy yellow");
        MiscItemTableRoller miscItemTableRoller = mock(MiscItemTableRoller.class);
        MagicTableRoller magicTableRoller = mock(MagicTableRoller.class);


        MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller, magicTableRoller);
        magicItemGenerator.getPotionGenerator().setPotionColorGenerator(potionColorGenerator);
        assertEquals("potion of healing (cloudy yellow)", magicItemGenerator.getMagicItemOfType(MagicTreasureType.ANY_NO_WEAPONS));

    }

}
