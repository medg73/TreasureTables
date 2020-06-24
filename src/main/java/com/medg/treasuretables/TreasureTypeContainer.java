package com.medg.treasuretables;

import java.util.Map;
import java.util.Set;

public class TreasureTypeContainer {

    private Map<String, TreasureType> treasureTypes;

    public TreasureTypeContainer() {
        this.treasureTypes = TreasureType.loadTreasureTypes();
    }

    public String generateTreasure(String treasureType) {
        return treasureTypes.get(treasureType).genTreasure();
    }

    public Set<String> getAllTreasureTypeNames() {
        return treasureTypes.keySet();
    }

}
