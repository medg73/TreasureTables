/**
 * 
 */
package com.medg.treasuretables;

import com.medg.treasuretables.generators.MagicItemGenerator;

/**
 * @author Matthew Grossman
 * @version Jan 24, 2013
 */
public class TreasureAmount {
	
	private double chance; // expressed as 0-1
	private String quantity; // expressed as xdx, eg 2d6, or a single integer
	private int multiplier; //usually either 1 or 1000
	private String description; // for magic, gems, jewelry
	private TreasureColumns column;
	private MagicItemGenerator magicItemGenerator;
	private Dice dice;

	public void setMagicItemGenerator(MagicItemGenerator magicItemGenerator) {
		this.magicItemGenerator = magicItemGenerator;
	}
	
	private String[] ornamentalStones = {"Azurite", "Banded Agate", "Blue Quartz", "Eye Agate", "Hematite", "Lapis Lazuli", 
			"Malachite",
			"Moss Agate", "Obsidian", "Rhodochrosite", "Tiger Eye"};
	private String[] semiPreciousStones = { "Bloodstone", "Carnelian", "Chelcedony", "Chyrsoprase", "Citrine", "Jasper", "Moonstone", 
			"Onyx", "Rock Crystal",
			"Sardonyx", "Smoky Quartz", "Star Rose Quartz", "Zircon" };
	private String[] fancyStones = { "Amber", "Alexandrite", "Amethyst", "Aquamarine", "Chrysoberyl", "Coral", "Garnet", "Jade", "Jet", 
			"Pearl", 
			"Peridot", "Spinel", "Topaz", "Tourmaline" };
	private String[] gemStones = { "Black Opal", "Black Sapphire", "Diamond", "Emerald", "Fire Opal", "Jacinth", "Opal", 
			"Oriental Amethyst", 
			"Oriental Emerald", "Oriental Topaz", "Ruby", "Sapphire", "Star Ruby", "Star Sapphire" };
	

	public TreasureAmount(Dice dice, TreasureColumns col, double chance, String quantity, int multiplier, String description,
						  MagicItemGenerator magicItemGenerator) {
		this(dice, col, chance, quantity, multiplier, description);
		this.magicItemGenerator = magicItemGenerator;
	}

	public TreasureAmount(Dice dice, TreasureColumns col, double chance, String quantity, int multiplier, String description) {
		this(dice, chance,quantity,multiplier,description);
		column = col;
	}
	
	public TreasureAmount(Dice dice, double chance, String quantity, int multiplier, String description) {
		this.dice = dice;
		this.chance = chance;
		this.quantity = quantity;
		this.multiplier = multiplier;
		this.description = description;
	}



	public String calcResult() {
		double d1 = Math.random();
		String rv = "none";
		
		if(chance > 0.0 && d1 < chance) {
			if (column == TreasureColumns.Magic) {
				rv = getMagicItems();
			}  else {
				int amount = dice.getAmount(quantity, multiplier);
				rv = amount + " " + description;
				if (column == TreasureColumns.Jewelry) {
					String value = getJewelryValueAndDescription();
					rv = rv + value;
				} else if (column == TreasureColumns.Gems) {
					String value = getGemValueAndDescription();
					rv += value;
				}
			}
		}

		return rv;
	}

	public String getMagicItems() {
		String[] magicTreasureQuantities = description.split(":");
		int i = 0;
		String rv = "";
		while(i < magicTreasureQuantities.length) {
			MagicTreasureType magicTreasureType = MagicTreasureType.valueOf(magicTreasureQuantities[i]);
			int amount = dice.getAmount(magicTreasureQuantities[i + 1], 1);

			for (int j = 0; j < amount; j++) {
				String magicItem = magicItemGenerator.getMagicItemOfType(magicTreasureType);
				rv += magicItem;
				if (j < amount - 1) {
					rv += ", ";
				}
			}
			if(i < magicTreasureQuantities.length - 2) {
				rv += ", ";
			}
			i += 2;
		}
		return rv;
	}


	/**
	 * @return
	 */
	public String getGemValueAndDescription() {
		String rv = "";
		String desc = "";
		int baseValueIndex = 0;
		int value = 0;
		int[] baseValues = { 10, 50, 100, 500, 1000, 5000 };
		

		int roll1 = dice.getAmount("1d100", 1);
		if(roll1 <= 25) {
			baseValueIndex = 0;
			desc = getStoneName(ornamentalStones);
		}
		else if(roll1 <= 50) {
			baseValueIndex = 1;
			desc = getStoneName(semiPreciousStones);
		}
		else if(roll1 <= 70) {
			baseValueIndex = 2;
			desc = getStoneName(fancyStones);
		}
		else if(roll1 <= 90) {
			baseValueIndex = 3;
			desc = "large " + getStoneName(fancyStones);
		}
		else if(roll1 <= 99) {
			baseValueIndex = 4;
			desc = getStoneName(gemStones);
		}
		else {
			baseValueIndex = 5;
			desc = "large " + getStoneName(gemStones);
		}
		
		value = baseValues[baseValueIndex];
		rv = " gems, value " + value + " each, " + desc;
		
		return rv;
	}

	private String getStoneName(String[] stones) {
	
		String rv = "";
		
		int index = (int) Math.floor(Math.random() * stones.length);
		rv = stones[index];
		return rv;
	}

	public String getJewelryValueAndDescription() {
		String rv = "";
		int baseValue = 0;
		String desc = "";
		
		int roll1 = dice.getAmount("1d100", 1);
		if(roll1 <= 10) {
			baseValue = dice.getAmount("1d10", 100);
			desc = "Ivory or wrought silver";
		}
		else if(roll1 <= 20) {
			baseValue = dice.getAmount("2d6", 100);
			desc = "Wrought silver and gold";
		}
		else if(roll1 <= 40) {
			baseValue = dice.getAmount("3d6", 100);
			desc =  "Wrought gold";
		}
		else if(roll1 <= 50) {
			baseValue = dice.getAmount("5d6", 100);
			desc = "Jade, coral, or wrought platinum";
		}
		else if(roll1 <= 70) {
			baseValue = dice.getAmount("1d6", 1000);
			desc = "Silver with gems";
		}
		else if(roll1 <= 90) {
			baseValue = dice.getAmount("2d4", 1000);
			desc = "Gold with gems";
		}
		else {
			baseValue = dice.getAmount("2d6", 1000);
			desc = "Platinum with gems";
		}
		
		rv = " pieces, base value is: " + baseValue + " each, material is " + desc;
		return rv;
	}
	
	public String getChance() {
		String rv = "";
		if(chance == 0.0) {
			rv = "none";
		}
		else {
			String pct = Double.valueOf(chance*100.0).toString() + "%";
			String qty = quantity;
			if(multiplier > 1) {
				qty = qty + "*" + multiplier;
			}
			
			rv = pct + " " + qty + " " + description;
		}
		return rv;
	}

}
