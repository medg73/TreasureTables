package com.medg.treasuretables.add1.generators;

import com.medg.treasuretables.ItemEntry;

import java.util.List;

public abstract class Generator {

    protected String getSubtypeText(int roll, List<ItemEntry> types) {
        String subtype = "error";
        for(ItemEntry itemEntry : types) {
            if(roll <= itemEntry.maxRange) {
                subtype = itemEntry.description;
                break;
            }
        }
        return subtype;
    }
}
