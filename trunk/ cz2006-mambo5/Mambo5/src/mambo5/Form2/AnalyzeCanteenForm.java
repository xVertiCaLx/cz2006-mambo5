package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AnalyzeCanteenForm extends JPanel {

	private JTable menuTable;
	private CamsMainFrame mainFrame;

	/**
	 * Create the frame.
	 */
	public AnalyzeCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.titleLabel.setText("Analyze Canteen");
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 99, 14);
		add(availableLabel);
		
		menuTable = new JTable();
		menuTable.setBounds(10, 52, 414, 163);
		add(menuTable);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 8, 28, 20);
		add(availableCB);
		
		JButton analyzeBtn = new JButton("Analyze");
		analyzeBtn.setBounds(164, 7, 89, 23);
		add(analyzeBtn);
	}
}
