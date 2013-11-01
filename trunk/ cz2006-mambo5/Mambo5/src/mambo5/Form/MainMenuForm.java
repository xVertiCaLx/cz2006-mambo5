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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuForm extends JPanel {

	public MainMenuForm(final CamsMainFrame mainFrame) {
		mainFrame.setTitle("CaMS Ticketing Machine");
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JButton btnPurchaseCard = new JButton("Purchase Card");
		btnPurchaseCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new PurchaseCardForm(mainFrame));
			}
		});
		btnPurchaseCard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPurchaseCard.setBounds(185, 171, 154, 40);
		add(btnPurchaseCard);
		
		JButton btnCheckHistory = new JButton("Check History");
		btnCheckHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new ViewHistoryForm(mainFrame));
			}
		});
		btnCheckHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCheckHistory.setBounds(185, 282, 154, 40);
		add(btnCheckHistory);
		
		JButton btnTopUpCard = new JButton("Top-up Card");
		btnTopUpCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new AddValueForm(mainFrame));
			}
		});
		btnTopUpCard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTopUpCard.setBounds(475, 171, 154, 40);
		add(btnTopUpCard);
		
		JButton btnRefundCard = new JButton("Refund Card");
		btnRefundCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new RefundCardForm(mainFrame));
			}
		});
		btnRefundCard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRefundCard.setBounds(475, 282, 154, 40);
		add(btnRefundCard);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(228, 44, -30, 21);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(95, 76, 613, 60);
		add(panel);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the CaMs Ticketing Machine");
		lblWelcomeToThe.setForeground(Color.WHITE);
		lblWelcomeToThe.setBounds(175, 0, 296, 32);
		panel.add(lblWelcomeToThe);
		lblWelcomeToThe.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblSelectAnOption = new JLabel("Select an option");
		lblSelectAnOption.setForeground(Color.WHITE);
		lblSelectAnOption.setBounds(266, 28, 134, 32);
		panel.add(lblSelectAnOption);
		lblSelectAnOption.setFont(new Font("Arial", Font.PLAIN, 15));
	}
}
