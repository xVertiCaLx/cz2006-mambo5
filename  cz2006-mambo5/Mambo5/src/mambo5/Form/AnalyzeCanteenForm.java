package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AnalyzeCanteenForm extends JFrame {

	private JPanel contentPane;
	private JTable menuTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyzeCanteenForm frame = new AnalyzeCanteenForm();
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
	public AnalyzeCanteenForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 99, 14);
		contentPane.add(availableLabel);
		
		menuTable = new JTable();
		menuTable.setBounds(10, 52, 414, 163);
		contentPane.add(menuTable);
		
		JComboBox availableCB = new JComboBox();
		availableCB.setBounds(119, 8, 28, 20);
		contentPane.add(availableCB);
		
		JButton analyzeBtn = new JButton("Analyze");
		analyzeBtn.setBounds(164, 7, 89, 23);
		contentPane.add(analyzeBtn);
	}
}
