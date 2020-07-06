/**
 * 
 */
package com.medg.treasuretables;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.data.TreasureTableLoader;
import com.medg.treasuretables.generators.MagicItemGenerator;
import com.medg.treasuretables.generators.MagicTableRoller;
import com.medg.treasuretables.generators.miscItems.MiscItemTableRoller;
import com.medg.treasuretables.ui.TTFrame;

import javax.swing.JFrame;


/**
 * @author Matthew Grossman
 * @version Jan 24, 2013
 */
public class TreasureTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Treasure Generator");

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Dice dice = new Dice(randomNumberGenerator);
		MagicTreasureDB magicTreasureDB = new MagicTreasureDB();
		magicTreasureDB.initialize();
		MiscItemTableRoller miscItemTableRoller = new MiscItemTableRoller(dice, magicTreasureDB);
		MagicTableRoller magicTableRoller = new MagicTableRoller(dice, magicTreasureDB);
		MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, dice, miscItemTableRoller,
				magicTableRoller);
		TreasureTableLoader treasureTableLoader = new TreasureTableLoader();

		TreasureTypeContainer treasureTypeContainer = new TreasureTypeContainer(magicItemGenerator, dice, treasureTableLoader);
		
		TTFrame frame = new TTFrame(treasureTypeContainer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
