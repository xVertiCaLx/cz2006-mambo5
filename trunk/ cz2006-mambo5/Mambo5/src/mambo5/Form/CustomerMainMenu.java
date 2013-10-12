package mambo5.Form;

import java.awt.BorderLayout;
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

public class CustomerMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMainMenu frame = new CustomerMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerMainMenu() {
		setTitle(" Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPurchaseCard = new JButton("Purchase Card");
		btnPurchaseCard.setBounds(35, 114, 163, 40);
		contentPane.add(btnPurchaseCard);
		
		JButton btnCheckHistory = new JButton("Check History");
		btnCheckHistory.setBounds(35, 185, 163, 40);
		contentPane.add(btnCheckHistory);
		
		JButton btnTopUpCard = new JButton("Top-up Card");
		btnTopUpCard.setBounds(242, 114, 163, 40);
		contentPane.add(btnTopUpCard);
		
		JButton btnRefundCard = new JButton("Refund Card");
		btnRefundCard.setBounds(242, 185, 163, 40);
		contentPane.add(btnRefundCard);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(228, 44, -30, 21);
		contentPane.add(separator);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the CaMs Ticketing Machine");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToThe.setBounds(81, 11, 298, 40);
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblSelectAnOption = new JLabel("Select an option");
		lblSelectAnOption.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectAnOption.setBounds(163, 62, 134, 40);
		contentPane.add(lblSelectAnOption);
	}
}
