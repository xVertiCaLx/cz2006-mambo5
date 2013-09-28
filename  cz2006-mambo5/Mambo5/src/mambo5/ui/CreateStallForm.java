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

public class CreateStallForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateStallForm frame = new CreateStallForm();
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
	public CreateStallForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 15, 99, 14);
		contentPane.add(availableLabel);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 12, 28, 20);
		contentPane.add(availableCB);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(10, 40, 46, 14);
		contentPane.add(unitLabel);
		
		JComboBox unitCB = new JComboBox();
		unitCB.setBounds(119, 37, 28, 20);
		contentPane.add(unitCB);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(10, 65, 99, 14);
		contentPane.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(119, 62, 86, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel stallStatus = new JLabel("Stall Status");
		stallStatus.setBounds(10, 90, 109, 14);
		contentPane.add(stallStatus);
		
		JRadioButton openRB = new JRadioButton("Open");
		openRB.setSelected(true);
		openRB.setBounds(119, 86, 51, 23);
		contentPane.add(openRB);
		
		JRadioButton closeRB = new JRadioButton("Close");
		closeRB.setBounds(172, 86, 109, 23);
		contentPane.add(closeRB);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(10, 115, 109, 14);
		contentPane.add(descriptionLabel);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(119, 110, 305, 117);
		contentPane.add(descriptionText);
		
		JButton createBtn = new JButton("Create");
		createBtn.setBounds(335, 238, 89, 23);
		contentPane.add(createBtn);
	}
}
