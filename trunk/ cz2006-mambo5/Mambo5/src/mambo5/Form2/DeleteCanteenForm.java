package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Canteen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DeleteCanteenForm extends JPanel {

	private CanteenController cc;
	private JComboBox<String> availableCB;
	private ArrayList<Canteen> retrieveCanteenList;
	private JFrame frame;
	private CamsMainFrame mainFrame;
	/**
	 * Create the frame.
	 */
	public DeleteCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Delete Canteen");
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please select the Canteen to delete");
		canteenTitle.setBounds(10, 0, 292, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 158, 105, 14);
		add(availableLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(283, 155, 288, 20);
		add(availableCB);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsDeleteCanteen(e);
			}
		});
		deleteBtn.setBounds(482, 192, 89, 23);
		add(deleteBtn);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	public void submitsDeleteCanteen(ActionEvent e) {
		int resp = JOptionPane.showConfirmDialog(frame, "Do you want to Delete Canteen? ", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			int index = availableCB.getSelectedIndex();
			if(cc.processDeleteCanteen(retrieveCanteenList.get(index).getCanteenID()) == 1) {
				JOptionPane.showMessageDialog(null, "Canteen successfully deleted");
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
			else {
				JOptionPane.showMessageDialog(null, "Error when deleting from database");
			}
				
		}
		
	}
}
