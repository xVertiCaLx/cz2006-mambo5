package mambo5.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import mambo5.Controller.CustomerController;
import mambo5.Controller.JInterfaceController;
import mambo5.Entity.Customer;
import mambo5.Entity.MenuItem;

public class ViewHistoryForm extends JPanel implements JInterfaceController {

	private Customer cust;
	private ArrayList<Customer> retrieveOrderHistory;
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;
	private CustomerController customerCon;
	private JComboBox<String> comboBoxHistory = new JComboBox<String>();
	private JTable transactionTable;

	public ViewHistoryForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JLabel lblHistory = new JLabel("Purchase History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHistory.setBounds(121, 216, 165, 28);
		add(lblHistory);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(121, 164, 103, 22);
		add(lblName);
		
		JLabel lblCardNumber = new JLabel("Customer ID:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCardNumber.setBounds(121, 126, 103, 27);
		add(lblCardNumber);
		
		txtCardNumber = new JTextField();
		txtCardNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String custID = JOptionPane.showInputDialog("Please enter Customer ID");
				customerCon = new CustomerController();
				cust = customerCon.retrieveCustomerInfo(Integer.parseInt(custID));
				
				if (cust!= null)
				{
				txtCardNumber.setText(custID);
				txtName.setText(cust.getFullName());
				txtCurrentValue.setText(String.valueOf(cust.getCardBalance()));
				
				ArrayList<String> date = new ArrayList<String>();
				date = customerCon.getCustomerPuchaseDate(Integer.parseInt(custID));
				comboBoxHistory.removeAllItems();
				if(date.size() != 0) {
					for(int i = 0; i<date.size(); i++ ) {
						comboBoxHistory.addItem(date.get(i));
					}
					
					displayMenuItem(comboBoxHistory.getSelectedItem().toString(), Integer.parseInt(custID));
				}
				else 
					JOptionPane.showMessageDialog(null, "No Purchase History Available");
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
		txtCardNumber.setBounds(212, 128, 195, 20);
		add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(212, 164, 195, 20);
		add(txtName);
		
		JLabel lblCardValue = new JLabel("Current Card Value");
		lblCardValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCardValue.setBounds(511, 123, 130, 28);
		add(lblCardValue);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setBounds(511, 166, 150, 20);
		add(txtCurrentValue);
		txtCurrentValue.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd.setBounds(473, 165, 59, 20);
		add(lblSgd);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.setForeground(FOREGROUND_COLOUR);
		btnBackToMain.setFocusPainted(false);
		btnBackToMain.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnBackToMain.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackToMain.setBounds(542, 476, 119, 23);
		add(btnBackToMain);
		comboBoxHistory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayMenuItem(comboBoxHistory.getSelectedItem().toString(),Integer.parseInt(txtCardNumber.getText().toString()));
			}
		});
		
		comboBoxHistory.setBounds(121, 250, 195, 20);
		add(comboBoxHistory);
	
		getJTableMenu();
		transactionTable.setBounds(10, 52, 414, 163);
		add(transactionTable);
		JScrollPane scrollPane = new JScrollPane(transactionTable);
		scrollPane.setBounds(121, 292, 347, 148);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(112, 42, 613, 40);
		add(panel);
		
		JLabel lblViewHistory = new JLabel("Check History");
		lblViewHistory.setForeground(Color.WHITE);
		lblViewHistory.setFont(new Font("Arial", Font.BOLD, 16));
		lblViewHistory.setBounds(254, 0, 116, 38);
		panel.add(lblViewHistory);
		
		
	}
	private void getJTableMenu() {
		transactionTable = new JTable();
		transactionTable.setEnabled(false);
		transactionTable.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		transactionTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);	
	}
	
	private void displayMenuItem(String purchaseDate, int custID) {
		DefaultTableModel tableModel = (DefaultTableModel) transactionTable.getModel();
		tableModel.setRowCount(0);
		String[] colName = {"Menu Item", "Item Price"};
		tableModel.setColumnIdentifiers(colName);

		CustomerController cc = new CustomerController();
		ArrayList<MenuItem> itemList = cc.getCustomerMenuItem(purchaseDate, custID);
		for(int i=0; i<itemList.size(); i++) {
			
			Object[] objects = new Object[2];
			objects[0] = itemList.get(i).getMenuItemName();
			objects[1] = itemList.get(i).getMenuItemPrice();
			
			tableModel.addRow(objects);	
		}
		
		transactionTable.setModel(tableModel);
	}
	
}
