package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class CreateCanteenForm extends JPanel {

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
					mainFrame.remove(mainFrame.getSelectPanel());
					mainFrame.setSelectPanel(new OFSFunction(mainFrame));
					mainFrame.add(mainFrame.getSelectPanel());
					mainFrame.revalidate();
					mainFrame.repaint();
				}
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Please Enter Only Integer Value for Max Stalls");
			}
		}
		else 
			JOptionPane.showMessageDialog(null, "Please Enter Max Stalls");
	}
}
