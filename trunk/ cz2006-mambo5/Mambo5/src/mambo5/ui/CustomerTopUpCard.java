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

public class CustomerTopUpCard extends JFrame {

	private JPanel contentPane;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerTopUpCard frame = new CustomerTopUpCard();
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
	public CustomerTopUpCard() {
		setTitle("Top-up Card");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Card Number:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(22, 35, 90, 14);
		contentPane.add(label);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(106, 32, 141, 20);
		contentPane.add(txtCardNumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(106, 63, 141, 20);
		contentPane.add(txtName);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(20, 66, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblCurrentCardValue = new JLabel("Current Card Value");
		lblCurrentCardValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurrentCardValue.setBounds(277, 35, 146, 14);
		contentPane.add(lblCurrentCardValue);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setColumns(10);
		txtCurrentValue.setBounds(336, 57, 59, 27);
		contentPane.add(txtCurrentValue);
		
		JLabel label_3 = new JLabel("SGD$");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(277, 60, 59, 20);
		contentPane.add(label_3);
		
		JLabel label_2 = new JLabel("Please insert notes");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(21, 94, 166, 27);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("Notes accepted");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(265, 96, 108, 27);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Amount inserted");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(31, 128, 108, 27);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("SGD$2.00");
		label_6.setBounds(238, 134, 70, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("SGD$5.00");
		label_7.setBounds(317, 134, 70, 20);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("SGD$50.00");
		label_8.setBounds(317, 170, 70, 20);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("SGD$10.00");
		label_9.setBounds(238, 170, 70, 20);
		contentPane.add(label_9);
		
		textField_3 = new JTextField();
		textField_3.setText("-.--");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(87, 155, 70, 35);
		contentPane.add(textField_3);
		
		JLabel label_10 = new JLabel("SGD$");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_10.setBounds(37, 156, 65, 32);
		contentPane.add(label_10);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$5.00");
		lblMinimumOfSgd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMinimumOfSgd.setBounds(49, 196, 108, 27);
		contentPane.add(lblMinimumOfSgd);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(193, 228, 105, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Back to main");
		btnCancel.setBounds(308, 228, 105, 23);
		contentPane.add(btnCancel);
		
		JLabel lblTopupCard = new JLabel("Top-up Card");
		lblTopupCard.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTopupCard.setBounds(12, 0, 108, 27);
		contentPane.add(lblTopupCard);
	}

}