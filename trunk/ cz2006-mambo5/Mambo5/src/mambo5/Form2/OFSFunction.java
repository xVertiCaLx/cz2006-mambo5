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
		
		JButton btnNewButton_2 = new JButton("Update Canteen");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(400, 151, 170, 80);
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete Canteen");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(590, 151, 170, 80);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(20, 282, 89, 23);
		add(btnNewButton_1);

	}
}
