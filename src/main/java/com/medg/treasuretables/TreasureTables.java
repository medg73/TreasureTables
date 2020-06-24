/**
 * 
 */
package com.medg.treasuretables;
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

		TreasureTypeContainer treasureTypeContainer = new TreasureTypeContainer();
		
		TTFrame frame = new TTFrame(treasureTypeContainer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	
	
}
