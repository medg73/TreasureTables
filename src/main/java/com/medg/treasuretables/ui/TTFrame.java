/**
 * 
 */
package com.medg.treasuretables.ui;

import com.medg.treasuretables.TreasureTypeContainer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> ttComboBox;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea outputArea;

	private TreasureTypeContainer treasureTypeContainer;

	public TTFrame(TreasureTypeContainer treasureTypeContainer) {

		this.treasureTypeContainer = treasureTypeContainer;
		setTitle("Treasure Generator");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		panel1 = new JPanel();
		GenTreasureAction genTreasureAction = new GenTreasureAction();
		JButton genTreasureButton = new JButton("Generate Treasure");
		genTreasureButton.addActionListener(genTreasureAction);
		panel1.add(genTreasureButton);

		panel1.add(new JLabel("Select Treasure Type"));
		ttComboBox = new JComboBox<String>();
		for(String str : treasureTypeContainer.getAllTreasureTypeNames()) {
			ttComboBox.addItem(str);
		}
		panel1.add(ttComboBox);

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
	}
	
	private class GenTreasureAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String currentTT = (String)ttComboBox.getSelectedItem();
			String output = "";

			output = treasureTypeContainer.generateTreasure(currentTT);
			outputArea.setText(output);
		}
	}
	
	
}
