package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import mambo5.Controller.CanteenController;
import mambo5.Controller.StallController;
import mambo5.Entity.Canteen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateStallForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField levelText;
	private JTextField unitText;
	private JComboBox<String> availableCB;
	private JTextArea descriptionText;
	private JRadioButton openRB; 
	
	
	private String stallUnit;
	private String level;
	private String unit;
	private String stallName;
	private String stallDesc;
	private String stallStatus;
	private StallController sc;
	private int canteenID;
	
	private CanteenController cc;
	private ArrayList<Canteen> retrieveCanteenList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateStallForm frame = new CreateStallForm();
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
	public CreateStallForm() {
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
		
		availableCB = getCanteenList();
		availableCB.setBounds(119, 12, 76, 20);
		contentPane.add(availableCB);
		
		JLabel unitLabel = new JLabel("Stall Unit:");
		unitLabel.setBounds(10, 40, 46, 14);
		contentPane.add(unitLabel);
		
		JLabel nameLabel = new JLabel("Stall Name");
		nameLabel.setBounds(10, 65, 99, 14);
		contentPane.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(119, 62, 86, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel stallStatus = new JLabel("Stall Status");
		stallStatus.setBounds(10, 90, 109, 14);
		contentPane.add(stallStatus);
		
		openRB = new JRadioButton("Open");
		openRB.setSelected(true);
		openRB.setBounds(119, 86, 76, 23);
		contentPane.add(openRB);
		
		JRadioButton closeRB = new JRadioButton("Close");
		closeRB.setBounds(207, 86, 109, 23);
		contentPane.add(closeRB);
		
		ButtonGroup group = new ButtonGroup();
		group.add(openRB);
		group.add(closeRB);
		
		JLabel descriptionLabel = new JLabel("Stall Description:");
		descriptionLabel.setBounds(10, 115, 109, 14);
		contentPane.add(descriptionLabel);
		
		descriptionText = new JTextArea();
		descriptionText.setBounds(119, 110, 305, 117);
		contentPane.add(descriptionText);
		
		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsStallDetail(e);
			}
		});
		createBtn.setBounds(335, 238, 89, 23);
		contentPane.add(createBtn);
		
		JLabel hexLabel = new JLabel("#");
		hexLabel.setBounds(119, 43, 13, 14);
		contentPane.add(hexLabel);
		
		levelText = new JTextField();
		levelText.setBounds(129, 37, 19, 20);
		contentPane.add(levelText);
		levelText.setColumns(10);
		
		JLabel dashLabel = new JLabel("-");
		dashLabel.setBounds(157, 40, 13, 14);
		contentPane.add(dashLabel);
		
		unitText = new JTextField();
		unitText.setBounds(167, 37, 28, 20);
		contentPane.add(unitText);
		unitText.setColumns(10);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());

		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	
	public void submitsStallDetail(ActionEvent e) {
		level = levelText.getText();
		unit = unitText.getText();
		stallName = nameText.getText();
		stallDesc = descriptionText.getText();
		stallStatus = "F";
		int index = availableCB.getSelectedIndex();
		
		if(level.equals("") || unit.equals("")) 
			JOptionPane.showMessageDialog(null, "Please Enter Stall Unit");
		else {
			try{
				Integer.parseInt(level);
				Integer.parseInt(unit);
				stallUnit = "#" + level + "-" + unit;
				if (openRB.isSelected())
					stallStatus = "T";
				if(stallName.equals("")) 
					JOptionPane.showMessageDialog(null, "Please Enter Stall Name");
				else if (stallDesc.equals(""))
					JOptionPane.showMessageDialog(null, "Please Enter Stall Description");
				else {
					sc = new StallController();
					canteenID = retrieveCanteenList.get(index).getCanteenID();
					if(sc.validateStallDetail(canteenID, stallUnit, stallName, stallDesc, stallStatus) == 0) 
						JOptionPane.showMessageDialog(null, "Stall cannot be created");
					else
						JOptionPane.showMessageDialog(null, "Stall successfully created");
				}
				
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Please Enter Only Integer Value for Stall Unit");
			}
		}
		

	}
}
