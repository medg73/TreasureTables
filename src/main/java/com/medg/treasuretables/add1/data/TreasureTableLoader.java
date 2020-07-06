package com.medg.treasuretables.add1.data;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class TreasureTableLoader {

    public SimpleTreasureTable loadTreasureTable() {
        String treasureTypeFile = "add1/treasureTypes.json";
        byte[] allBytes = null;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(treasureTypeFile);
            allBytes = inputStream.readAllBytes();
            inputStream.close();
        } catch (
                IOException ioException) {
            ioException.printStackTrace();
        }
        String allLines = new String(allBytes);
        Gson gson = new Gson();

        SimpleTreasureTable simpleTreasureTable = gson.fromJson(allLines, SimpleTreasureTable.class);

        return simpleTreasureTable;
    }

}
