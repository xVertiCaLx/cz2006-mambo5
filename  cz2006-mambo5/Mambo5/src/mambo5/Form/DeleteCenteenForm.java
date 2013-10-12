package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DeleteCenteenForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCenteenForm frame = new DeleteCenteenForm();
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
	public DeleteCenteenForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 105, 14);
		contentPane.add(availableLabel);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(125, 8, 28, 20);
		contentPane.add(availableCB);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(180, 7, 89, 23);
		contentPane.add(deleteBtn);
	}

}
