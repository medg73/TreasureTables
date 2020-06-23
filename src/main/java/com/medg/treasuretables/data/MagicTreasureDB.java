/**
 * 
 */
package com.medg.treasuretables.data;

import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.SpellCasterClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;

/**
 * @author Matthew Grossman
 * @version Sep 3, 2019
 */
public class MagicTreasureDB {

	private Map<MagicTreasureType, List<ItemEntry>> magicTreasureTypeMap;
	private SpellDB spellDB;

	public void initialize() {

		magicTreasureTypeMap = new HashMap<>();

		magicTreasureTypeMap.put(MagicTreasureType.POTION, loadDataFile("magicTreasureTables/potions.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ARMOR, loadDataFile("magicTreasureTables/armorAndShield.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC1, loadDataFile("magicTreasureTables/miscMagic1.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC2, loadDataFile("magicTreasureTables/miscMagic2.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC3, loadDataFile("magicTreasureTables/miscMagic3.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC4, loadDataFile("magicTreasureTables/miscMagic4.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC5, loadDataFile("magicTreasureTables/miscMagic5.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC_WEAPON, loadDataFile("magicTreasureTables/miscWeapon.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RING, loadDataFile("magicTreasureTables/rings.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RSW, loadDataFile("magicTreasureTables/rsw.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SCROLL, loadDataFile("magicTreasureTables/scrolls.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SWORD, loadDataFile("magicTreasureTables/swords.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ANY, loadDataFile("magicTreasureTables/magicItems.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MAP, loadDataFile("magicTreasureTables/map.csv"));

		this.spellDB = new SpellDB();
		this.spellDB.initialize();
	}

	private List<ItemEntry> loadDataFile(String filename) {
		List<ItemEntry> dbEntries = new ArrayList<>();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
			byte[] allBytes = inputStream.readAllBytes();
			inputStream.close();
			String allLines = new String(allBytes);
//			System.out.println("allLines is: " + allLines);
			List<String> lines = Arrays.asList(allLines.split("\n"));
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

	public List<String> getSpellsByLevelAndClass(SpellCasterClass spellCasterClass, int level) {
		List<String> spellList = this.spellDB.getSpellsByLevelAndClass(spellCasterClass, level);
		return spellList;
	}
	
	
}