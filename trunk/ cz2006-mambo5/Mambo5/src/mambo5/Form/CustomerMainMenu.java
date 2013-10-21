package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.Font;

public class CustomerMainMenu extends JPanel {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the frame.
	 */
	public CustomerMainMenu() {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JButton btnPurchaseCard = new JButton("Purchase Card");
		btnPurchaseCard.setFont(new Font("Arial", Font.BOLD, 16));
		btnPurchaseCard.setBounds(120, 151, 234, 80);
		add(btnPurchaseCard);
		
		JButton btnCheckHistory = new JButton("Check History");
		btnCheckHistory.setFont(new Font("Arial", Font.BOLD, 16));
		btnCheckHistory.setBounds(120, 301, 234, 80);
		add(btnCheckHistory);
		
		JButton btnTopUpCard = new JButton("Top-up Card");
		btnTopUpCard.setFont(new Font("Arial", Font.BOLD, 16));
		btnTopUpCard.setBounds(474, 151, 234, 80);
		add(btnTopUpCard);
		
		JButton btnRefundCard = new JButton("Refund Card");
		btnRefundCard.setFont(new Font("Arial", Font.BOLD, 16));
		btnRefundCard.setBounds(474, 301, 234, 80);
		add(btnRefundCard);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(228, 44, -30, 21);
		add(separator);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the CaMs Ticketing Machine");
		lblWelcomeToThe.setFont(new Font("Arial", Font.BOLD, 18));
		lblWelcomeToThe.setBounds(225, 11, 385, 40);
		add(lblWelcomeToThe);
		
		JLabel lblSelectAnOption = new JLabel("Select an option");
		lblSelectAnOption.setFont(new Font("Arial", Font.BOLD, 17));
		lblSelectAnOption.setBounds(346, 44, 134, 40);
		add(lblSelectAnOption);
	}
}
