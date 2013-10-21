package mambo5.Form2;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class OFSFunction extends JPanel {

	/**
	 * Create the panel.
	 */
	public OFSFunction() {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		JButton createCanteenBtn = new JButton("Create Canteen");
		createCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		createCanteenBtn.setBounds(20, 151, 170, 80);
		add(createCanteenBtn);
		
		JButton analyzeCanteenBtn = new JButton("Analyze Canteen");
		analyzeCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		analyzeCanteenBtn.setBounds(210, 151, 170, 80);
		add(analyzeCanteenBtn);
		
		JButton updateCanteenBtn = new JButton("Update Canteen");
		updateCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		updateCanteenBtn.setBounds(400, 151, 170, 80);
		add(updateCanteenBtn);
		
		JButton deleteCanteenBtn = new JButton("Delete Canteen");
		deleteCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteCanteenBtn.setBounds(590, 151, 170, 80);
		add(deleteCanteenBtn);
		
		JButton createStallBtn = new JButton("Create Stall");
		createStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		createStallBtn.setBounds(20, 251, 170, 80);
		add(createStallBtn);
		
		JButton retrieveStallBtn = new JButton("Retrieve Stall");
		retrieveStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		retrieveStallBtn.setBounds(210, 251, 170, 80);
		add(retrieveStallBtn);
		
		JButton updateStallBtn = new JButton("Update Stall");
		updateStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		updateStallBtn.setBounds(400, 251, 170, 80);
		add(updateStallBtn);
		
		JButton deleteStallBtn = new JButton("Delete Stall");
		deleteStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteStallBtn.setBounds(590, 251, 170, 80);
		add(deleteStallBtn);

	}
}
