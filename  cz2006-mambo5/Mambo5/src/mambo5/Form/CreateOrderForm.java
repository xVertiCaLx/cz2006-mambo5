package mambo5.Form;

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

public class CreateOrderForm extends JPanel {

	//private JPanel contentPane;
	private final JLabel lblOrderId = new JLabel("NEW ORDER #xxx");
	private int finalValue = 0;
	
	//testing only
	private int itemPrice;
	
	final JTextArea receipt = new JTextArea();
	
	//To calculate total amount
	public int generateFinalValue(int totalValue)
	{
		finalValue += totalValue;
		return finalValue;
	}
	
	//testing
	public void setAmount(int itemPrice)
	{
		this.itemPrice = itemPrice;
	}
	//testing
	public int getAmount()
	{
		return itemPrice;
	}
	
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
	
	public CreateOrderForm() {
		setBounds(0, 0, 800, 600);
		setLayout(null);	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 800, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("#Canteen");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(10, 0, 103, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("#Canteen");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(0, 0, 784, 39);
		panel.add(label_1);
		
		
		receipt.setLineWrap(true);
		receipt.setText(generateTemplate());
		receipt.setBackground(new Color(245, 245, 245));
		receipt.setBounds(21, 50, 300, 801);
		JTextArea card = new JTextArea(24, 26);
		add(receipt);
		add(new JScrollPane(card));
		
		//First menu Item
		final JButton btnChickenChop = new JButton("Chicken Chop");
		btnChickenChop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnChickenChop.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnChickenChop.setBounds(336, 53, 120, 52);
		btnChickenChop.setBackground(new Color(105, 105, 105));
		btnChickenChop.setForeground(Color.WHITE);
		add(btnChickenChop);
		
		//Second menu Item
		final JButton btnLambChop = new JButton("Lamb Chop");
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
		final JButton btnPorkChop = new JButton("Pork Chop");
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
		final JButton btnRibeyeSteak = new JButton("Ribeye Steak");
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
		final JButton btnSirloinSteak = new JButton("Sirloin Steak");
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
		final JButton btnBeefSteak = new JButton("Beef Steak");
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
		final JButton btnChickenCutlet = new JButton("Chicken Cutlet");
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
		final JButton btnPorkCutlet = new JButton("Pork Cutlet");
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
		final JButton btnFishCutlet = new JButton("Fish Cutlet");
		btnFishCutlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\t" + btnFishCutlet.getText() + "   " +"\t\t$"+"4.50"+"\n");
			}
		});
		btnFishCutlet.setBounds(463, 197, 120, 52);
		btnFishCutlet.setBackground(new Color(105, 105, 105));
		btnFishCutlet.setForeground(Color.WHITE);
		add(btnFishCutlet);
		
		
		final JButton btnEatIn = new JButton("EAT IN");
		btnEatIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int reply = JOptionPane.showConfirmDialog(null, "Confirm eat in?", "Confirmation", 
						 JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			          // insert into database with option as eatin
			        }
			}
		});
		
		btnEatIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEatIn.setForeground(Color.WHITE);
		btnEatIn.setBackground(new Color(0, 128, 0));
		btnEatIn.setBounds(420, 276, 89, 23);
		add(btnEatIn);
		
		final JButton btnTakeOut = new JButton("TAKE OUT");
		btnTakeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int reply = JOptionPane.showConfirmDialog(null, "Confirm take out?", "Confirmation", 
						 JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			          // insert into database with option as takeaway
			        }
			}
		});
		btnTakeOut.setForeground(Color.WHITE);
		btnTakeOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTakeOut.setBackground(new Color(0, 128, 0));
		btnTakeOut.setBounds(557, 276, 89, 23);
		add(btnTakeOut);
			
		final JButton numPad_1 = new JButton();
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
		
		final JButton numPad_2 = new JButton();
		numPad_2.setText("2");
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
		
		final JButton numPad_3 = new JButton();
		numPad_3.setText("3");
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
		
		final JButton numPad_4 = new JButton();
		numPad_4.setText("4");
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
		
		final JButton numPad_5 = new JButton();
		numPad_5.setText("5");
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
		
		final JButton numPad_6 = new JButton();
		numPad_6.setText("6");
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
		
		final JButton numPad_7 = new JButton();
		numPad_7.setText("7");
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
		
		final JButton numPad_8 = new JButton();
		numPad_8.setText("8");
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
		
		final JButton numPad_9 = new JButton();
		numPad_9.setText("9");
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
		btnClear.setBounds(597, 344, 100, 50);
		add(btnClear);
		
		final JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("\n");
			}
		});
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setBounds(597, 416, 100, 52);
		add(btnEnter);
		
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
