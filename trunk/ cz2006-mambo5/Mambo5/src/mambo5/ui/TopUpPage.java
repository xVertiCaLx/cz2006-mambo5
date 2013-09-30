package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;

public class TopUpPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopUpPage frame = new TopUpPage();
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
	public TopUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnPleaseKindlyInsert = new JTextPane();
		txtpnPleaseKindlyInsert.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		txtpnPleaseKindlyInsert.setEnabled(false);
		txtpnPleaseKindlyInsert.setText("Please Kindly Insert Cash to Top-Up Card");
		txtpnPleaseKindlyInsert.setBounds(98, 51, 285, 58);
		contentPane.add(txtpnPleaseKindlyInsert);
		
		JTextPane txtpnValueAdded = new JTextPane();
		txtpnValueAdded.setEnabled(false);
		txtpnValueAdded.setText("Value Added: $");
		txtpnValueAdded.setBounds(169, 121, 139, 20);
		contentPane.add(txtpnValueAdded);
	}

}
