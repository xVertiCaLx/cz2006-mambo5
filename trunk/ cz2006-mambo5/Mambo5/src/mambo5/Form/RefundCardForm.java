package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import mambo5.Controller.CustomerController;
import mambo5.Entity.Customer;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class RefundCardForm extends JPanel {

	//private JPanel contentPane;
	private Customer cust;
	private CustomerController customerCon;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;

	public RefundCardForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		txtCardNumber = new JTextField();
		txtCardNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String custID = JOptionPane.showInputDialog("Please enter Customer ID");
				customerCon = new CustomerController();
				cust = customerCon.retrieveCustomerInfo(Integer.parseInt(custID));
				
				if (cust != null)
				{
					txtCardNumber.setText(custID);
					txtName.setText(cust.getFullName());
					txtCurrentValue.setText(String.valueOf(cust.getCardBalance()));
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Error in retrieving customer information.");
				}
				
				
			}
		});
		txtCardNumber.setFont(new Font("Arial", Font.BOLD, 19));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(182, 163, 195, 27);
		add(txtCardNumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.BOLD, 19));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(182, 222, 195, 27);
		add(txtName);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Arial", Font.BOLD, 19));
		label_1.setBounds(32, 221, 104, 29);
		add(label_1);
		
		JLabel label_2 = new JLabel("Current Card Value");
		label_2.setFont(new Font("Arial", Font.BOLD, 22));
		label_2.setBounds(500, 160, 223, 31);
		add(label_2);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setFont(new Font("Arial", Font.BOLD, 19));
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setColumns(10);
		txtCurrentValue.setBounds(573, 222, 150, 27);
		add(txtCurrentValue);
		
		JLabel label_3 = new JLabel("SGD$");
		label_3.setFont(new Font("Arial", Font.BOLD, 19));
		label_3.setBounds(475, 225, 59, 20);
		add(label_3);
		
		JButton btnConfirmRefund = new JButton("Confirm refund");
		btnConfirmRefund.setFont(new Font("Arial", Font.BOLD, 19));
		btnConfirmRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtCardNumber.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please place card on reader.");
				}
				else 
				{	
					if(customerCon.removeCustomerAccount(Integer.parseInt(txtCardNumber.getText())) == 0)
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Card refunded successfully, please remember to collect your refund.");
						txtCardNumber.setText("");
						txtCurrentValue.setText("");
						txtName.setText("");
						mainFrame.replacePanel(new MainMenuForm(mainFrame));
					}
					
				}
			}
		});
		btnConfirmRefund.setBounds(294, 400, 200, 40);
		add(btnConfirmRefund);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.setFont(new Font("Arial", Font.BOLD, 19));
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnBackToMain.setBounds(524, 400, 200, 40);
		add(btnBackToMain);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setFont(new Font("Arial", Font.BOLD, 19));
		lblCustomerId.setBounds(32, 162, 140, 29);
		add(lblCustomerId);
		
		JLabel lblRefundCard = new JLabel("Refund Card");
		lblRefundCard.setFont(new Font("Arial", Font.BOLD, 34));
		lblRefundCard.setBounds(319, 86, 223, 31);
		add(lblRefundCard);
	}
}
