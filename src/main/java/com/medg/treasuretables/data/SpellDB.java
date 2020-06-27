package com.medg.treasuretables.data;

import com.medg.treasuretables.SpellCasterClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SpellDB {

    private Map<Integer, List<String>> clericSpellsByLevel;
    private Map<Integer, List<String>> druidSpellsByLevel;
    private Map<Integer, List<String>> muSpellsByLevel;
    private Map<Integer, List<String>> illusionistSpellsByLevel;
    private Map<SpellCasterClass, Map<Integer, List<String >>> spellsByCasterClass;

    void initialize() {
        clericSpellsByLevel = new HashMap<>();
        for(int i = 1; i <= 7; i++) {
            String filename = String.format("add1/spells/clericSpells/level%d.txt", i);
            List<String> spells = loadDataFile(filename);
            clericSpellsByLevel.put(i, spells);
        }
        druidSpellsByLevel = new HashMap<>();
        for(int i = 1; i <= 7; i++) {
            String filename = String.format("add1/spells/druidSpells/level%d.txt", i);
            List<String> spells = loadDataFile(filename);
            druidSpellsByLevel.put(i, spells);
        }
        muSpellsByLevel = new HashMap<>();
        for(int i = 1; i <= 9; i++) {
            String filename = String.format("add1/spells/muSpells/level%d.txt", i);
            List<String> spells = loadDataFile(filename);
            muSpellsByLevel.put(i, spells);
        }
        illusionistSpellsByLevel = new HashMap<>();
        for(int i = 1; i <= 7; i++) {
            String filename = String.format("add1/spells/illusionistSpells/level%d.txt", i);
            List<String> spells = loadDataFile(filename);
            illusionistSpellsByLevel.put(i, spells);
        }

        spellsByCasterClass = new HashMap<>();
        spellsByCasterClass.put(SpellCasterClass.CLERIC, clericSpellsByLevel);
        spellsByCasterClass.put(SpellCasterClass.DRUID, druidSpellsByLevel);
        spellsByCasterClass.put(SpellCasterClass.MAGIC_USER, muSpellsByLevel);
        spellsByCasterClass.put(SpellCasterClass.ILLUSIONIST, illusionistSpellsByLevel);
    }

    List<String> getSpellsByLevelAndClass(SpellCasterClass spellCasterClass, int level) {
        List<String> spellList = spellsByCasterClass.get(spellCasterClass).get(level);
        return spellList;
    }

    private List<String> loadDataFile(String filename) {
        List<String> spells = null;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            byte[] allBytes = inputStream.readAllBytes();
            inputStream.close();
            String allLines = new String(allBytes);
            spells = Arrays.asList(allLines.split("\n"));
        } catch (IOException ioe) {
            System.err.println("error reading from data file " + filename);
            ioe.printStackTrace();
        }

        return spells;
    }

}
