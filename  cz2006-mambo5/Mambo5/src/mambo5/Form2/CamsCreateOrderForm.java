package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;

public class CamsCreateOrderForm extends JPanel {
	
	private OrderController oc;
	private OrderDetailController odc;
	private CamsMainFrame mainFrame;
	
	//For Order
	private int custID, orderID;
	private Timestamp purchaseDate;
	private String orderStatus;
	
	//For OrderDetails
	private int menuItemID;
	private double actualPrice;
	private String instructions;
	private int order;
	private int stallID;
	
	ArrayList orderDetailsList = new ArrayList();
	
	JPanel receiptPanel, keypadPanel, menuItemPanel, sidePanel;
	
	final JTextArea receipt = new JTextArea();

	JButton numPad_1 = new JButton("1");
	JButton numPad_2 = new JButton("2");
	JButton numPad_3 = new JButton("3");
	JButton numPad_4 = new JButton("4");
	JButton numPad_5 = new JButton("5");
	JButton numPad_6 = new JButton("6");
	JButton numPad_7 = new JButton("7");
	JButton numPad_8 = new JButton("8");
	JButton numPad_9 = new JButton("9");
	
	JButton btnClear = new JButton("CLEAR");
	JButton btnConfirmOrder = new JButton();
	
	JButton btnMainPage = new JButton("MAIN PAGE");
	JButton btnNextPage = new JButton("NEXT PAGE");
	JButton btnPrevPage = new JButton("PREV PAGE");
	
	//declaration of all the menu items
	//(Perform a for loop to dynamically create JButton base on the number
	//of menuitem that particular stall have)
	final JButton btnMenuItem_1 = new JButton("Chicken Chop");
	final JButton btnMenuItem_2 = new JButton("Lamb Chop");
	final JButton btnMenuItem_3 = new JButton("Pork Chop");
	final JButton btnMenuItem_4 = new JButton("Ribeye Steak");
	final JButton btnMenuItem_5 = new JButton("Sirloin Steak");
	final JButton btnMenuItem_6 = new JButton("Beef Steak");
	final JButton btnMenuItem_7 = new JButton("Chicken Cutlet");
	final JButton btnMenuItem_8 = new JButton("Pork Cutlet");
	final JButton btnMenuItem_9 = new JButton("Fish Cutlet");
	
