package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CustomerRefundCard extends JFrame {

	private JPanel contentPane;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRefundCard frame = new CustomerRefundCard();
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
	public CustomerRefundCard() {
		setTitle("Refund Card");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Card Number:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(20, 23, 90, 14);
		contentPane.add(label);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(110, 20, 141, 20);
		contentPane.add(txtCardNumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(110, 48, 141, 20);
		contentPane.add(txtName);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(20, 51, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Current Card Value");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(278, 23, 146, 14);
		contentPane.add(label_2);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setColumns(10);
		txtCurrentValue.setBounds(324, 42, 59, 27);
		contentPane.add(txtCurrentValue);
		
		JLabel label_3 = new JLabel("SGD$");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(273, 45, 59, 20);
		contentPane.add(label_3);
		
		JButton btnConfirmRefund = new JButton("Confirm refund");
		btnConfirmRefund.setBounds(166, 228, 112, 23);
		contentPane.add(btnConfirmRefund);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.setBounds(288, 228, 112, 23);
		contentPane.add(btnBackToMain);
		
		JLabel lblPleaseRememberTo = new JLabel("Please remember to collect your refund");
		lblPleaseRememberTo.setForeground(Color.RED);
		lblPleaseRememberTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseRememberTo.setBounds(59, 135, 312, 14);
		contentPane.add(lblPleaseRememberTo);
	}

}
