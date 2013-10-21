package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


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
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 15, 99, 14);
		add(availableLabel);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 12, 28, 20);
		add(availableCB);
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(164, 11, 89, 23);
		add(retrieveBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(164, 36, 89, 23);
		add(deleteBtn);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(119, 37, 28, 20);
		add(stallCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(10, 40, 99, 14);
		add(stallLabel);
	}

}
