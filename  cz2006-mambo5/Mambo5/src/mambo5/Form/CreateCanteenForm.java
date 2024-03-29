package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mambo5.Controller.CanteenController;
import mambo5.Controller.JInterfaceController;

public class CreateCanteenForm extends JPanel implements JInterfaceController {

	private JTextField nameText;
	private JTextField addressText;
	private JTextArea descriptionText;
	private JTextField maxStallText;
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	private int maxStall;
	private CanteenController cc;
	private CamsMainFrame mainFrame;

	/**
	 * Create the frame.
	 */
	public CreateCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Create Canteen");
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(new Color(0, 0, 102));
		titlePanel2.setBounds(147, 107, 424, 40);
		add(titlePanel2);
		titlePanel2.setLayout(null);
		
		JLabel canteenTitle = new JLabel("Please fill up all the fields");
		canteenTitle.setBounds(10, 0, 200, 50);
		titlePanel2.add(canteenTitle);
		canteenTitle.setForeground(Color.WHITE);
		canteenTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel nameLabel = new JLabel("Canteen Name:");
		nameLabel.setBounds(147, 171, 127, 14);
		add(nameLabel);
		
		JLabel addressLabel = new JLabel("Canteen Address:");
		addressLabel.setBounds(147, 196, 127, 14);
		add(addressLabel);
		
		JLabel descriptionLabel = new JLabel("Canteen Description:");
		descriptionLabel.setBounds(147, 221, 127, 14);
		add(descriptionLabel);
		
		nameText = new JTextField();
		nameText.setBounds(284, 168, 288, 20);
		add(nameText);
		nameText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(284, 193, 288, 20);
		add(addressText);
		addressText.setColumns(10);
		
		descriptionText = new JTextArea();
		descriptionText.setLineWrap(true);
		descriptionText.setBounds(284, 221, 288, 148);
		add(descriptionText);
		
		JButton createCanteenBtn = new JButton("Create");
		createCanteenBtn.setForeground(FOREGROUND_COLOUR);
		createCanteenBtn.setFocusPainted(false);
		createCanteenBtn.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		createCanteenBtn.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		createCanteenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteenDetails(e);
			}
		});
		createCanteenBtn.setBounds(483, 425, 89, 23);
		add(createCanteenBtn);
		
		maxStallText = new JTextField();
		maxStallText.setBounds(284, 380, 45, 20);
		add(maxStallText);
		maxStallText.setColumns(10);
		
		JLabel maxStallLabel = new JLabel("Max Stalls");
		maxStallLabel.setBounds(147, 383, 127, 14);
		add(maxStallLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(FOREGROUND_COLOUR);
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnBack.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setTitle("Please select a Function to perform:");
				mainFrame.replacePanel(new OFSFunction(mainFrame));
			}
		});
		btnBack.setBounds(384, 425, 89, 23);
		add(btnBack);
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
		else if (!maxStallText.getText().equals("")){
			try {
				maxStall = Integer.parseInt(maxStallText.getText());
				cc = new CanteenController();
				if(cc.validateCanteenDetail(canteenName, canteenDesc, canteenAddress, maxStall)==0)
					JOptionPane.showMessageDialog(null, "Canteen cannot be created");
				else {
					JOptionPane.showMessageDialog(null, "Canteen successfully created");
					mainFrame.setTitle("Please select a Function to perform:");
					mainFrame.replacePanel(new OFSFunction(mainFrame));
				}
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Please Enter Only Integer Value for Max Stalls");
			}
		}
		else 
			JOptionPane.showMessageDialog(null, "Please Enter Max Stalls");
	}
}
