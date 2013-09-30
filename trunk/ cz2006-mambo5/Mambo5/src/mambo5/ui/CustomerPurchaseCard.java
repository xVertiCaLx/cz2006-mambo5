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

public class CustomerPurchaseCard extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmountInserted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPurchaseCard frame = new CustomerPurchaseCard();
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
	public CustomerPurchaseCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseCard = new JLabel("Purchase Card");
		lblPurchaseCard.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPurchaseCard.setBounds(10, 0, 108, 27);
		contentPane.add(lblPurchaseCard);
		
		JLabel lblPleaseInsertSgs = new JLabel("Please insert notes");
		lblPleaseInsertSgs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPleaseInsertSgs.setBounds(29, 57, 166, 27);
		contentPane.add(lblPleaseInsertSgs);
		
		txtAmountInserted = new JTextField();
		txtAmountInserted.setEditable(false);
		txtAmountInserted.setText("-.--");
		txtAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtAmountInserted.setBounds(87, 119, 70, 35);
		contentPane.add(txtAmountInserted);
		txtAmountInserted.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSgd.setBounds(29, 120, 65, 32);
		contentPane.add(lblSgd);
		
		JLabel lblInserted = new JLabel("Amount inserted");
		lblInserted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInserted.setBounds(39, 81, 108, 27);
		contentPane.add(lblInserted);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(315, 224, 109, 27);
		contentPane.add(btnCancel);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$10.00");
		lblMinimumOfSgd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMinimumOfSgd.setBounds(39, 155, 108, 27);
		contentPane.add(lblMinimumOfSgd);
		
		JLabel lblNotesAccepted = new JLabel("Notes accepted");
		lblNotesAccepted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNotesAccepted.setBounds(264, 59, 108, 27);
		contentPane.add(lblNotesAccepted);
		
		JLabel lblSgd_1 = new JLabel("SGD$2.00");
		lblSgd_1.setBounds(244, 97, 70, 20);
		contentPane.add(lblSgd_1);
		
		JLabel lblSgd_2 = new JLabel("SGD$5.00");
		lblSgd_2.setBounds(323, 97, 70, 20);
		contentPane.add(lblSgd_2);
		
		JLabel lblSgd_3 = new JLabel("SGD$10.00");
		lblSgd_3.setBounds(244, 130, 70, 20);
		contentPane.add(lblSgd_3);
		
		JLabel lblSgd_4 = new JLabel("SGD$50.00");
		lblSgd_4.setBounds(323, 130, 70, 20);
		contentPane.add(lblSgd_4);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(177, 224, 109, 27);
		contentPane.add(btnOk);
		
		JLabel lblMessage = new JLabel("Please collect your card.");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMessage.setBounds(32, 193, 180, 14);
		contentPane.add(lblMessage);
	}

}
