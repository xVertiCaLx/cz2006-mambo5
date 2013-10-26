package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class CamsCreateOrderForm extends JPanel implements JInterfaceController {

	private OrderController oc;
	private OrderDetailController odc;
	private MenuItemController menuItemController;

	private Map<JButton, MenuItem> menuItemButtons;
	
	// For Order
	private int custID;
	private Timestamp purchaseDate;
	private String orderStatus;

	// For OrderDetails
	private int order, menuID;
	private int stallID;
	private int posX = 0, posY = 0;

	// For MenuItem
	private ArrayList<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
	private ArrayList<MenuItem> menuItemList;

	private JPanel receiptPanel, keypadPanel, menuItemPanel, sidePanel;

	private JTextArea receipt;
	private JScrollPane receiptScrollPane;
	
	private NumPad numpadPanel;

	JButton btnClear = new JButton("CLEAR");
	JButton btnConfirmOrder = new JButton();

	JButton btnMainPage = new JButton("MAIN PAGE");
	JButton btnNextPage = new JButton("NEXT PAGE");
	JButton btnPrevPage = new JButton("PREV PAGE");
	
	JLabel totalPrice = new JLabel();
	
	public CamsCreateOrderForm(final CamsMainFrame mainFrame, int menuID) {
		/*menuItemList = new ArrayList<MenuItem>();
		menuItemController = new MenuItemController();
		menuID = 5;

		menuItemController.retrieveMenuItemList(menuItemList, 5);

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println("element" + i + ":" + menuItemList.get(i).getMenuItemName());
		}*/
		// default
		this.menuID = menuID;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		initPanels();
		implementButtons();
	}
	
	//initialise panels
	public void initPanels() {
		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH, RECEIPTPANE_HEIGHT));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		receipt = new JTextArea(32, 26);
		receipt.setEditable(false);
		receipt.setBackground(RECEIPT_BACKGROUND_COLOUR);
		
		receiptScrollPane = new JScrollPane(receipt);
		
		receiptPanel.add(receiptScrollPane);
		
		posX += receiptPanel.getWidth();
		
		menuItemPanel = new JPanel();
		menuItemPanel.setSize(new Dimension(MENUITEMPANE_WIDTH, MENUITEMPANE_HEIGHT));
		menuItemPanel.setLocation(posX, posY);
		menuItemPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		posY += menuItemPanel.getHeight();
		
		//initialise number pad
		numpadPanel = new NumPad();
		numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		numpadPanel.setLocation(posX, posY);
		
		/*keypadPanel = new JPanel();
		keypadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		keypadPanel.setLocation(posX, posY);
		keypadPanel.setBackground(JPANEL_BACKGROUND_COLOUR);*/

		posX += numpadPanel.getWidth();
				
		sidePanel = new JPanel();
		sidePanel.setSize(SIDEPANE_WIDTH, SIDEPANE_HEIGHT);
		sidePanel.setLocation(posX, posY);
		sidePanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		initMenuItemButtons(menuID);
		initSidePanelButton();
		add(receiptPanel);
		add(menuItemPanel);
		add(numpadPanel);
		add(sidePanel);
		
		/*initKeypad();*/

	}
	
	public void implementButtons() {
		//actual implementation
		numpadPanel.num1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action performance
				receipt.append("1    ");
			}
		});
		
		numpadPanel.num2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("2    ");
			}
		});
		
		numpadPanel.num3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("3    ");
			}
		});
		
		numpadPanel.num4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("4    ");
			}
		});
		
		numpadPanel.num5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("5    ");
			}
		});
		
		numpadPanel.num6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("6    ");
			}
		});
		//but it doesnt reflect. u see ah
		numpadPanel.num7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("7    ");
			}
		});
		
		numpadPanel.num8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("8    ");
			}
		});
		
		numpadPanel.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("9    ");
			}
		});
		
		numpadPanel.delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText().substring(0,
								receipt.getText().length() - 1));
			}
		});
		
		numpadPanel.enter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Confirm Order?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					submitsOrder();
					submitsOrderDetails();
				}
			}
		});
	}
	
	//initialise menuitem buttons
	public void initMenuItemButtons(int menuID) {
		menuItemButtons = new HashMap<JButton, MenuItem>();
		menuItemList = new ArrayList<MenuItem>();
		menuItemController = new MenuItemController();

		menuItemController.retrieveMenuItemList(menuItemList, 5);

		for (int i = 0; i < menuItemList.size(); i++) {
			addMenuItemButtons(menuItemList.get(i));
		}
	}
	
	public void addMenuItemButtons(MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
        menuItemButton.setActionCommand(menuItem.getMenuItemName());
        menuItemButtons.put(menuItemButton, menuItem);
        menuItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	double discount= menuItemButtons.get(e.getSource()).getDiscount();
            	double actualPrice= menuItemButtons.get(e.getSource()).getMenuItemPrice();
            	actualPrice = (actualPrice*(100-discount))/100;
            	
            	receipt.append("\t" + (menuItemButtons.get(e.getSource()).getMenuItemName()) + "\t$" + menuItemButtons.get(e.getSource()).getMenuItemPrice()
						+ "\n");

            	orderDetailsList.add(new OrderDetail(menuItemButtons.get(e.getSource()).getMenuItemID(), actualPrice));
            }
        });
        
        menuItemPanel.add(menuItemButton);
	}

/*	public void initKeypad() {
		posX = MARGIN;
		posY = MARGIN;
		
		numPad_1.setFont(new Font("Arial", Font.BOLD, 12));
		numPad_1.setForeground(KEYPAD_FOREGROUND_COLOUR);
		numPad_1.setBackground(KEYPAD_BACKGROUND_COLOUR);
		numPad_1.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		numPad_1.setLocation(posX, posY);
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_1.getText() + "    ");
			}
		});
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
				int reply = JOptionPane.showConfirmDialog(null,
						"Confirm Order?", "Confirmation",
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
	}*/
	
	public void initSidePanelButton() {
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
	
	// A method to retrieve current datetime
	private Timestamp GetDate() {
		long time = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);

		return timestamp;
	}

	public void submitsOrder() {
		purchaseDate = GetDate();
		orderStatus = "Processing";
		custID = 1; // Need to know how to retrieve custID
		stallID = 2; // Need to know how to retrieve stallID

		oc = new OrderController();
		order = oc.validateCreateOrder(custID, purchaseDate, orderStatus,
				stallID);
		if (custID == 0 || purchaseDate.equals("") || orderStatus.equals("")
				|| stallID == 0)
			JOptionPane.showMessageDialog(null, "Order cannot be created");
		else
			JOptionPane.showMessageDialog(null, "Order ID: " + order);
	}

	public void submitsOrderDetails() {

		for (int i = 0; i < orderDetailsList.size(); i++) {
			odc = new OrderDetailController();
			odc.validateCreateOrderDetail(order, orderDetailsList.get(i)
					.getMenuItemID(), orderDetailsList.get(i).getActualPrice());
			JOptionPane.showMessageDialog(null, (i+1) + "Order Details Added!");
		}
	}
}