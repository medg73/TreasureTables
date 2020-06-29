/**
 * 
 */
package com.medg.treasuretables.data;

import com.medg.treasuretables.ItemEntry;
import com.medg.treasuretables.MagicTreasureType;
import com.medg.treasuretables.SpellCasterClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Matthew Grossman
 * @version Sep 3, 2019
 */
public class MagicTreasureDB {

	private Map<MagicTreasureType, List<ItemEntry>> magicTreasureTypeMap;
	private SpellDB spellDB;

	private List<ItemEntry> swordAlignment;
	private List<ItemEntry> swordExtraordinary;
	private List<ItemEntry> swordIntelligence;
	private List<ItemEntry> swordLanguages;
	private List<ItemEntry> swordPrimary;
	private List<ItemEntry> swordSpecialPurpose;
	private List<ItemEntry> swordSpecialPurposePower;

	public void initialize() {

		magicTreasureTypeMap = new HashMap<>();

		magicTreasureTypeMap.put(MagicTreasureType.POTION, loadDataFile("add1/magicTreasureTables/potions.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ARMOR, loadDataFile("add1/magicTreasureTables/armorAndShield.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC1, loadDataFile("add1/magicTreasureTables/miscMagic1.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC2, loadDataFile("add1/magicTreasureTables/miscMagic2.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC3, loadDataFile("add1/magicTreasureTables/miscMagic3.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC4, loadDataFile("add1/magicTreasureTables/miscMagic4.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC5, loadDataFile("add1/magicTreasureTables/miscMagic5.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MISC_WEAPON, loadDataFile("add1/magicTreasureTables/miscWeapon.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RING, loadDataFile("add1/magicTreasureTables/rings.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.RSW, loadDataFile("add1/magicTreasureTables/rsw.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SCROLL, loadDataFile("add1/magicTreasureTables/scrolls.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.SWORD, loadDataFile("add1/magicTreasureTables/swords.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.ANY, loadDataFile("add1/magicTreasureTables/magicItems.csv"));
		magicTreasureTypeMap.put(MagicTreasureType.MAP, loadDataFile("add1/magicTreasureTables/map.csv"));

		this.spellDB = new SpellDB();
		this.spellDB.initialize();

		swordAlignment = loadDataFile("add1/magicTreasureTables/swords/swordAlignment.csv");
		swordExtraordinary = loadDataFile("add1/magicTreasureTables/swords/swordExtraordinary.csv");
		swordIntelligence = loadDataFile("add1/magicTreasureTables/swords/swordIntelligence.csv");
		swordLanguages = loadDataFile("add1/magicTreasureTables/swords/swordLanguages.csv");
		swordPrimary = loadDataFile("add1/magicTreasureTables/swords/swordPrimary.csv");
		swordSpecialPurpose = loadDataFile("add1/magicTreasureTables/swords/swordSpecialPurpose.csv");
		swordSpecialPurposePower = loadDataFile("add1/magicTreasureTables/swords/swordSpecialPurposePower.csv");
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

	public String getSwordAlignment(int roll) {
		return getDescription(roll, swordAlignment, "sword alignment");
	}

	private String getDescription(int roll, List<ItemEntry> itemEntries, String name) {
		for(ItemEntry itemEntry : itemEntries) {
			if(itemEntry.minRange <= roll && itemEntry.maxRange >= roll) {
				return itemEntry.description;
			}
		}
		throw new RuntimeException("Can't get " + name + " for roll " + roll);
	}

	public String getSwordExtraordinary(int roll) {
		return getDescription(roll, swordExtraordinary, "sword extraordinary");
	}

	public String getSwordIntelligence(int roll) {
		return getDescription(roll, swordIntelligence, "sword intelligence");
	}

	public String getSwordLanguages(int roll) {
		return getDescription(roll, swordLanguages, "sword language");
	}

	public String getSwordPrimary(int roll) {
		return getDescription(roll, swordPrimary, "sword primary");
	}

	public String getSwordSpecialPurpose(int roll) {
		return getDescription(roll, swordSpecialPurpose, "sword special purpose");
	}

	public String getSwordSpecialPurposePower(int roll) {
		return getDescription(roll, swordSpecialPurposePower, "sword special purpose power");
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

	
	
}
