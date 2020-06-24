/**
 * 
 */
package com.medg.treasuretables;
import com.medg.treasuretables.data.MagicTreasureDB;
import com.medg.treasuretables.generators.MagicItemGenerator;

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

		MagicTreasureDB magicTreasureDB = new MagicTreasureDB();
		magicTreasureDB.initialize();
		MagicItemGenerator magicItemGenerator = new MagicItemGenerator(magicTreasureDB, new Dice());

		TreasureTypeContainer treasureTypeContainer = new TreasureTypeContainer(magicItemGenerator);
		
		TTFrame frame = new TTFrame(treasureTypeContainer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
