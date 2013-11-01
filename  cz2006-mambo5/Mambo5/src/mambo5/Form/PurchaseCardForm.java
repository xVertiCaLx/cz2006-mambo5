package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.Color;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class PurchaseCardForm extends JPanel {

	//private JPanel contentPane;
	private JTextField txtAmountInserted;
	private double cardBalance;
	private String fullName;
	private int accessID;
	private CustomerController customerCon;
	

	public PurchaseCardForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JLabel lblPleaseInsertSgs = new JLabel("Please insert notes");
		lblPleaseInsertSgs.setFont(new Font("Arial", Font.BOLD, 22));
		lblPleaseInsertSgs.setBounds(73, 186, 208, 27);
		add(lblPleaseInsertSgs);
		
		txtAmountInserted = new JTextField();
		txtAmountInserted.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String valueEntered = JOptionPane.showInputDialog("Please enter initial purhcase card value.");
				txtAmountInserted.setText(valueEntered);
			
			}
		});
		txtAmountInserted.setEditable(false);
		txtAmountInserted.setText("-.--");
		txtAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtAmountInserted.setBounds(131, 298, 150, 27);
		add(txtAmountInserted);
		txtAmountInserted.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Arial", Font.BOLD, 19));
		lblSgd.setBounds(58, 296, 65, 32);
		add(lblSgd);
		
		JLabel lblInserted = new JLabel("Amount inserted");
		lblInserted.setFont(new Font("Arial", Font.BOLD, 19));
		lblInserted.setBounds(87, 234, 171, 27);
		add(lblInserted);
		
		JButton btnCancel = new JButton("Back to main");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 19));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnCancel.setBounds(569, 443, 200, 40);
		add(btnCancel);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$10.00");
		lblMinimumOfSgd.setFont(new Font("Arial", Font.BOLD, 10));
		lblMinimumOfSgd.setBounds(131, 324, 156, 27);
		add(lblMinimumOfSgd);
		
		JLabel lblNotesAccepted = new JLabel("Notes accepted");
		lblNotesAccepted.setFont(new Font("Arial", Font.BOLD, 22));
		lblNotesAccepted.setBounds(491, 186, 200, 27);
		add(lblNotesAccepted);
		
		JLabel lblSgd_1 = new JLabel("SGD$2.00");
		lblSgd_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblSgd_1.setBounds(448, 237, 125, 20);
		add(lblSgd_1);
		
		JLabel lblSgd_2 = new JLabel("SGD$5.00");
		lblSgd_2.setFont(new Font("Arial", Font.BOLD, 19));
		lblSgd_2.setBounds(613, 237, 97, 20);
		add(lblSgd_2);
		
		JLabel lblSgd_3 = new JLabel("SGD$10.00");
		lblSgd_3.setFont(new Font("Arial", Font.BOLD, 19));
		lblSgd_3.setBounds(448, 302, 125, 20);
		add(lblSgd_3);
		
		JLabel lblSgd_4 = new JLabel("SGD$50.00");
		lblSgd_4.setFont(new Font("Arial", Font.BOLD, 19));
		lblSgd_4.setBounds(613, 302, 108, 20);
		add(lblSgd_4);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Arial", Font.BOLD, 19));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				
				
				if (txtAmountInserted.getText().endsWith("-.--"))
				{
					JOptionPane.showMessageDialog(null, "Please insert cash.");
				}
	
				else if (Double.parseDouble(txtAmountInserted.getText()) < 10.00)
				{
					JOptionPane.showMessageDialog(null, "Sorry, minimum amount has to be SGD$10.00.");
				}
				else 
				{
					customerCon = new CustomerController();
					fullName = "Visitor";
					accessID = 6;
					cardBalance = Double.parseDouble(txtAmountInserted.getText());
					
					if(customerCon.validateCustomerDetail(cardBalance, fullName, accessID)==0)
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Card purchased successfully.");
						mainFrame.replacePanel(new MainMenuForm(mainFrame));
					}
				}
				}
			
		});
		btnOk.setBounds(311, 443, 200, 40);
		add(btnOk);
		
		JLabel lblPurchaseCard_1 = new JLabel("Purchase Card");
		lblPurchaseCard_1.setFont(new Font("Arial", Font.BOLD, 34));
		lblPurchaseCard_1.setBounds(287, 97, 253, 32);
		add(lblPurchaseCard_1);
	}

}
