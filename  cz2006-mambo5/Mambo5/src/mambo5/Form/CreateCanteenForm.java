package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;

public class CreateCanteenForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField addressText;
	private JTextArea descriptionText;
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	private CanteenController cc;

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
		addressText.setBounds(119, 33, 288, 20);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		descriptionText = new JTextArea();
		descriptionText.setLineWrap(true);
		descriptionText.setBounds(119, 61, 288, 148);
		contentPane.add(descriptionText);
		
		JButton createCanteenBtn = new JButton("Create");
		createCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteenDetails(e);
			}
		});
		createCanteenBtn.setBounds(318, 220, 89, 23);
		contentPane.add(createCanteenBtn);
	}
	
	public void submitsCanteenDetails(ActionEvent e) {
		canteenName = nameText.getText();
		canteenAddress = addressText.getText();
		canteenDesc = descriptionText.getText();

		if(canteenName.equals("")) 
			JOptionPane.showMessageDialog(null, "Please Enter Canteen Name");
		else if(canteenAddress.equals(""))
			JOptionPane.showMessageDialog(null, "Please Enter Canteen Address");
		else if (canteenDesc.equals(""))
			JOptionPane.showMessageDialog(null, "Please Enter Canteen Description");
		else {
			cc = new CanteenController(canteenName, canteenAddress, canteenDesc);
			if(cc.validateCanteenDetail()==0)
				JOptionPane.showMessageDialog(null, "Error when insertion to database");
			else
				JOptionPane.showMessageDialog(null, "Canteen successfully created");
		}
	}
}