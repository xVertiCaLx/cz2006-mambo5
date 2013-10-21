package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import mambo5.Controller.CanteenController;
import mambo5.Controller.StallController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Stall;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateStallForm extends JPanel {

	private JTextField nameText;
	private JComboBox<String> availableCB;
	private JTextArea descriptionText;
	private JRadioButton openRB; 
	private JComboBox<String> unitCB;
	private JButton createBtn;
	private CamsMainFrame mainFrame;
	
	private String stallUnit;
	private String stallName;
	private String stallDesc;
	private String stallStatus;
	private StallController sc;
	private int canteenID;
	
	private CanteenController cc;
	private ArrayList<Canteen> retrieveCanteenList;
	private ArrayList<Stall> retrieveStallList;
	

	/**
	 * Create the frame.
	 */
	public CreateStallForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.titleLabel.setText("Create Stall");
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 15, 99, 14);
		add(availableLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(119, 12, 76, 20);
		availableCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteen(e);
			}
		});
		add(availableCB);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(10, 40, 46, 14);
		add(unitLabel);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(10, 65, 99, 14);
		add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(119, 62, 86, 20);
		add(nameText);
		nameText.setColumns(10);
		
		JLabel stallStatus = new JLabel("Stall Status");
		stallStatus.setBounds(10, 90, 109, 14);
		add(stallStatus);
		
		openRB = new JRadioButton("Open");
		openRB.setSelected(true);
		openRB.setBounds(119, 86, 76, 23);
		add(openRB);
		
		JRadioButton closeRB = new JRadioButton("Close");
		closeRB.setBounds(207, 86, 109, 23);
		add(closeRB);
		
		ButtonGroup group = new ButtonGroup();
		group.add(openRB);
		group.add(closeRB);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(10, 115, 109, 14);
		add(descriptionLabel);
		
		descriptionText = new JTextArea();
		descriptionText.setBounds(119, 110, 305, 117);
		add(descriptionText);
		
		unitCB.setBounds(119, 37, 76, 20);
		add(unitCB);
		
		
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsStallDetail(e);
			}
		});
		createBtn.setBounds(335, 238, 89, 23);
		add(createBtn);
		

	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		createBtn = new JButton("Create");
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
			unitCB = new JComboBox<String>();
			getAvailableStallList(retrieveCanteenList.get(0).getCanteenID(), retrieveCanteenList.get(0).getMaxStall(), retrieveCanteenList.get(0).getCanteenName());

		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	
	public void submitsStallDetail(ActionEvent e) {

		stallName = nameText.getText();
		stallDesc = descriptionText.getText();
		stallStatus = "F";
		int index = availableCB.getSelectedIndex();
		stallUnit = unitCB.getSelectedItem().toString();
		if (openRB.isSelected())
			stallStatus = "T";
		if(stallName.equals("")) 
			JOptionPane.showMessageDialog(null, "Please Enter Stall Name");
		else if (stallDesc.equals(""))
			JOptionPane.showMessageDialog(null, "Please Enter Stall Description");
		else {
			sc = new StallController();
			canteenID = retrieveCanteenList.get(index).getCanteenID();
			if(sc.validateStallDetail(canteenID, stallUnit, stallName, stallDesc, stallStatus) == 0) 
				JOptionPane.showMessageDialog(null, "Stall cannot be created");
			else {
				JOptionPane.showMessageDialog(null, "Stall successfully created");
				mainFrame.remove(mainFrame.getSelectPanel());
				mainFrame.setSelectPanel(new OFSFunction(mainFrame));
				mainFrame.getContentPane().add(mainFrame.getSelectPanel());
				mainFrame.revalidate();
				mainFrame.repaint();
			}
		}
	}
	
	private void getAvailableStallList(int canteenID, int maxStall, String canteenName) {
		sc = new StallController();
		unitCB.removeAllItems();
		retrieveStallList = sc.processRetrieveStallList(canteenID);
		ArrayList<String> availableStallList = new ArrayList<String>();
		
		for(int i = 1; i<=maxStall; i++) {
			String addStall = "#"+ canteenName + "-" + i;
			availableStallList.add(addStall);
		}
		
		if(retrieveStallList.size() != maxStall) {
			for(int i = 0; i<retrieveStallList.size();i++) {
				if(retrieveStallList.get(i).getStallStatus()) {
					availableStallList.remove(retrieveStallList.get(i).getStallUnit());
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No Available Stall");
			availableStallList.removeAll(availableStallList);
			createBtn.setEnabled(false);
		}
		if(availableStallList.size() > 0) {
			createBtn.setEnabled(true);
			for(int i = 0; i<availableStallList.size(); i++) {
				unitCB.addItem(availableStallList.get(i));
			}    	
		}
	}
	
	private void submitsCanteen(ActionEvent e) {
		int index = availableCB.getSelectedIndex();
    	getAvailableStallList(retrieveCanteenList.get(index).getCanteenID(), retrieveCanteenList.get(index).getMaxStall(), retrieveCanteenList.get(index).getCanteenName());
	}
}
