package com.medg.treasuretables;

public enum MiscItemTable {

    BAG_OF_HOLDING_CAPACITY("bag of holding capacity", "bagOfHoldingCapacity.csv", "1d100"),
    BAG_OF_TRICKS_TYPE("bag of tricks type", "bagOfTricksTypes.csv", "1d10"),
    BRACERS_OF_DEFENSE_VALUE("bracers of defense value", "bracersOfDefenseValue.csv", "1d100"),
    BUCKNARDS_EVERFUL_PURSE_TYPE("Bucknard's everful purse type", "bucknardsEverfulPurseType.csv", "1d100"),
    CARPET_OF_FLYING_SIZE("carpet of flying size", "carpetOfFlyingSizes.csv", "1d100"),
    CLOAK_OF_PROTECTION_VALUE("cloak of protection value", "cloakOfProtectionValue.csv", "1d100"),
    CRYSTAL_BALL_TYPE("crystal ball type", "crystalBallType.csv", "1d100"),
    FIGURINE_OF_WONDROUS_POWER_TYPE("figurine of wondrous power type", "figurineOfWondrousPowerType.csv", "1d100"),
    MARBLE_ELEPHANT_TYPE("marble elephant type", "marbleElephantType.csv", "1d100"),
    GIRDLE_OF_GIANT_STRENGTH_TYPE("girdle of giant strength type", "girdleOfGiantStrengthType.csv", "1d100"),
    HORN_OF_VALHALLA_TYPE("horn of valhalla type", "hornOfValhallaType.csv", "1d20"),
    IOUN_STONES_TYPE("ioun stones type", "iounStonesType.csv", "1d20");


    String filepath = "add1/magicTreasureTables/miscItems/";
    private String name;
    private String datafile;
    private String diceType;

    MiscItemTable(String name, String filename, String diceType) {
        this.name = name;
        this.datafile = filepath + filename;
        this.diceType = diceType;
    }

    public String getName() {
        return name;
    }

    public String getDatafile() {
        return datafile;
    }

    public String getDiceType() {
        return diceType;
    }
}
