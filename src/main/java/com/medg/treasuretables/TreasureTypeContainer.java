package com.medg.treasuretables;

import com.medg.treasuretables.data.SimpleTreasureTable;
import com.medg.treasuretables.data.SimpleTreasureType;
import com.medg.treasuretables.data.TreasureTableLoader;
import com.medg.treasuretables.generators.MagicItemGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TreasureTypeContainer {

    private Map<String, TreasureType> treasureTypes;
    private Dice dice;
    private TreasureTableLoader treasureTableLoader;

    public TreasureTypeContainer(MagicItemGenerator magicItemGenerator, Dice dice, TreasureTableLoader treasureTableLoader) {
        this.dice = dice;
        this.treasureTableLoader = treasureTableLoader;
        this.treasureTypes = loadTreasureTypes(magicItemGenerator);

    }

    public String generateTreasure(String treasureType) {
        return treasureTypes.get(treasureType).genTreasure();
    }

    public Set<String> getAllTreasureTypeNames() {
        return treasureTypes.keySet();
    }

    private Map<String,TreasureType> loadTreasureTypes(MagicItemGenerator magicItemGenerator) {

        SimpleTreasureTable simpleTreasureTable = treasureTableLoader.loadTreasureTable();
        Map<String,TreasureType> rv = new HashMap<String,TreasureType>();

        SimpleTreasureType[] simpleTreasureTypes = simpleTreasureTable.getTreasureTypes();
        for(int i = 0; i < simpleTreasureTypes.length; i++) {
            SimpleTreasureType simpleTreasureType = simpleTreasureTypes[i];
            TreasureType treasureType = new TreasureType(simpleTreasureType.getType());
            treasureType.addTreasureAmount(TreasureColumns.Copper,
                    new TreasureAmount(dice,
                            simpleTreasureType.getCopper().getChance(),
                            simpleTreasureType.getCopper().getQuantity(),
                            simpleTreasureType.getCopper().getMultiplier(),
                            simpleTreasureType.getCopper().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Silver,
                    new TreasureAmount(dice,
                            simpleTreasureType.getSilver().getChance(),
                            simpleTreasureType.getSilver().getQuantity(),
                            simpleTreasureType.getSilver().getMultiplier(),
                            simpleTreasureType.getSilver().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Electrum,
                    new TreasureAmount(dice,
                            simpleTreasureType.getElectrum().getChance(),
                            simpleTreasureType.getElectrum().getQuantity(),
                            simpleTreasureType.getElectrum().getMultiplier(),
                            simpleTreasureType.getElectrum().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Gold,
                    new TreasureAmount(dice,
                            simpleTreasureType.getGold().getChance(),
                            simpleTreasureType.getGold().getQuantity(),
                            simpleTreasureType.getGold().getMultiplier(),
                            simpleTreasureType.getGold().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Platinum,
                    new TreasureAmount(dice,
                            simpleTreasureType.getPlatinum().getChance(),
                            simpleTreasureType.getPlatinum().getQuantity(),
                            simpleTreasureType.getPlatinum().getMultiplier(),
                            simpleTreasureType.getPlatinum().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Gems,
                    new TreasureAmount(dice, TreasureColumns.Gems,
                            simpleTreasureType.getGems().getChance(),
                            simpleTreasureType.getGems().getQuantity(),
                            simpleTreasureType.getGems().getMultiplier(),
                            simpleTreasureType.getGems().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Jewelry,
                    new TreasureAmount(dice, TreasureColumns.Jewelry,
                            simpleTreasureType.getJewelry().getChance(),
                            simpleTreasureType.getJewelry().getQuantity(),
                            simpleTreasureType.getJewelry().getMultiplier(),
                            simpleTreasureType.getJewelry().getDescription()));
            treasureType.addTreasureAmount(TreasureColumns.Magic,
                    new TreasureAmount(dice, TreasureColumns.Magic,
                            simpleTreasureType.getMagic().getChance(),
                            simpleTreasureType.getMagic().getQuantity(),
                            simpleTreasureType.getMagic().getMultiplier(),
                            simpleTreasureType.getMagic().getDescription(), magicItemGenerator));
            rv.put(simpleTreasureType.getType(), treasureType);

        }

        return rv;

    }
}
