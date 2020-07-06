package com.medg.treasuretables.add1.data;

public class SimpleTreasureType {
    private String type;
    private SimpleTreasureColumn copper;
    private SimpleTreasureColumn silver;
    private SimpleTreasureColumn electrum;
    private SimpleTreasureColumn gold;
    private SimpleTreasureColumn platinum;
    private SimpleTreasureColumn gems;
    private SimpleTreasureColumn jewelry;
    private SimpleTreasureColumn magic;

    public SimpleTreasureType() {
        // no args constructor
    }

    public String getType() {
        return type;
    }

    public SimpleTreasureColumn getCopper() {
        return copper;
    }

    public SimpleTreasureColumn getSilver() {
        return silver;
    }

    public SimpleTreasureColumn getElectrum() {
        return electrum;
    }

    public SimpleTreasureColumn getGold() {
        return gold;
    }

    public SimpleTreasureColumn getPlatinum() {
        return platinum;
    }

    public SimpleTreasureColumn getGems() {
        return gems;
    }

    public SimpleTreasureColumn getJewelry() {
        return jewelry;
    }

    public SimpleTreasureColumn getMagic() {
        return magic;
    }
}
