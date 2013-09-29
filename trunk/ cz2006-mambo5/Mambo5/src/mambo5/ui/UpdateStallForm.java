package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class UpdateStallForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStallForm frame = new UpdateStallForm();
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
	public UpdateStallForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 12, 99, 14);
		contentPane.add(availableLabel);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 9, 28, 20);
		contentPane.add(availableCB);
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(164, 8, 89, 23);
		contentPane.add(retrieveBtn);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(10, 37, 99, 14);
		contentPane.add(stallLabel);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(119, 34, 28, 20);
		contentPane.add(stallCB);
		
		JButton stallBtn = new JButton("Retrieve");
		stallBtn.setBounds(164, 33, 89, 23);
		contentPane.add(stallBtn);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(10, 64, 46, 14);
		contentPane.add(unitLabel);
		
		JComboBox unitCB = new JComboBox();
		unitCB.setBounds(119, 61, 28, 20);
		contentPane.add(unitCB);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(119, 86, 86, 20);
		contentPane.add(nameText);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(10, 89, 99, 14);
		contentPane.add(nameLabel);
		
		JLabel statusLabel = new JLabel("Stall Status");
		statusLabel.setBounds(10, 114, 109, 14);
		contentPane.add(statusLabel);
		
		JRadioButton openRD = new JRadioButton("Open");
		openRD.setSelected(true);
		openRD.setBounds(119, 110, 51, 23);
		contentPane.add(openRD);
		
		JRadioButton closeRD = new JRadioButton("Close");
		closeRD.setBounds(172, 110, 109, 23);
		contentPane.add(closeRD);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(119, 134, 305, 99);
		contentPane.add(descriptionText);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(10, 139, 109, 14);
		contentPane.add(descriptionLabel);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(335, 239, 89, 23);
		contentPane.add(updateBtn);
	}
}
