package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import mambo5.Controller.CanteenController;
import mambo5.Controller.StallController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Stall;

public class RetrieveStallForm extends JPanel {

	private CanteenController cc;
	private StallController sc;
	private JComboBox<String> availableCB;
	private JComboBox<String> stallCB;
	private ArrayList<Canteen> retrieveCanteenList;
	private ArrayList<Stall> retrieveStallList;
	private JLabel nameText = new JLabel();
	private JLabel statusText = new JLabel();
	private JTextArea descArea = new JTextArea();
	private CamsMainFrame mainFrame;


	/**
	 * Create the frame.
	 */
	public RetrieveStallForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Retrieve Stall");
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please select Stall to retrieve");
		canteenTitle.setBounds(10, 0, 279, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 161, 123, 14);
		add(availableLabel);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(147, 196, 123, 14);
		add(stallLabel);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(147, 223, 99, 14);
		add(nameLabel);
		
		JLabel statusLabel = new JLabel("Stall Status");
		statusLabel.setBounds(147, 247, 109, 14);
		add(statusLabel);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(147, 272, 109, 14);
		add(descriptionLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(280, 158, 291, 20);
		availableCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteen(e);
			}
		});
		add(availableCB);
		
		
		descArea.setEditable(false);
		descArea.setBounds(280, 272, 291, 99);
		add(descArea);
		
		nameText.setBounds(280, 223, 291, 14);
		add(nameText);
		
		
		statusText.setBounds(280, 247, 291, 14);
		add(statusText);
		
		stallCB.setBounds(280, 193, 291, 20);
		
		stallCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsStall(e);
			}
		});
		
		add(stallCB);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
		});
		btnBack.setBounds(482, 382, 89, 23);
		add(btnBack);
	}
	
	private void submitsStall(ActionEvent e) {
		int index = stallCB.getSelectedIndex();
		if(index >= 0)
			displayStallDetail(index);
		else {
			nameText.setText("");
			statusText.setText("");
			descArea.setText("");
		}
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
		}
		else 
			JOptionPane.showMessageDialog(null, "No Stall Available");
    	
	}
	
	private void submitsCanteen(ActionEvent e) {
		int index = availableCB.getSelectedIndex();
    	getStallList(retrieveCanteenList.get(index).getCanteenID());
	}
	
	private void displayStallDetail(int index) {
		
		nameText.setText(retrieveStallList.get(index).getStallName());
		
		descArea.setText(retrieveStallList.get(index).getStallDesc());
		if(retrieveStallList.get(index).getStallStatus() == true) 
			statusText.setText("Open");
		else
			statusText.setText("Closed");
	}
}
