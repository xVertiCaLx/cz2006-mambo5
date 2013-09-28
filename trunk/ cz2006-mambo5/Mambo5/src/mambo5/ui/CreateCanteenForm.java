package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CreateCanteenForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField addressText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCanteenForm frame = new CreateCanteenForm();
					frame.setVisible(true);
					//frame.setTitle("HELLO");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateCanteenForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Canteen Name:");
		nameLabel.setBounds(10, 11, 87, 14);
		contentPane.add(nameLabel);
		
		JLabel addressLabel = new JLabel("Canteen Address:");
		addressLabel.setBounds(10, 36, 87, 14);
		contentPane.add(addressLabel);
		
		JLabel descriptionLabel = new JLabel("Canteen Description:");
		descriptionLabel.setBounds(10, 61, 103, 14);
		contentPane.add(descriptionLabel);
		
		nameText = new JTextField();
		nameText.setBounds(119, 8, 86, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(119, 33, 86, 20);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(119, 61, 288, 148);
		contentPane.add(descriptionText);
	}
}
