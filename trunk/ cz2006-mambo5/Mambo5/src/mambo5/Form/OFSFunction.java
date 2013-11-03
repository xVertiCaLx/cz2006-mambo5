package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;

public class OFSFunction extends JPanel implements JInterfaceController{

	/**
	 * Create the panel.
	 */
	public OFSFunction(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
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
		
		mainFrame.setTitle("Please select a Function to perform:");
		
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
		createCanteenBtn.setForeground(FOREGROUND_COLOUR);
		createCanteenBtn.setFocusPainted(false);
		createCanteenBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		createCanteenBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		createCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new CreateCanteenForm(mainFrame));
			}
		});
		createCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		createCanteenBtn.setBounds(20, 80, 170, 80);
		add(createCanteenBtn);
		
		JButton analyzeCanteenBtn = new JButton("Analyze Canteen");
		analyzeCanteenBtn.setForeground(FOREGROUND_COLOUR);
		analyzeCanteenBtn.setFocusPainted(false);
		analyzeCanteenBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		analyzeCanteenBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		analyzeCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new AnalyzeCanteenForm(mainFrame));
				
			}
		});
		analyzeCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		analyzeCanteenBtn.setBounds(210, 80, 170, 80);
		add(analyzeCanteenBtn);
		
		JButton updateCanteenBtn = new JButton("Update Canteen");
		updateCanteenBtn.setForeground(FOREGROUND_COLOUR);
		updateCanteenBtn.setFocusPainted(false);
		updateCanteenBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		updateCanteenBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		updateCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new UpdateCanteenForm(mainFrame));
			}
		});
		updateCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		updateCanteenBtn.setBounds(400, 80, 170, 80);
		add(updateCanteenBtn);
		
		JButton deleteCanteenBtn = new JButton("Delete Canteen");
		deleteCanteenBtn.setForeground(FOREGROUND_COLOUR);
		deleteCanteenBtn.setFocusPainted(false);
		deleteCanteenBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		deleteCanteenBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		deleteCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new DeleteCanteenForm(mainFrame));
			}
		});
		deleteCanteenBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteCanteenBtn.setBounds(589, 80, 170, 80);
		add(deleteCanteenBtn);
		
		JButton createStallBtn = new JButton("Create Stall");
		createStallBtn.setForeground(FOREGROUND_COLOUR);
		createStallBtn.setFocusPainted(false);
		createStallBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		createStallBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		createStallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.replacePanel(new CreateStallForm(mainFrame));
				
			}
		});
		createStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		createStallBtn.setBounds(20, 251, 170, 80);
		add(createStallBtn);
		
		JButton retrieveStallBtn = new JButton("Retrieve Stall");
		retrieveStallBtn.setForeground(FOREGROUND_COLOUR);
		retrieveStallBtn.setFocusPainted(false);
		retrieveStallBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		retrieveStallBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		retrieveStallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.replacePanel(new RetrieveStallForm(mainFrame));
				
			}
		});
		retrieveStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		retrieveStallBtn.setBounds(210, 251, 170, 80);
		add(retrieveStallBtn);
		
		JButton updateStallBtn = new JButton("Update Stall");
		updateStallBtn.setForeground(FOREGROUND_COLOUR);
		updateStallBtn.setFocusPainted(false);
		updateStallBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		updateStallBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		updateStallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new UpdateStallForm(mainFrame));
			}
		});
		updateStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		updateStallBtn.setBounds(400, 251, 170, 80);
		add(updateStallBtn);
		
		JButton deleteStallBtn = new JButton("Delete Stall");
		deleteStallBtn.setForeground(FOREGROUND_COLOUR);
		deleteStallBtn.setFocusPainted(false);
		deleteStallBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		deleteStallBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		deleteStallBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new DeleteStallForm(mainFrame));
			}
		});
		deleteStallBtn.setFont(new Font("Arial", Font.BOLD, 16));
		deleteStallBtn.setBounds(590, 251, 170, 80);
		add(deleteStallBtn);

	}
}
