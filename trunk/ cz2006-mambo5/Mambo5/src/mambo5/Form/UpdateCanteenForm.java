package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Canteen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCanteenForm extends JPanel {

	private JTextField nameText;
	private JTextField addressText;
	private JTextField maxStallText;
	private CanteenController cc;
	private JComboBox<String> availableCB;
	private ArrayList<Canteen> retrieveCanteenList;
	private JTextArea descriptionText;
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	private int canteenID;
	private int maxStall;
	private CamsMainFrame mainFrame;

	/**
	 * Create the frame.
	 */
	public UpdateCanteenForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("Update Canteen");
		
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
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(147, 158, 112, 14);
		add(availableLabel);
		
		JLabel nameLabel = new JLabel("Canteen Name:");
		nameLabel.setBounds(147, 183, 112, 14);
		add(nameLabel);
		
		JLabel addressLabel = new JLabel("Canteen Address:");
		addressLabel.setBounds(147, 233, 112, 14);
		add(addressLabel);
		
		JLabel descriptionLabel = new JLabel("Canteen Description:");
		descriptionLabel.setBounds(147, 258, 125, 14);
		add(descriptionLabel);
		
		nameText = new JTextField();
		nameText.setBounds(280, 180, 291, 20);
		add(nameText);
		nameText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(280, 230, 291, 20);
		add(addressText);
		addressText.setColumns(10);
		
		descriptionText = new JTextArea();
		descriptionText.setLineWrap(true);
		descriptionText.setBounds(282, 263, 289, 137);
		add(descriptionText);
		
		JLabel maxStallLabel = new JLabel("Max Stall:");
		maxStallLabel.setBounds(147, 208, 86, 14);
		add(maxStallLabel);
		
		maxStallText = new JTextField();
		maxStallText.setBounds(280, 205, 86, 20);
		add(maxStallText);
		maxStallText.setColumns(10);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsCanteenDetails(e);
			}
			
		});
		
		updateBtn.setBounds(482, 411, 89, 23);
		add(updateBtn);
		
		availableCB = getCanteenList();
		availableCB.setBounds(280, 155, 291, 20);
		availableCB.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
            	int index = availableCB.getSelectedIndex();

            	nameText.setText(retrieveCanteenList.get(index).getCanteenName());
            	addressText.setText(retrieveCanteenList.get(index).getCanteenAddress());
            	descriptionText.setText(retrieveCanteenList.get(index).getCanteenDesc());
            	canteenID = retrieveCanteenList.get(index).getCanteenID();
            	maxStallText.setText(Integer.toString(retrieveCanteenList.get(index).getMaxStall()));
            }
        });

		add(availableCB);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
			
	    	nameText.setText(retrieveCanteenList.get(0).getCanteenName());
	    	addressText.setText(retrieveCanteenList.get(0).getCanteenAddress());
	    	descriptionText.setText(retrieveCanteenList.get(0).getCanteenDesc());
	    	canteenID = retrieveCanteenList.get(0).getCanteenID();
        	maxStallText.setText(Integer.toString(retrieveCanteenList.get(0).getMaxStall()));
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
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
				if(cc.validateCanteenDetail(canteenID, canteenName, canteenDesc, canteenAddress, maxStall) == 0)
					JOptionPane.showMessageDialog(null, "Error when updating to database");
				else {
					JOptionPane.showMessageDialog(null, "Canteen successfully updated");
					mainFrame.setTitle("Please select a Function to perform:");
					mainFrame.replacePanel(new OFSFunction(mainFrame));
				}
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Please Enter Only Integer Value for Max Stalls");
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Please Enter Max Stalls");
	
	}
}
