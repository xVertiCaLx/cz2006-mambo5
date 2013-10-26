package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class UpdateStallForm extends JPanel {

	private JTextField nameText = new JTextField();
	private CamsMainFrame mainFrame;
	private JTextArea descArea = new JTextArea();
	
	private CanteenController cc;
	private ArrayList<Canteen> retrieveCanteenList;
	private JComboBox<String> availableCB;
	
	private StallController sc;
	private ArrayList<Stall> retrieveStallList;
	private JComboBox<String> stallCB;
	private JRadioButton openRB = new JRadioButton("Open");
	private JRadioButton closeRB = new JRadioButton("Close");
	private JButton updateBtn = new JButton("Update");
	
	private String stallName;
	private String stallDesc;
	private String stallStatus;
	private int stallID;
	
	/**
	 * Create the frame.
	 */
	public UpdateStallForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Update Stall");
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please fill up all the fields");
		canteenTitle.setBounds(10, 0, 279, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 158, 109, 14);
		add(availableLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(266, 155, 305, 20);
		availableCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteen(e);
			}
		});

		add(availableCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(147, 183, 99, 14);
		add(stallLabel);
		
		stallCB.setBounds(266, 180, 305, 20);
		stallCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsStall(e);
			}
		});
		add(stallCB);
		
		nameText.setColumns(10);
		nameText.setBounds(266, 205, 305, 20);
		add(nameText);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(147, 208, 99, 14);
		add(nameLabel);
		
		JLabel statusLabel = new JLabel("Stall Status");
		statusLabel.setBounds(147, 233, 109, 14);
		add(statusLabel);
		
		openRB.setSelected(true);
		openRB.setBounds(266, 229, 70, 23);
		add(openRB);
		
		closeRB.setBounds(338, 229, 109, 23);
		add(closeRB);
		
		ButtonGroup group = new ButtonGroup();
		group.add(openRB);
		group.add(closeRB);
		
		
		descArea = new JTextArea();
		descArea.setLineWrap(true);
		descArea.setBounds(266, 259, 305, 99);
		add(descArea);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(147, 260, 109, 14);
		add(descriptionLabel);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsStallDetail(e);
			}
		});
		
		
		updateBtn.setBounds(482, 369, 89, 23);
		add(updateBtn);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
			stallCB = new JComboBox<String>();
			getStallList(retrieveCanteenList.get(0).getCanteenID());
			displayStallDetail(0);
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	
	private void getStallList(int canteenID) {
		sc = new StallController();
		stallCB.removeAllItems();
		retrieveStallList = sc.processRetrieveStallList(canteenID);
		
		if(retrieveStallList.size() != 0) {
			for(int i = 0; i<retrieveStallList.size();i++) 
				stallCB.addItem(retrieveStallList.get(i).getStallUnit());
			updateBtn.setEnabled(true);
			nameText.setEnabled(true);
			descArea.setEnabled(true);
			openRB.setEnabled(true);
			closeRB.setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "No Stall Available");
			updateBtn.setEnabled(false);
			nameText.setEnabled(false);
			descArea.setEnabled(false);
			openRB.setEnabled(false);
			closeRB.setEnabled(false);
		}
	}
	
	private void displayStallDetail(int index) {
		nameText.setText(retrieveStallList.get(index).getStallName());
		
		descArea.setText(retrieveStallList.get(index).getStallDesc());
		if(retrieveStallList.get(index).getStallStatus() == true) { 
			openRB.setSelected(true);
			closeRB.setSelected(false);
		}
		else {
			closeRB.setSelected(true);
			openRB.setSelected(false);
		}
	}
	
	private void submitsCanteen(ActionEvent e) {
		int index = availableCB.getSelectedIndex();
    	getStallList(retrieveCanteenList.get(index).getCanteenID());
	}
	
	private void submitsStall(ActionEvent e) {
		int index = stallCB.getSelectedIndex();
		if(index >= 0)
			displayStallDetail(index);
		else {
			nameText.setText("");
			closeRB.setSelected(false);
			openRB.setSelected(false);
			descArea.setText("");
		}
	}
	public void submitsStallDetail(ActionEvent e) {

		stallName = nameText.getText();
		stallDesc = descArea.getText();
		stallStatus = "F";
		int index = stallCB.getSelectedIndex();
		if (openRB.isSelected())
			stallStatus = "T";
		if(stallName.equals("")) 
			JOptionPane.showMessageDialog(null, "Please Enter Stall Name");
		else if (stallDesc.equals(""))
			JOptionPane.showMessageDialog(null, "Please Enter Stall Description");
		else {
			sc = new StallController();
			stallID = retrieveStallList.get(index).getStallId();
			if(sc.validateStallDetail(stallID, stallName, stallDesc, stallStatus) == 0) 
				JOptionPane.showMessageDialog(null, "Stall cannot be updated");
			else {
				JOptionPane.showMessageDialog(null, "Stall successfully updated");
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
		}
	}
}
