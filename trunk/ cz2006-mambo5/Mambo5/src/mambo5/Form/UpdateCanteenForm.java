package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Canteen;

public class UpdateCanteenForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField addressText;
	private CanteenController cc;
	private JComboBox<String> availableCB;
	private ArrayList<Canteen> retrieveCanteenList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCanteenForm frame = new UpdateCanteenForm();
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
	public UpdateCanteenForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 91, 14);
		contentPane.add(availableLabel);
		
		JLabel nameLabel = new JLabel("Canteen Name:");
		nameLabel.setBounds(10, 36, 91, 14);
		contentPane.add(nameLabel);
		
		JLabel addressLabel = new JLabel("Canteen Address:");
		addressLabel.setBounds(10, 62, 91, 14);
		contentPane.add(addressLabel);
		
		JLabel descriptionLabel = new JLabel("Canteen Description:");
		descriptionLabel.setBounds(10, 87, 104, 14);
		contentPane.add(descriptionLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(130, 8, 47, 20);
		contentPane.add(availableCB);
		
		nameText = new JTextField();
		nameText.setBounds(130, 33, 86, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(130, 59, 86, 20);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(130, 82, 288, 137);
		contentPane.add(descriptionText);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(329, 230, 89, 23);
		contentPane.add(updateBtn);
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(217, 7, 89, 23);
		contentPane.add(retrieveBtn);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		for(int i = 0; i<retrieveCanteenList.size();i++) {
			canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
		}
		return canteenList;
	}
}
