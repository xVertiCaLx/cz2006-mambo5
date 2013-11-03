package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mambo5.Controller.CustomerController;
import mambo5.Controller.JInterfaceController;
import mambo5.Entity.Customer;

public class RefundCardForm extends JPanel implements JInterfaceController {

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
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(208, 153, 195, 20);
		add(txtCardNumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(208, 197, 195, 20);
		add(txtName);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		label_1.setBounds(123, 193, 96, 29);
		add(label_1);
		
		JLabel label_2 = new JLabel("Current Card Value");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(497, 146, 223, 31);
		add(label_2);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setColumns(10);
		txtCurrentValue.setBounds(497, 197, 150, 20);
		add(txtCurrentValue);
		
		JLabel label_3 = new JLabel("SGD$");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(452, 197, 59, 20);
		add(label_3);
		
		JButton btnConfirmRefund = new JButton("Confirm refund");
		btnConfirmRefund.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirmRefund.setForeground(FOREGROUND_COLOUR);
		btnConfirmRefund.setFocusPainted(false);
		btnConfirmRefund.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnConfirmRefund.setBackground(TITLEBAR_BACKGROUND_COLOUR);
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
		btnConfirmRefund.setBounds(392, 303, 119, 23);
		add(btnConfirmRefund);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.setForeground(FOREGROUND_COLOUR);
		btnBackToMain.setFocusPainted(false);
		btnBackToMain.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnBackToMain.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnBackToMain.setBounds(547, 303, 119, 23);
		add(btnBackToMain);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCustomerId.setBounds(123, 149, 96, 29);
		add(lblCustomerId);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(101, 56, 613, 40);
		add(panel);
		
		JLabel lblRefundCard = new JLabel("Refund Card");
		lblRefundCard.setForeground(Color.WHITE);
		lblRefundCard.setFont(new Font("Arial", Font.BOLD, 16));
		lblRefundCard.setBounds(258, 0, 116, 38);
		panel.add(lblRefundCard);
	}
}
