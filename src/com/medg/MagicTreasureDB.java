/**
 * 
 */
package com.medg;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matthew Grossman
 * @version Sep 3, 2019
 */
public class MagicTreasureDB {

	Map<MagicTreasureType, List<ItemEntry>> magicTreasureTypeMap;

	public void initialize() {

		magicTreasureTypeMap = new HashMap<>();

		magicTreasureTypeMap.put(MagicTreasureType.POTION, loadDataFile("potions.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ARMOR, loadDataFile("armorAndShield.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC1, loadDataFile("miscMagic1.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC2, loadDataFile("miscMagic2.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC3, loadDataFile("miscMagic3.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC4, loadDataFile("miscMagic4.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC5, loadDataFile("miscMagic5.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC_WEAPON, loadDataFile("miscWeapon.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RING, loadDataFile("rings.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RSW, loadDataFile("rsw.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SCROLL, loadDataFile("scrolls.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SWORD, loadDataFile("swords.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ANY, loadDataFile("magicItems.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MAP, loadDataFile("map.csv"));
	}

	public List<ItemEntry> loadDataFile(String filename) {
		List<ItemEntry> dbEntries = new ArrayList<>();
		Path path = FileSystems.getDefault().getPath("resources", filename);
		try {
			List<String> lines = Files.readAllLines(path);
			dbEntries = new ArrayList<>();
			for(String line : lines) {
				String[] fields = line.split(",");
				dbEntries.add(new ItemEntry(fields[0],fields[1],fields[2]));
			}
		} catch(IOException ioe) {
			System.err.println("error reading from data file " + filename);
			ioe.printStackTrace();
		}
		return dbEntries;
	}

	public ItemEntry getMagicItemFromDB(int roll, MagicTreasureType magicTreasureType) {
		List<ItemEntry> magicItemList = magicTreasureTypeMap.get(magicTreasureType);
		for(ItemEntry magicItem : magicItemList) {
			if(magicItem.minRange <= roll && magicItem.maxRange >= roll) {
				return magicItem;
			}
		}

		throw new RuntimeException("getMagicItemFromDB: Can't find magic item of type " + magicTreasureType + " roll: " + roll);
	}
	
	
}
