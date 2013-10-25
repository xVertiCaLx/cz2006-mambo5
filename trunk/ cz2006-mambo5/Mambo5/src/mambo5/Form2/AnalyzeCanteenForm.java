package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;


import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Menu;

public class AnalyzeCanteenForm extends JPanel  {

	private JTable menuTable;
	private CamsMainFrame mainFrame;
	private CanteenController cc;

	/**
	 * Create the frame.
	 */
	public AnalyzeCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Analyze Canteen");
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 99, 14);
		add(availableLabel);
		
		getJTableMenu();
		menuTable.setBounds(10, 52, 414, 163);
		add(menuTable);
		//mainFrame.getContentPane().add(new JScrollPane(menuTable));
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 8, 28, 20);
		add(availableCB);
		
		JButton analyzeBtn = new JButton("Analyze");
		analyzeBtn.setBounds(164, 7, 89, 23);
		add(analyzeBtn);
		
		JScrollPane scrollPane = new JScrollPane(menuTable);
		scrollPane.setBounds(28, 52, 396, 314);
		add(scrollPane);
	}
	
	private void getJTableMenu() {
		menuTable = new JTable();
		menuTable.setEnabled(false);
		menuTable.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		menuTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		DefaultTableModel tableModel = (DefaultTableModel) menuTable.getModel();
		
		String[] colName = {"StallID", "MenuID", "MenuType"};
		tableModel.setColumnIdentifiers(colName);

		cc = new CanteenController();
		ArrayList<Menu> menuList = cc.triggerRetrieveMenu(1);
		for(int i=0; i<menuList.size(); i++) {
			
			Object[] objects = new Object[3];
			objects[0] = menuList.get(i).getStallID();
			objects[1] = menuList.get(i).getMenuID();
			objects[2] = menuList.get(i).getMenuType();

			tableModel.addRow(objects);	
		}
		
		menuTable.setModel(tableModel);
	
	}
}
