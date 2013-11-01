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
		lblPleaseInsertSgs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseInsertSgs.setBounds(169, 138, 208, 27);
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
		txtAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAmountInserted.setBounds(177, 219, 150, 20);
		add(txtAmountInserted);
		txtAmountInserted.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd.setBounds(139, 213, 65, 32);
		add(lblSgd);
		
		JLabel lblInserted = new JLabel("Amount inserted");
		lblInserted.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInserted.setBounds(179, 176, 97, 27);
		add(lblInserted);
		
		JButton btnCancel = new JButton("Back to main");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnCancel.setBounds(550, 315, 119, 23);
		add(btnCancel);
		
		JLabel lblMinimumOfSgd = new JLabel("Minimum of SGD$10.00");
		lblMinimumOfSgd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblMinimumOfSgd.setBounds(176, 238, 89, 27);
		add(lblMinimumOfSgd);
		
		JLabel lblNotesAccepted = new JLabel("Notes accepted");
		lblNotesAccepted.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotesAccepted.setBounds(463, 138, 200, 27);
		add(lblNotesAccepted);
		
		JLabel lblSgd_1 = new JLabel("SGD$2.00");
		lblSgd_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd_1.setBounds(438, 179, 89, 20);
		add(lblSgd_1);
		
		JLabel lblSgd_2 = new JLabel("SGD$5.00");
		lblSgd_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd_2.setBounds(550, 179, 74, 20);
		add(lblSgd_2);
		
		JLabel lblSgd_3 = new JLabel("SGD$10.00");
		lblSgd_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd_3.setBounds(438, 225, 74, 20);
		add(lblSgd_3);
		
		JLabel lblSgd_4 = new JLabel("SGD$50.00");
		lblSgd_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSgd_4.setBounds(550, 225, 108, 20);
		add(lblSgd_4);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		btnOk.setBounds(420, 315, 89, 23);
		add(btnOk);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(112, 42, 613, 40);
		add(panel);
		
		JLabel lblPurchaseCard = new JLabel("Purchase Card");
		lblPurchaseCard.setForeground(Color.WHITE);
		lblPurchaseCard.setFont(new Font("Arial", Font.BOLD, 16));
		lblPurchaseCard.setBounds(254, 0, 116, 38);
		panel.add(lblPurchaseCard);
	}

}
