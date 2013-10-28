package mambo5.Form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mambo5.Controller.CustomerController;
import mambo5.Entity.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddValueForm extends JPanel {
	
	private Customer cust;
	private CustomerController customerCon;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;
	private JTextField txtAmountInserted;
	private double amountInserted;

	public AddValueForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setFont(new Font("Arial", Font.BOLD, 19));
		lblCustomerId.setBounds(44, 58, 141, 27);
		add(lblCustomerId);
		
		txtCardNumber = new JTextField();
		txtCardNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String custID = JOptionPane.showInputDialog("Please enter custID");
				txtCardNumber.setText(custID);
				customerCon = new CustomerController();
				cust = customerCon.retrieveCustomerInfo(Integer.parseInt(custID));
				txtName.setText(cust.getFullName());
				txtCurrentValue.setText(String.valueOf(cust.getCardBalance()));
			}
		});
		txtCardNumber.setFont(new Font("Arial", Font.BOLD, 19));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(195, 58, 195, 27);
	    add(txtCardNumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(195, 107, 195, 27);
		add(txtName);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Arial", Font.BOLD, 19));
		label_1.setBounds(44, 105, 119, 27);
		add(label_1);
		
		JLabel lblCurrentCardValue = new JLabel("Current Card Value");
		lblCurrentCardValue.setFont(new Font("Arial", Font.BOLD, 22));
		lblCurrentCardValue.setBounds(471, 51, 219, 38);
		add(lblCurrentCardValue);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setFont(new Font("Arial", Font.BOLD, 19));
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setColumns(10);
		txtCurrentValue.setBounds(540, 107, 150, 27);
		add(txtCurrentValue);
		
		JLabel label_3 = new JLabel("SGD$");
		label_3.setFont(new Font("Arial", Font.BOLD, 19));
		label_3.setBounds(471, 114, 59, 20);
		add(label_3);
		
		JLabel label_2 = new JLabel("Please insert notes");
		label_2.setFont(new Font("Arial", Font.BOLD, 22));
		label_2.setBounds(44, 199, 265, 27);
		add(label_2);
		
		JLabel label_4 = new JLabel("Notes accepted");
		label_4.setFont(new Font("Arial", Font.BOLD, 22));
		label_4.setBounds(529, 199, 178, 27);
		add(label_4);
		
		JLabel label_5 = new JLabel("Amount inserted");
		label_5.setFont(new Font("Arial", Font.BOLD, 19));
		label_5.setBounds(66, 249, 161, 27);
		add(label_5);
		
		JLabel label_6 = new JLabel("SGD$2.00");
		label_6.setFont(new Font("Arial", Font.BOLD, 19));
		label_6.setBounds(471, 249, 127, 20);
		add(label_6);
		
		JLabel label_7 = new JLabel("SGD$5.00");
		label_7.setFont(new Font("Arial", Font.BOLD, 19));
		label_7.setBounds(647, 249, 127, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("SGD$50.00");
		label_8.setFont(new Font("Arial", Font.BOLD, 19));
		label_8.setBounds(647, 314, 127, 20);
		add(label_8);
		
		JLabel label_9 = new JLabel("SGD$10.00");
		label_9.setFont(new Font("Arial", Font.BOLD, 19));
		label_9.setBounds(471, 314, 119, 20);
		add(label_9);
		
		txtAmountInserted = new JTextField();
		txtAmountInserted.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valueEntered = JOptionPane.showInputDialog("Please enter the value you wish to add in.");
				txtAmountInserted.setText(valueEntered);
			}
		});
		txtAmountInserted.setText("-.--");
		txtAmountInserted.setFont(new Font("Arial", Font.BOLD, 19));
		txtAmountInserted.setEditable(false);
		txtAmountInserted.setColumns(10);
		txtAmountInserted.setBounds(108, 317, 119, 27);
		add(txtAmountInserted);
		
		JLabel label_10 = new JLabel("SGD$");
		label_10.setFont(new Font("Arial", Font.BOLD, 19));
		label_10.setBounds(44, 315, 65, 32);
		add(label_10);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$5.00");
		lblMinimumOfSgd.setFont(new Font("Arial", Font.BOLD, 10));
		lblMinimumOfSgd.setBounds(108, 355, 125, 27);
		add(lblMinimumOfSgd);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Arial", Font.BOLD, 19));
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtAmountInserted.getText().endsWith("-.--"))
				{
					JOptionPane.showMessageDialog(null, "Please insert cash.");
				}
				
				amountInserted = Double.parseDouble(txtAmountInserted.getText());
				
				if (amountInserted < 5.00)
				{
					JOptionPane.showMessageDialog(null, "Sorry, minimum amount has to be SGD$5.00.");
				}
				else
				{	
					customerCon = new CustomerController();
					double newCardBalance;
					
					newCardBalance = Double.parseDouble(txtAmountInserted.getText()) + Double.parseDouble(txtCurrentValue.getText());
					
					if(customerCon.updateCustomerCardBalance(Integer.parseInt(txtCardNumber.getText()), newCardBalance) == 0)
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Value added successfully to card.");
						txtAmountInserted.setText("-.--");
						txtCurrentValue.setText(String.valueOf(newCardBalance));
					}
				}
			}
		});
		btnOk.setBounds(330, 465, 200, 40);
		add(btnOk);
		
		JButton btnCancel = new JButton("Back to main");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 19));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnCancel.setBounds(572, 465, 200, 40);
		add(btnCancel);
		
		JLabel lblTopupCard = new JLabel("Top-up Card");
		lblTopupCard.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTopupCard.setBounds(12, 0, 108, 27);
		add(lblTopupCard);
	}

}
