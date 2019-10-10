/**
 * 
 */
package com.medg;

//import java.util.HashMap;
//import java.util.Map;

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
		// TODO Auto-generated method stub

		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Treasure Generator");

		
		TTFrame frame = new TTFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}


	
	
}
