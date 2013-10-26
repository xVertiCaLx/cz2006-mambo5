package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


import java.awt.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;
import mambo5.Controller.StallController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Stall;

public class DeleteStallForm extends JPanel {
	private CamsMainFrame mainFrame;
	private JFrame frame;
	
	private CanteenController cc;
	private StallController sc;
	
	private ArrayList<Canteen> retrieveCanteenList;
	private ArrayList<Stall> retrieveStallList;
	
	private JComboBox<String> availableCB;
	private JComboBox<String> stallCB;
	private JButton deleteBtn = new JButton("Delete");
	

	public DeleteStallForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Delete Stall");
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please select Stall to delete");
		canteenTitle.setBounds(10, 0, 279, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 160, 118, 14);
		add(availableLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(275, 158, 296, 20);
		availableCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteen(e);
			}
		});
		add(availableCB);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsDeleteStall(e);
			}
		});
		
		deleteBtn.setBounds(482, 213, 89, 23);
		add(deleteBtn);
		
		stallCB.setBounds(275, 182, 296, 20);
		add(stallCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(147, 185, 99, 14);
		add(stallLabel);
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
			deleteBtn.setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "No Stall Available");
			deleteBtn.setEnabled(false);
		}
    	
	}
	
	private void submitsCanteen(ActionEvent e) {
		int index = availableCB.getSelectedIndex();
    	getStallList(retrieveCanteenList.get(index).getCanteenID());
	}
	
	public void submitsDeleteStall(ActionEvent e) {
		int resp = JOptionPane.showConfirmDialog(frame, "Do you want to Delete Canteen? ", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			int index = stallCB.getSelectedIndex();
			if(sc.processDeleteStall(retrieveStallList.get(index).getStallId()) == 1) {
				JOptionPane.showMessageDialog(null, "Stall successfully deleted");
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
			else {
				JOptionPane.showMessageDialog(null, "Error when deleting from database");
			}
				
		}
		
	}

}
