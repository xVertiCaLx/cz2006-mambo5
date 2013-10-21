package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


import java.awt.Font;

//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DeleteStallForm extends JPanel {
	private CamsMainFrame mainFrame;

	public DeleteStallForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.titleLabel.setText("Delete Stall");
		
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
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(275, 158, 296, 20);
		add(availableCB);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(482, 213, 89, 23);
		add(deleteBtn);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(275, 182, 296, 20);
		add(stallCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(147, 185, 99, 14);
		add(stallLabel);
	}

}
