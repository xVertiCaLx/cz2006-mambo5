package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DeleteStallForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStallForm frame = new DeleteStallForm();
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
	public DeleteStallForm() {
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
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(164, 11, 89, 23);
		contentPane.add(retrieveBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(164, 36, 89, 23);
		contentPane.add(deleteBtn);
		
		JComboBox stallCB = new JComboBox();
		stallCB.setBounds(119, 37, 28, 20);
		contentPane.add(stallCB);
		
		JLabel stallLabel = new JLabel("Available Stall:");
		stallLabel.setBounds(10, 40, 99, 14);
		contentPane.add(stallLabel);
	}

}
