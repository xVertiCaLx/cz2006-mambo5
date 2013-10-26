package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Menu;

public class AnalyzeCanteenForm extends JPanel  {

	private JTable menuTable;
	private CamsMainFrame mainFrame;
	private CanteenController cc;
	private ArrayList<Canteen> retrieveCanteenList;
	private JComboBox<String> availableCB;
	
	/**
	 * Create the frame.
	 */
	public AnalyzeCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please select Canteen to analyze");
		canteenTitle.setBounds(10, 0, 297, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Analyze Canteen");
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 161, 119, 14);
		add(availableLabel);
		
		getJTableMenu();
		menuTable.setBounds(10, 52, 414, 163);
		add(menuTable);
		
		availableCB = getCanteenList();
		availableCB.setBounds(267, 158, 304, 20);
		availableCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = availableCB.getSelectedIndex();
				
				displayMenu(retrieveCanteenList.get(index).getCanteenID());
				
			}
		});
		add(availableCB);
		
		JScrollPane scrollPane = new JScrollPane(menuTable);
		scrollPane.setBounds(147, 201, 424, 314);
		add(scrollPane);
	}
	
	private void getJTableMenu() {
		menuTable = new JTable();
		menuTable.setEnabled(false);
		menuTable.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		menuTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);	
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
			displayMenu(retrieveCanteenList.get(0).getCanteenID());
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	
	private void displayMenu(int canteenID) {
		//menuTable = new JTable();
		//menuTable.setEnabled(false);
		//menuTable.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		//menuTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);	
		//menuTable.remove(0);
		DefaultTableModel tableModel = (DefaultTableModel) menuTable.getModel();
		
		String[] colName = {"StallID", "MenuID", "MenuType"};
		tableModel.setColumnIdentifiers(colName);

		cc = new CanteenController();
		ArrayList<Menu> menuList = cc.triggerRetrieveMenu(canteenID);
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
