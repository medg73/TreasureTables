/**
 * 
 */
package com.medg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Matthew Grossman
 * @version Jan 25, 2013
 */
public class TTFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> ttComboBox;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea outputArea;
	private Map<String, TreasureType> treasureTable = TreasureType.loadTreasureTypes();
	private String[] tTypes = { "A", "B", "C", "D", "E", "F", "G", "H", "I", 
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	


	public TTFrame() {
		setTitle("Treasure Generator");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		panel1 = new JPanel();
		GenTreasureAction genTreasureAction = new GenTreasureAction();
		JButton genTreasureButton = new JButton("Generate Treasure");
		genTreasureButton.addActionListener(genTreasureAction);
		panel1.add(genTreasureButton);
//		panel1.add(new JLabel("Generate Treasure"));
		
		panel1.add(new JLabel("Select Treasure Type"));
		ttComboBox = new JComboBox<String>();
		for(String str : tTypes) {
			ttComboBox.addItem(str);
		}
		panel1.add(ttComboBox);
//		ActionListener comboBoxAction = new ChooseTreasureTypeAction();
//		ttComboBox.addActionListener(comboBoxAction);
//		panel1.add(ttComboBox);
	
		
		panel2 = new JPanel();
		outputArea = new JTextArea();
		outputArea.setColumns(40);
		outputArea.setRows(12);
		outputArea.setLineWrap(true);
		outputArea.setWrapStyleWord(true);
		outputArea.setEditable(false);
		panel2.add(outputArea);
		
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		pack();
		
	//	System.out.println("This is a test");
		
	}
	
	private class GenTreasureAction implements ActionListener {
	
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String currentTT = (String)ttComboBox.getSelectedItem();
			String output = "";
			
//			System.err.println("currently selected treasure type is: " + currentTT);
			output = treasureTable.get(currentTT).genTreasure();
			outputArea.setText(output);
//			System.err.println(output);
			
		}
	}
	
	
}
