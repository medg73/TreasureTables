package com.medg.treasuretables;

public enum MiscItemTable {

    BAG_OF_HOLDING_CAPACITY("bag of holding capacity", "add1/magicTreasureTables/miscItems/bagOfHoldingCapacity.csv", "1d100"),
    BAG_OF_TRICKS_TYPE("bag of tricks type", "add1/magicTreasureTables/miscItems/bagOfTricksTypes.csv", "1d10"),
    BRACERS_OF_DEFENSE_VALUE("bracers of defense value", "add1/magicTreasureTables/miscItems/bracersOfDefenseValue.csv", "1d100"),
    BUCKNARDS_EVERFUL_PURSE_TYPE("Bucknard's everful purse type", "add1/magicTreasureTables/miscItems/bucknardsEverfulPurseType.csv", "1d100");


    private String name;
    private String datafile;
    private String diceType;

    MiscItemTable(String name, String datafile, String diceType) {
        this.name = name;
        this.datafile = datafile;
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
