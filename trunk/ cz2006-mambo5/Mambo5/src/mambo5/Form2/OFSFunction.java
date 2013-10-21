package mambo5.Form2;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OFSFunction extends JPanel {

	/**
	 * Create the panel.
	 */
	public OFSFunction() {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setBounds(20, 200, 739, 40);
		add(titlePanel);
		titlePanel.setLayout(null);
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(20, 29, 739, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Manage Canteen");
		canteenTitle.setBounds(10, 0, 134, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel stallTitle = new JLabel("Manage Stall");
		stallTitle.setForeground(Color.WHITE);
		stallTitle.setFont(new Font("Arial", Font.BOLD, 16));
		stallTitle.setBounds(10, 0, 134, 50);
		titlePanel.add(stallTitle);
		
		JButton createCanteenBtn = new JButton("Create Canteen");
		createCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		createCanteenBtn.setBounds(20, 80, 170, 80);
		add(createCanteenBtn);
		
		JButton analyzeCanteenBtn = new JButton("Analyze Canteen");
		analyzeCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		analyzeCanteenBtn.setBounds(210, 80, 170, 80);
		add(analyzeCanteenBtn);
		
		JButton updateCanteenBtn = new JButton("Update Canteen");
		updateCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		updateCanteenBtn.setBounds(400, 80, 170, 80);
		add(updateCanteenBtn);
		
		JButton deleteCanteenBtn = new JButton("Delete Canteen");
		deleteCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteCanteenBtn.setBounds(589, 80, 170, 80);
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
		deleteStallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new DeleteStallForm());
				revalidate();
				repaint();
			}
		});
		deleteStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteStallBtn.setBounds(590, 251, 170, 80);
		add(deleteStallBtn);

	}
}
