package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;

public class MainMenuForm extends JPanel implements JInterfaceController {

	public MainMenuForm(final CamsMainFrame mainFrame) {
		mainFrame.setTitle("CaMS Ticketing Machine");
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JButton btnPurchaseCard = new JButton("Purchase Card");
		btnPurchaseCard.setForeground(FOREGROUND_COLOUR);
		btnPurchaseCard.setFocusPainted(false);
		btnPurchaseCard.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnPurchaseCard.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnPurchaseCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new PurchaseCardForm(mainFrame));
			}
		});
		btnPurchaseCard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPurchaseCard.setBounds(185, 171, 154, 40);
		add(btnPurchaseCard);
		
		JButton btnCheckHistory = new JButton("Check History");
		btnCheckHistory.setForeground(FOREGROUND_COLOUR);
		btnCheckHistory.setFocusPainted(false);
		btnCheckHistory.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnCheckHistory.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnCheckHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new ViewHistoryForm(mainFrame));
			}
		});
		btnCheckHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCheckHistory.setBounds(185, 282, 154, 40);
		add(btnCheckHistory);
		
		JButton btnTopUpCard = new JButton("Top-up Card");
		btnTopUpCard.setForeground(FOREGROUND_COLOUR);
		btnTopUpCard.setFocusPainted(false);
		btnTopUpCard.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnTopUpCard.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnTopUpCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new AddValueForm(mainFrame));
			}
		});
		btnTopUpCard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTopUpCard.setBounds(475, 171, 154, 40);
		add(btnTopUpCard);
		
		JButton btnRefundCard = new JButton("Refund Card");
		btnRefundCard.setForeground(FOREGROUND_COLOUR);
		btnRefundCard.setFocusPainted(false);
		btnRefundCard.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnRefundCard.setBackground(TITLEBAR_BACKGROUND_COLOUR);
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
		panel.setBackground(JPANEL_BACKGROUND_COLOUR);
		panel.setBounds(95, 76, 613, 60);
		add(panel);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the CaMS Ticketing Machine");
		lblWelcomeToThe.setForeground(FOREGROUND_COLOUR);
		lblWelcomeToThe.setBounds(175, 0, 400, 32);
		panel.add(lblWelcomeToThe);
		lblWelcomeToThe.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblSelectAnOption = new JLabel("Select an option to begin.");
		lblSelectAnOption.setForeground(FOREGROUND_COLOUR);
		lblSelectAnOption.setBounds(266, 28, 300, 32);
		panel.add(lblSelectAnOption);
		lblSelectAnOption.setFont(new Font("Arial", Font.BOLD, 15));
	}
}
