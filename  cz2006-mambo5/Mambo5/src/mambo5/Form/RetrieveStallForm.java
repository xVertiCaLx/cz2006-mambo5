package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class RetrieveStallForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetrieveStallForm frame = new RetrieveStallForm();
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
	public RetrieveStallForm() {
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
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(164, 11, 89, 23);
		contentPane.add(retrieveBtn);
		
		JButton stallBtn = new JButton("Retrieve");
		stallBtn.setBounds(164, 36, 89, 23);
		contentPane.add(stallBtn);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(119, 37, 28, 20);
		contentPane.add(stallCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(10, 40, 99, 14);
		contentPane.add(stallLabel);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(10, 67, 46, 14);
		contentPane.add(unitLabel);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(10, 92, 99, 14);
		contentPane.add(nameLabel);
		
		JLabel statusLabel = new JLabel("Stall Status");
		statusLabel.setBounds(10, 117, 109, 14);
		contentPane.add(statusLabel);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(10, 142, 109, 14);
		contentPane.add(descriptionLabel);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 12, 28, 20);
		contentPane.add(availableCB);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(119, 142, 305, 99);
		contentPane.add(textArea);
		
		JLabel unitText = new JLabel("text");
		unitText.setBounds(119, 68, 46, 14);
		contentPane.add(unitText);
		
		JLabel nameText = new JLabel("text");
		nameText.setBounds(119, 92, 46, 14);
		contentPane.add(nameText);
		
		JLabel statusText = new JLabel("text");
		statusText.setBounds(119, 117, 46, 14);
		contentPane.add(statusText);
	}

}
