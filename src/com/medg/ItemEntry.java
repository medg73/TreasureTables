package com.medg;

public class ItemEntry {
    public final int minRange;
    public final int maxRange;
    public final String description;

    public ItemEntry(int minRange, int maxRange, String description) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.description = description;
    }

    public ItemEntry(String minRange, String maxRange, String description) {
        this(Integer.parseInt(minRange), Integer.parseInt(maxRange), description);
    }
}
