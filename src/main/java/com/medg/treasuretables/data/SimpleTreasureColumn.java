package com.medg.treasuretables.data;

public class SimpleTreasureColumn {

    private double chance = 0.0;
    private String quantity = "";
    private int multiplier = 1;
    private String description = "";

    public SimpleTreasureColumn() {
        // no-args constructor
    }

    public double getChance() {
        return chance;
    }

    public String getQuantity() {
        return quantity;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getDescription() {
        return description;
    }
}
