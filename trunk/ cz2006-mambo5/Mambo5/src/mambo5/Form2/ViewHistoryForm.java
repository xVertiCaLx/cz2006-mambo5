package mambo5.Form2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewHistoryForm extends JPanel {

	
	private JTextField txtCardNumber;
	private JTextField txtName;
	private JTextField txtCurrentValue;

	public ViewHistoryForm(final CamsMainFrame mainFrame) {
		
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JList listHistory = new JList();
		listHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listHistory.setEnabled(false);
		listHistory.setBounds(22, 112, 369, 103);
		add(listHistory);
		
		JLabel lblHistory = new JLabel("Purchase History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHistory.setBounds(22, 86, 90, 28);
		add(lblHistory);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(22, 64, 46, 14);
		add(lblName);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardNumber.setBounds(22, 36, 90, 14);
		add(lblCardNumber);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCardNumber.setEnabled(false);
		txtCardNumber.setEditable(false);
		txtCardNumber.setBounds(106, 33, 141, 20);
		add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setEnabled(false);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(106, 61, 141, 20);
		add(txtName);
		
		JLabel lblCardValue = new JLabel("Current Card Value");
		lblCardValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardValue.setBounds(283, 36, 119, 14);
		add(lblCardValue);
		
		txtCurrentValue = new JTextField();
		txtCurrentValue.setEnabled(false);
		txtCurrentValue.setEditable(false);
		txtCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCurrentValue.setText("-.--");
		txtCurrentValue.setBounds(332, 54, 59, 28);
		add(txtCurrentValue);
		txtCurrentValue.setColumns(10);
		
		JLabel lblSgd = new JLabel("SGD$");
		lblSgd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSgd.setBounds(276, 58, 59, 20);
		add(lblSgd);
		
		JButton btnBackToMain = new JButton("Back to main");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackToMain.setBounds(279, 223, 112, 28);
		add(btnBackToMain);
		
		JLabel lblViewHistor = new JLabel("View History");
		lblViewHistor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblViewHistor.setBounds(4, 0, 108, 27);
		add(lblViewHistor);
	}
}
