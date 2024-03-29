package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import mambo5.Controller.CanteenController;
import mambo5.Controller.JInterfaceController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Menu;

public class AnalyzeCanteenForm extends JPanel implements JInterfaceController {

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
		scrollPane.setBounds(147, 201, 424, 286);
		add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(FOREGROUND_COLOUR);
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnBack.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
		});
		btnBack.setBounds(482, 498, 89, 23);
		add(btnBack);
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
		DefaultTableModel tableModel = (DefaultTableModel) menuTable.getModel();
		tableModel.setRowCount(0);
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
