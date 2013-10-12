package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class UpdateCanteenForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField addressText;
	private CanteenController cc;
	private JComboBox<String> availableCB;
	private ArrayList<Canteen> retrieveCanteenList;
	private JTextArea descriptionText;

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
		
		nameText = new JTextField();
		nameText.setBounds(130, 33, 86, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(130, 59, 288, 20);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		descriptionText = new JTextArea();
		descriptionText.setBounds(130, 82, 288, 137);
		contentPane.add(descriptionText);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(329, 230, 89, 23);
		contentPane.add(updateBtn);
		
		JButton retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(217, 7, 89, 23);
		contentPane.add(retrieveBtn);
		
		availableCB = getCanteenList();
		availableCB.setBounds(130, 8, 47, 20);
		availableCB.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
            	int index = availableCB.getSelectedIndex();

            	nameText.setText(retrieveCanteenList.get(index).getCanteenName());
            	addressText.setText(retrieveCanteenList.get(index).getCanteenAddress());
            	descriptionText.setText(retrieveCanteenList.get(index).getCanteenDesc());
            }
        });

		contentPane.add(availableCB);

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
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
}