	public CamsCreateOrderForm(/*mainFrame*/) {
		
		//default
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240,240,240));
		
		receipt.setBounds(10, 10, 280, 520);

		receiptPanel = new JPanel();
		receiptPanel.setBounds(0,0,300,530);
		receiptPanel.setLayout(null);
		receiptPanel.setBackground(new Color(250,250,250));
		receiptPanel.add(receipt);
		add(receiptPanel);
		
		menuItemPanel = new JPanel();
		menuItemPanel.setBounds(300,0,490,290);
		menuItemPanel.setLayout(null);
		menuItemPanel.setBackground(new Color(250,250,250));
		add(menuItemPanel);
		
		keypadPanel = new JPanel();
		keypadPanel.setBounds(300,290,350,240);
		keypadPanel.setLayout(null);
		keypadPanel.setBackground(new Color(250,250,250));
		add(keypadPanel);
	
		sidePanel = new JPanel();
		sidePanel.setBounds(650,290,140,240);
		sidePanel.setLayout(null);
		sidePanel.setBackground(new Color(250,250,250));
		add(sidePanel);
		
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_1.getText() + "    ");
			}
		});
		
		numPad_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_1.setForeground(Color.WHITE);
		numPad_1.setBackground(Color.BLACK);
		numPad_1.setBounds(10, 10, 60, 60);
		keypadPanel.add(numPad_1);
		
		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_2.getText() + "    ");
			}
		});
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(80, 10, 60, 60);
		keypadPanel.add(numPad_2);		
		
		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_3.getText() + "    ");
			}
		});
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(150, 10, 60, 60);
		keypadPanel.add(numPad_3);
		
		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_4.getText() + "    ");
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBounds(10, 80, 60, 60);
		keypadPanel.add(numPad_4);
		
		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_5.getText() + "    ");
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBounds(80, 80, 60, 60);
		keypadPanel.add(numPad_5);
		
		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_6.getText() + "    ");
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBounds(150, 80, 60, 60);
		keypadPanel.add(numPad_6);
		
		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_7.getText() + "    ");
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBounds(10, 150, 60, 60);
		keypadPanel.add(numPad_7);
		
		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_8.getText() + "    ");
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBounds(80, 150, 60, 60);
		keypadPanel.add(numPad_8);
		
		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_9.getText() + "    ");
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBounds(150, 150, 60, 60);
		keypadPanel.add(numPad_9);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText("s");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setBounds(235, 40, 100, 70);
		keypadPanel.add(btnClear);
		
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int reply = JOptionPane.showConfirmDialog(null, "Confirm Order?", "Confirmation", 
						 JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			        	submitsOrder();
			        	submitsOrderDetails();
			        }
			}
		});
		btnConfirmOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmOrder.setForeground(Color.WHITE);
		btnConfirmOrder.setBackground(new Color(0, 128, 0));
		btnConfirmOrder.setBounds(235, 120, 100, 70);
		btnConfirmOrder.setText("<html>CONFIRM<br/>ORDER</html>");
		keypadPanel.add(btnConfirmOrder);
		
		
		//First menu Item
		btnMenuItem_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_1.getText() + "\t$"+"4.50"+"\n");	
			//orderDetailsList.add(btnMenuItem_1.getText());
			}
		});
		btnMenuItem_1.setBounds(10, 10, 150, 80);
		btnMenuItem_1.setBackground(new Color(105, 105, 105));
		btnMenuItem_1.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_1);	
		
		//Second menu Item
		btnMenuItem_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_2.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_2.setBounds(170, 10, 150, 80);
		btnMenuItem_2.setBackground(new Color(105, 105, 105));
		btnMenuItem_2.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_2);
		
		//Third menu Item
		btnMenuItem_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_3.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_3.setBounds(330, 10, 150, 80);
		btnMenuItem_3.setBackground(new Color(105, 105, 105));
		btnMenuItem_3.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_3);		
		
		//Fourth menu Item
		btnMenuItem_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_4.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_4.setBounds(10, 100, 150, 80);
		btnMenuItem_4.setBackground(new Color(105, 105, 105));
		btnMenuItem_4.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_4);
		
		//Fifth menu Item
		btnMenuItem_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_5.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_5.setBounds(170, 100, 150, 80);
		btnMenuItem_5.setBackground(new Color(105, 105, 105));
		btnMenuItem_5.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_5);
		
		//Sixth menu Item
		btnMenuItem_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_6.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_6.setBounds(330, 100, 150, 80);
		btnMenuItem_6.setBackground(new Color(105, 105, 105));
		btnMenuItem_6.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_6);
		
		//Seventh menu Item
		btnMenuItem_7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_7.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_7.setBounds(10, 190, 150, 80);
		btnMenuItem_7.setBackground(new Color(105, 105, 105));
		btnMenuItem_7.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_7);
		
		//Eigth menu Item
		btnMenuItem_8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_8.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_8.setBounds(170, 190, 150, 80);
		btnMenuItem_8.setBackground(new Color(105, 105, 105));
		btnMenuItem_8.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_8);
		
		//Nineth menu Item
		btnMenuItem_9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			receipt.append("\t" + btnMenuItem_9.getText() + "\t$"+"4.50"+"\n");					}
		});
		btnMenuItem_9.setBounds(330, 190, 150, 80);
		btnMenuItem_9.setBackground(new Color(105, 105, 105));
		btnMenuItem_9.setForeground(Color.WHITE);
		menuItemPanel.add(btnMenuItem_9);
		
		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainPage.setBackground(new Color(255, 0, 0));
		btnMainPage.setBounds(10, 10, 110, 70);
		sidePanel.add(btnMainPage);
		
		btnNextPage.setForeground(Color.WHITE);
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBackground(new Color(100, 149, 237));
		btnNextPage.setBounds(10, 90, 110, 50);
		sidePanel.add(btnNextPage);
		
		btnPrevPage.setForeground(Color.WHITE);
		btnPrevPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrevPage.setBackground(new Color(100, 149, 237));
		btnPrevPage.setBounds(10, 150, 110, 50);
		sidePanel.add(btnPrevPage);
	}
	
	//A method to retrieve current datetime
	private Timestamp GetDate() {
		long time = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
	
		return timestamp;
}
	
	public void submitsOrder() {
		purchaseDate = GetDate();
		orderStatus = "Processing";
		custID = 1; //Need to know how to retrieve custID
		stallID = 2; //Need to know how to retrieve stallID
		
		oc = new OrderController();
		order = oc.validateCreateOrder(custID, purchaseDate, orderStatus, stallID);
		if(custID == 0 || purchaseDate.equals("") || orderStatus.equals("") || stallID == 0)
			JOptionPane.showMessageDialog(null, "Order cannot be created");
		else
			JOptionPane.showMessageDialog(null, "Order ID: " + order);	
	}
	
	public void submitsOrderDetails() {
		menuItemID = 1; //Need to know how to retrieve menuItemID
		actualPrice = 7.99; //Need to know how to retrieve price

		odc = new OrderDetailController();
		odc.validateCreateOrderDetail(order, menuItemID, actualPrice);
		JOptionPane.showMessageDialog(null, "Order Details Added!");
	}
	
}