package mambo5.Form2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CamsCreateOrderForm extends JPanel {

	JPanel receiptPanel, keypadPanel, menuItemPanel;
	
	final JTextArea receipt = new JTextArea();
	
	//declaration of all the menu items
	// (Perform a for loop to dynamically create JButton base on the number
	//  of menuitem that particular stall have)
	final JButton btnChickenChop = new JButton("Chicken Chop");
	final JButton btnLambChop = new JButton("Lamb Chop");
	final JButton btnPorkChop = new JButton("Pork Chop");
	final JButton btnRibeyeSteak = new JButton("Ribeye Steak");
	final JButton btnSirloinSteak = new JButton("Sirloin Steak");
	final JButton btnBeefSteak = new JButton("Beef Steak");
	final JButton btnChickenCutlet = new JButton("Chicken Cutlet");
	final JButton btnPorkCutlet = new JButton("Pork Cutlet");
	final JButton btnFishCutlet = new JButton("Fish Cutlet");
	
	final JButton btnConfirmOrder = new JButton();
	final JButton numPad_1 = new JButton("1");
	final JButton numPad_2 = new JButton("2");
	final JButton numPad_3 = new JButton("3");
	final JButton numPad_4 = new JButton("4");
	final JButton numPad_5 = new JButton("5");
	final JButton numPad_6 = new JButton("6");
	final JButton numPad_7 = new JButton("7");
	final JButton numPad_8 = new JButton("8");
	final JButton numPad_9 = new JButton("9");
	
	
	public String generateTemplate()
	{
		receipt.setText("                     "
				+ "" + "Welcome to Happy Western\n");
		receipt.append("         "
				+ "" + "66 Nanyang Avenue 50, Singapore 420566\n");
		receipt.append("         "
				+ "" + "VAT Registeration Number. 884-230-4949\n");
		receipt.append("             "
				+ "    " + "Contact Number: +65 7436626\n");
		receipt.append("==========================================");
		receipt.append("\nInvoice Number: " + "111\t" + "         Date: 29/07/2013\n");
		receipt.append("==========================================");
		receipt.append("\n\nQuantity" + "\tItem" + "\t\tPrice\n\n");
		
		return receipt.getText();
	}
	
	public CamsCreateOrderForm() {
		//Panel size
		setBounds(0, 0, 800, 600);
		setLayout(null);	
		setBackground(new Color(240, 240, 240));
		
		//receipt panel
		receiptPanel = new JPanel();
		receiptPanel.setBounds(0, 50, 200, 100);
		receiptPanel.setLayout(null);	
		receiptPanel.setBackground(new Color(240, 240, 240));
		add(receipt);
		
		//keypad panel
		keypadPanel = new JPanel();
		keypadPanel.setBounds(0, 0, 100, 100);	
		keypadPanel.setBackground(new Color(240, 240, 240));
		//add(keypadPanel);
		keypadPanel.add(numPad_1);keypadPanel.add(numPad_2);
		keypadPanel.add(numPad_3);keypadPanel.add(numPad_4);
		keypadPanel.add(numPad_5);keypadPanel.add(numPad_6);
		keypadPanel.add(numPad_7);keypadPanel.add(numPad_8);
		keypadPanel.add(numPad_9);
		keypadPanel.setLayout(null);
		
		//menuitem panel
		menuItemPanel = new JPanel();
		keypadPanel.setBounds(500, 300, 300, 200);
		keypadPanel.setLayout(null);	
		keypadPanel.setBackground(new Color(105, 105, 105));
		keypadPanel.setForeground(Color.WHITE);
		
		//First menu Item
		btnChickenChop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnChickenChop.getText() + "   " +"\t\t$"+"4.50"+"\n");					}
			});
		btnChickenChop.setBounds(336, 53, 120, 52);
		btnChickenChop.setBackground(new Color(105, 105, 105));
		btnChickenChop.setForeground(Color.WHITE);
		add(btnChickenChop);	
		
		//Second menu Item
		btnLambChop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnLambChop.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnLambChop.setBounds(463, 53, 120, 52);
		btnLambChop.setBackground(new Color(105, 105, 105));
		btnLambChop.setForeground(Color.WHITE);
		add(btnLambChop);
		
		//Third menu Item
		btnPorkChop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnPorkChop.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnPorkChop.setBounds(592, 53, 120, 52);
		btnPorkChop.setBackground(new Color(105, 105, 105));
		btnPorkChop.setForeground(Color.WHITE);
		add(btnPorkChop);
		
		//Fourth menu Item
		btnRibeyeSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnRibeyeSteak.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnRibeyeSteak.setBounds(336, 124, 120, 52);
		btnRibeyeSteak.setBackground(new Color(105, 105, 105));
		btnRibeyeSteak.setForeground(Color.WHITE);
		add(btnRibeyeSteak);
		
		//Fifth menu Item
		btnSirloinSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnSirloinSteak.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnSirloinSteak.setBounds(463, 124, 120, 52);
		btnSirloinSteak.setBackground(new Color(105, 105, 105));
		btnSirloinSteak.setForeground(Color.WHITE);
		add(btnSirloinSteak);
		
		//Sixth menu Item
		btnBeefSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnBeefSteak.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnBeefSteak.setBounds(592, 124, 120, 52);
		btnBeefSteak.setBackground(new Color(105, 105, 105));
		btnBeefSteak.setForeground(Color.WHITE);
		add(btnBeefSteak);
		
		//Seventh menu Item
		btnChickenCutlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnChickenCutlet.getText() + "  " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnChickenCutlet.setBounds(336, 197, 120, 52);
		btnChickenCutlet.setBackground(new Color(105, 105, 105));
		btnChickenCutlet.setForeground(Color.WHITE);
		add(btnChickenCutlet);
		
		//Eighth menu Item
		btnPorkCutlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnPorkCutlet.getText() + "   " +"\t\t$"+"4.50"+"\n");;
			}
		});
		btnPorkCutlet.setBounds(592, 197, 120, 52);
		btnPorkCutlet.setBackground(new Color(105, 105, 105));
		btnPorkCutlet.setForeground(Color.WHITE);
		add(btnPorkCutlet);
		
		//Nineth menu item
		btnFishCutlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnFishCutlet.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnFishCutlet.setBounds(463, 197, 120, 52);
		btnFishCutlet.setBackground(new Color(105, 105, 105));
		btnFishCutlet.setForeground(Color.WHITE);
		add(btnFishCutlet);
	
		//Implementation of keypad 
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_1.getText() + "    ");
			}
		});
		numPad_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_1.setForeground(Color.WHITE);
		numPad_1.setBackground(Color.BLACK);
		//               x  , y  , x-size, y-size
		numPad_1.setBounds(378, 324, 57, 44);
		add(numPad_1);
		
		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_2.getText() + "    ");
			}
		});
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(448, 324, 57, 44);
		add(numPad_2);
		
		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_3.getText() + "    ");
			}
		});
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(518, 324, 57, 44);
		add(numPad_3);
		
		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_4.getText() + "    ");
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBounds(378, 383, 57, 44);
		add(numPad_4);
		
		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_5.getText() + "    ");
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBounds(448, 383, 57, 44);
		add(numPad_5);
		
		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_6.getText() + "    ");
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBounds(518, 383, 57, 44);
		add(numPad_6);
		
		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_7.getText() + "    ");
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBounds(378, 446, 57, 44);
		add(numPad_7);
		
		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_8.getText() + "    ");
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBounds(448, 446, 57, 44);
		add(numPad_8);
		
		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_9.getText() + "    ");
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBounds(518, 446, 57, 44);
		add(numPad_9);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(generateTemplate());
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setBounds(597, 334, 100, 50);
		add(btnClear);
		
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int reply = JOptionPane.showConfirmDialog(null, "Confirm Order?", "Confirmation", 
						 JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			          // insert into database with option as eatin
			        }
			}
		});
		btnConfirmOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmOrder.setForeground(Color.WHITE);
		btnConfirmOrder.setBackground(new Color(0, 128, 0));
		btnConfirmOrder.setBounds(597, 404, 100, 70);
		btnConfirmOrder.setText("<html>Confirm<br/>Order</html>");
		add(btnConfirmOrder);
		
		
		JButton btnMainPage = new JButton("Main Page");
		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainPage.setBackground(new Color(255, 0, 0));
		btnMainPage.setBounds(606, 527, 100, 23);
		add(btnMainPage);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setForeground(Color.WHITE);
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBackground(new Color(100, 149, 237));
		btnNextPage.setBounds(350, 527, 100, 23);
		add(btnNextPage);
		
		JButton btnPrevPage = new JButton("Prev Page");
		btnPrevPage.setForeground(Color.WHITE);
		btnPrevPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrevPage.setBackground(new Color(100, 149, 237));
		btnPrevPage.setBounds(477, 527, 100, 23);
		add(btnPrevPage);
	}
}
