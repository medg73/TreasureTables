/**
 * 
 */
package com.medg.treasuretables.ui;

import com.medg.treasuretables.add1.enums.MagicTreasureType;
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
	private JComboBox<MagicTreasureType> magicItemTypeComboBox;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JPanel treasureTypeSelectorPanel;
	private JPanel outputPanel;
	private JPanel magicItemPanel;
	private JTextArea outputArea;

	private TreasureTypeContainer treasureTypeContainer;

	public TTFrame(TreasureTypeContainer treasureTypeContainer) {

		this.treasureTypeContainer = treasureTypeContainer;
		setTitle("Treasure Generator");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		makeTreasureTypeSelectorPanel(treasureTypeContainer);

		makeOutputPanel();

		makeMagicItemPanel();

		add(treasureTypeSelectorPanel, BorderLayout.NORTH);
		add(magicItemPanel, BorderLayout.CENTER);
		add(outputPanel, BorderLayout.SOUTH);
		pack();
	}

	private void makeMagicItemPanel() {
		magicItemPanel = new JPanel();
		GenMagicItemAction genMagicItemAction = new GenMagicItemAction();
		JButton genMagicItemButton = new JButton("Generate magic item");
		genMagicItemButton.addActionListener(genMagicItemAction);
		magicItemPanel.add(genMagicItemButton);

		magicItemPanel.add(new JLabel("Generate random magic item"));
		magicItemTypeComboBox = new JComboBox<>();
		for(MagicTreasureType magicTreasureType : MagicTreasureType.values()) {
			magicItemTypeComboBox.addItem(magicTreasureType);
		}
		magicItemPanel.add(magicItemTypeComboBox);
	}

	private void makeOutputPanel() {
		outputPanel = new JPanel();
		outputArea = new JTextArea();
		outputArea.setColumns(40);
		outputArea.setRows(12);
		outputArea.setLineWrap(true);
		outputArea.setWrapStyleWord(true);
		outputArea.setEditable(false);
		outputPanel.add(outputArea);
	}

	private void makeTreasureTypeSelectorPanel(TreasureTypeContainer treasureTypeContainer) {
		treasureTypeSelectorPanel = new JPanel();
		GenTreasureAction genTreasureAction = new GenTreasureAction();
		JButton genTreasureButton = new JButton("Generate Treasure");
		genTreasureButton.addActionListener(genTreasureAction);
		treasureTypeSelectorPanel.add(genTreasureButton);

		treasureTypeSelectorPanel.add(new JLabel("Select Treasure Type"));
		ttComboBox = new JComboBox<String>();
		for(String str : treasureTypeContainer.getAllTreasureTypeNames()) {
			ttComboBox.addItem(str);
		}
		treasureTypeSelectorPanel.add(ttComboBox);
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

	private class GenMagicItemAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MagicTreasureType magicTreasureType = (MagicTreasureType)magicItemTypeComboBox.getSelectedItem();
			String output = "";

			output = treasureTypeContainer.generateMagicItem(magicTreasureType);
			outputArea.setText(output);
		}
	}
	
	
}
