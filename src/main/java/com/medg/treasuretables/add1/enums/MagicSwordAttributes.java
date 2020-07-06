package com.medg.treasuretables.add1.enums;

public enum MagicSwordAttributes {

    ALIGNMENT("sword alignment", "add1/magicTreasureTables/swords/swordAlignment.csv"),
    EXTRAORDINARY("sword extraordinary", "add1/magicTreasureTables/swords/swordExtraordinary.csv"),
    INTELLIGENCE("sword intelligence", "add1/magicTreasureTables/swords/swordIntelligence.csv"),
    LANGUAGES("sword languages", "add1/magicTreasureTables/swords/swordLanguages.csv"),
    PRIMARY("sword primary", "add1/magicTreasureTables/swords/swordPrimary.csv"),
    SPECIAL_PURPOSE("sword special purpose", "add1/magicTreasureTables/swords/swordSpecialPurpose.csv"),
    SPECIAL_PURPOSE_POWER("special purpose power", "add1/magicTreasureTables/swords/swordSpecialPurposePower.csv");

    private String name;
    private String datafile;

    MagicSwordAttributes(String name, String datafile) {
        this.name = name;
        this.datafile = datafile;
    }

    public String getName() {
        return name;
    }

    public String getDatafile() {
        return datafile;
    }
}
