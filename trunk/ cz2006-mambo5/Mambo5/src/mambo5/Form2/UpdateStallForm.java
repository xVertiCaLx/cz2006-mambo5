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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class UpdateStallForm extends JPanel {

	private JTextField nameText;
	private CamsMainFrame mainFrame;

	/**
	 * Create the frame.
	 */
	public UpdateStallForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.titleLabel.setText("Update Stall");
		
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
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(266, 155, 305, 20);
		add(availableCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(147, 183, 99, 14);
		add(stallLabel);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(266, 180, 305, 20);
		add(stallCB);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(147, 212, 46, 14);
		add(unitLabel);
		
		JComboBox unitCB = new JComboBox();
		unitCB.setBounds(266, 209, 305, 20);
		add(unitCB);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(266, 243, 305, 20);
		add(nameText);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(147, 246, 99, 14);
		add(nameLabel);
		
		JLabel statusLabel = new JLabel("Stall Status");
		statusLabel.setBounds(147, 274, 109, 14);
		add(statusLabel);
		
		JRadioButton openRD = new JRadioButton("Open");
		openRD.setSelected(true);
		openRD.setBounds(266, 270, 70, 23);
		add(openRD);
		
		JRadioButton closeRD = new JRadioButton("Close");
		closeRD.setBounds(338, 270, 109, 23);
		add(closeRD);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(266, 300, 305, 99);
		add(descriptionText);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(147, 299, 109, 14);
		add(descriptionLabel);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(482, 410, 89, 23);
		add(updateBtn);
	}
}
