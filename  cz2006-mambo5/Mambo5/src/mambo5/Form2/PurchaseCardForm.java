package mambo5.Form2;

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
		
		JLabel lblPurchaseCard = new JLabel("Purchase Card");
		lblPurchaseCard.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPurchaseCard.setBounds(10, 0, 108, 27);
		add(lblPurchaseCard);
		
		JLabel lblPleaseInsertSgs = new JLabel("Please insert notes");
		lblPleaseInsertSgs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPleaseInsertSgs.setBounds(29, 57, 166, 27);
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
		txtAmountInserted.setBounds(87, 119, 70, 35);
		add(txtAmountInserted);
		txtAmountInserted.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSgd.setBounds(29, 120, 65, 32);
		add(lblSgd);
		
		JLabel lblInserted = new JLabel("Amount inserted");
		lblInserted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInserted.setBounds(39, 81, 108, 27);
		add(lblInserted);
		
		JButton btnCancel = new JButton("Back to main");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnCancel.setBounds(315, 231, 109, 20);
		add(btnCancel);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$10.00");
		lblMinimumOfSgd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMinimumOfSgd.setBounds(39, 155, 108, 27);
		add(lblMinimumOfSgd);
		
		JLabel lblNotesAccepted = new JLabel("Notes accepted");
		lblNotesAccepted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNotesAccepted.setBounds(264, 59, 108, 27);
		add(lblNotesAccepted);
		
		JLabel lblSgd_1 = new JLabel("SGD$2.00");
		lblSgd_1.setBounds(244, 97, 70, 20);
		add(lblSgd_1);
		
		JLabel lblSgd_2 = new JLabel("SGD$5.00");
		lblSgd_2.setBounds(323, 97, 70, 20);
		add(lblSgd_2);
		
		JLabel lblSgd_3 = new JLabel("SGD$10.00");
		lblSgd_3.setBounds(244, 130, 70, 20);
		add(lblSgd_3);
		
		JLabel lblSgd_4 = new JLabel("SGD$50.00");
		lblSgd_4.setBounds(323, 130, 70, 20);
		add(lblSgd_4);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				if (txtAmountInserted.getText().endsWith("-.--"))
				{
					JOptionPane.showMessageDialog(null, "Please insert cash.");
				}
				
				cardBalance = Double.parseDouble(txtAmountInserted.getText());
				
				if (cardBalance < 10.00)
				{
					JOptionPane.showMessageDialog(null, "Sorry, minimum amount has to be SGD$10.00.");
				}
				else 
				{
					customerCon = new CustomerController();
					fullName = "Visitor";
					accessID = 6;
					
					if(customerCon.validateCustomerDetail(cardBalance, fullName, accessID)==0)
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Card purchased successfully.");
					}
				}
			}
		});
		btnOk.setBounds(184, 231, 109, 20);
		add(btnOk);
		
		JLabel lblMessage = new JLabel("Please collect your card.");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMessage.setBounds(32, 193, 180, 14);
		add(lblMessage);
	}

}
