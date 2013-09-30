package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CustomerViewHistory extends JFrame {

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
					CustomerViewHistory frame = new CustomerViewHistory();
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
	public CustomerViewHistory() {
		setTitle("View History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listHistory = new JList();
		listHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listHistory.setEnabled(false);
		listHistory.setBounds(22, 112, 369, 103);
		contentPane.add(listHistory);
		
		JLabel lblHistory = new JLabel("Purchase History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHistory.setBounds(22, 86, 90, 28);
		contentPane.add(lblHistory);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(22, 64, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardNumber.setBounds(22, 36, 90, 14);
		contentPane.add(lblCardNumber);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setBounds(106, 33, 141, 20);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(106, 61, 141, 20);
		contentPane.add(txtName);
		
		JLabel lblCardValue = new JLabel("Current Card Value");
		lblCardValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardValue.setBounds(283, 36, 119, 14);
		contentPane.add(lblCardValue);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setBounds(332, 54, 59, 28);
		contentPane.add(txtCurrentValue);
		txtCurrentValue.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSgd.setBounds(276, 58, 59, 20);
		contentPane.add(lblSgd);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackToMain.setBounds(279, 223, 112, 28);
		contentPane.add(btnBackToMain);
		
		JLabel lblViewHistor = new JLabel("View History");
		lblViewHistor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblViewHistor.setBounds(4, 0, 108, 27);
		contentPane.add(lblViewHistor);
	}
}
